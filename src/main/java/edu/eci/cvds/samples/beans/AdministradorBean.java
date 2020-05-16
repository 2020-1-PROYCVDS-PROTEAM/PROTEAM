package edu.eci.cvds.samples.beans;

import java.sql.Date;
import java.util.List;
import java.text.ParseException;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.Services.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

@ManagedBean(name = "AdministradorBean")
@ApplicationScoped
public class AdministradorBean extends BasePageBean implements Serializable {

    private List<Iniciativa> selectsi;
    private List<Iniciativa> iniciativas;
    private int buscar;
    private String nombre;
    private boolean skip;
    private java.util.Date date6;
    private final static String[] rolez;
    private final static String[] ideas;

    static {
        rolez = new String[4];
        rolez[0] = "Administrador";
        rolez[1] = "PMO";
        rolez[2] = "Proponente";
        rolez[3] = "Publico";
    }

    static {
        ideas = new String[4];
        ideas[0] = "En espera de revisión";
        ideas[1] = "En revisión";
        ideas[2] = "Proyecto";
        ideas[3] = "Solucionado";
    }

    @Inject
    private ServicioProteam servicioPT;
    private Usuario usuario;

    public List<String> getRolez() {
        //System.out.println("ADMINISTRADOR GETROLEZ");
        return Arrays.asList(rolez);
    }

    public List<String> getIdeas() {
        //System.out.println("Administrador getIdeas");
        return Arrays.asList(ideas);
    }

    public String completeText(String query) {
        try {
            System.out.println("Entra en completeText || usuario a buscar: " + query);
            return servicioPT.consultarUsuario(query).getCorreo();

        } catch (ServicesException e) {
            System.out.println("Entra en excepcion completeText");
        }
        return null;
    }

    public void relacionarIniciativas() {
        try {
            servicioPT.relacionarIniciativas(selectsi.get(0).getNombre(), selectsi.get(1).getNombre());
        } catch (ServicesException e) {
            System.out.println("no funciona");

        }

    }

    public void consultarIniciativasRelacionadas(String id) {
        try {
            System.out.println(id);
            this.iniciativas = servicioPT.consultarIniciativasRelacionadas(id);
            System.out.println(iniciativas);
        } catch (ServicesException e) {
            System.out.println("no funciona");

        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Usuario consultarUsuario(String usuario) {
        try {
            return servicioPT.consultarUsuario(usuario);
        } catch (ServicesException e) {
            System.out.println("Entra en excepcion UsuarioUnico");
        }
        return null; //esto puede fallar pero vamos a intentar
    }

    public java.sql.Date convertir(java.util.Date fechaUtilDate) {
        //System.out.println("SI ESTA SIENDO LLAMADO");
        return new java.sql.Date(fechaUtilDate.getTime());
    }

    public void registrarIniciativa(String votos, List<String> palabraClave, String nombre, String estado, String descripcion, String area, String usuario_i, String correo_i, java.util.Date fecha_ini) {//Aqui debe ir un casteo de atributos a Date int ...
        System.out.println("Aparece en pantalla");
        try {
            System.out.println("palabras clave: " + palabraClave);
            System.out.println("palabras clave.get(0): " + palabraClave.get(0));
            int idd = servicioPT.consultarIniciativas().size() + 1;
            System.out.println("CHOTO MATEEEEEEE id iniciativa: " + idd);
            int voto = Integer.parseInt(votos);
            Date date = convertir(fecha_ini);
            servicioPT.insertIniciativa(idd, voto, palabraClave.get(0), nombre, estado, descripcion, area, usuario_i, correo_i, date);
            insertarPalabraClave(idd, palabraClave);
        } catch (ServicesException e) {
            System.out.println("Entra en excepcion bean registrarIniciativa");
        }
    }

    public void insertarPalabraClave(int idIniciativa, List<String> palabraClave) {
        try {
            System.out.println("InsertaArPalabraCLAVEEEE!: " + palabraClave);
            for (int i = 0; i < palabraClave.size(); i++) {
                servicioPT.insertarPalabraClave(i + 1, idIniciativa, palabraClave.get(i));
            }
        } catch (ServicesException e) {
            System.out.println("Entra en excepcion ADMINBEAN.insertaRPalabra");
        }

    }

    public void registrarUsuario(String usuario, String passwd, String passwdC, String nombre, String apellido, String correo) {
        System.out.println("Registrar usuario AdministradoBean");
        try {
            if (!passwd.equals(passwdC)) {
                System.out.println("son iguales las claves, validar que lo sean");
            }
            servicioPT.registrarUsuario(usuario, new Sha256Hash(passwd).toHex(), nombre, apellido, correo, "Publico");
            System.out.println("Registro de usuario ok, pero falta redireccionar");
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        } catch (ServicesException e) {
            System.out.println("Entra en excepcion bean registrarIniciativa");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Iniciativa> consultarIniciativas() {
        try {
            System.out.println("AdministradorBEAN INICIATIVA");
            this.iniciativas = servicioPT.consultarIniciativas();
            return iniciativas;
        } catch (ServicesException e) {
            System.out.println("Entra en excepcion bean");

        }
        System.out.println("CONSULTAR INICIATIVAS ESPERO QUE NO PASE POR ACA");
        return null;
    }

    public List<Iniciativa> consultarIniciativasProponente(String usuario) {
        try {
            //System.out.println("Consultando iniciativas del proponente: " + usuario);
            this.iniciativas = servicioPT.consultarIniciativasProponente(usuario);
            //System.out.println("Esto es el retorno: " + iniciativas);
            return iniciativas;
        } catch (ServicesException e) {
            System.out.println("Entra en excepcion bean");

        }
        System.out.println("CONSULTAR INICIATIVAS ESPERO QUE NO PASE POR ACA");
        return null;
    }

    public List<Usuario> consultarUsuarios() {
        List<Usuario> usuarios = null;
        try {
            usuarios = servicioPT.consultarUsuarios();
            //System.out.println("Entra correctamente en ConsultarUsuarioBean");

        } catch (ServicesException e) {
            System.out.println("Entra en excepcion bean");
        }
        //System.out.println("usuarios= "+usuarios);
        return usuarios;
    }

    public void cambiarRol(String usuario, String rol) { //Mirar si toca usar los enum de ROL 
        try {
            System.out.println("ENTRA EN MODIFICAR ROL|| usuario: " + usuario + " rol: " + rol);
            //System.out.println("Usuario val: "+this.usuario);
            servicioPT.cambiarRol(usuario, rol);
        } catch (ServicesException e) {
            System.out.println("Excepcion MODIFICANDO administradorBean");
        }
    }

    public void cambiarEstado(int id, String estado) {
        try {
            System.out.println("ENTRA EN canmbiar INICIATIVA || id: " + id + "estado: " + estado);
            servicioPT.cambiarEstado(id, estado);
        } catch (ServicesException e) {
            System.out.println("Excepcion CAMBIANDO iniciativa administradorBean");
        }
    }

    public void modificarIniciativa(int id, String descripcion) {
        try {
            System.out.println("ENTRA EN canmbiar INICIATIVA || id: " + id + " descripción: " + descripcion);
            servicioPT.modificarIniciativa(id, descripcion);
        } catch (ServicesException e) {
            System.out.println("Excepcion CAMBIANDO iniciativa administradorBean");
        }
    }

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }

    public boolean getSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public Usuario getUsuario() {
        System.out.println("AdministradorBean Usuario solicitado: " + usuario);
        return usuario;
    }

    public void setSelectedUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public java.util.Date getDate6() {
        return date6;
    }

    public void setDate6(java.util.Date date6) {
        this.date6 = date6;
    }

    public List<Iniciativa> getSelectsi() {
        return selectsi;
    }

    public void setSelectsi(List<Iniciativa> selectsi) {
        this.selectsi = selectsi;
    }

    public List<Iniciativa> getIniciativas() {
        if (iniciativas == null) {
            consultarIniciativas();
        }
        return iniciativas;
    }

    public void setIniciativas(List<Iniciativa> iniciativas) {
        this.iniciativas = iniciativas;
    }

    public void onRowSelect(SelectEvent event) {
        Iniciativa prueba = (Iniciativa) event.getObject();
    }

    public int getBuscar() {
        return buscar;
    }

    public void setBuscar(int buscar) {
        this.buscar = buscar;
    }

}
