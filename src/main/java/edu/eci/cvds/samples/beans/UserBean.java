package edu.eci.cvds.samples.beans;

import edu.eci.cvds.samples.entities.Rol;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.entities.Comentario;
import edu.eci.cvds.samples.entities.Voto;
import edu.eci.cvds.samples.entities.Interes;
import edu.eci.cvds.samples.entities.PalabraClave;

import edu.eci.cvds.samples.Services.ServicesException;
import edu.eci.cvds.samples.Services.ServicioProteam;
import edu.eci.cvds.samples.entities.Iniciativa;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import java.util.List;
import java.io.Serializable;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.export.Exporter;

@ManagedBean(name = "UserBean")
@ApplicationScoped
public class UserBean extends BasePageBean implements Serializable {

    private boolean skip;
    private String idPag;
    private Date date;
    private Iniciativa selectedi;
    private List<Iniciativa> selectsi;
    private String palabra;

    @Inject
    private ServicioProteam servicioPT;
    private List<Iniciativa> iniciativas;
    private List<Comentario> comentarios;
    private List<PalabraClave> palabraclave;
    private List<Voto> votos;
	
	
	//public void test(){
	//	System.out.println("POR ACA APARECE");
	//	selectedi = consultarIniciativa("1");
	//}
	

    private void setErrorMessage(Exception e) {
        String message = e.getMessage();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
    }

    public List<Iniciativa> consultarIniciativas() {
        try {
            this.iniciativas = servicioPT.consultarIniciativas();
        } catch (ServicesException e) {
            System.out.println("no funciona");

        }
        return this.iniciativas;

    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public void setIdPag(String iniciativaId) {
        System.out.println("Entra en setIdPag User Bean: " + iniciativaId);
        idPag = iniciativaId;
    }

    public String getIdPag() {
        return idPag;
    }

    public List<Comentario> consultarComentarios() {
        try {
            this.comentarios = servicioPT.consultarComentarios();
        } catch (ServicesException e) {
            System.out.println("no consulta comentarios");

        }
        return this.comentarios;
    }

    public List<Comentario> consultarComentariosIniciativa(String idIniciativa) {
        try {
            int id = Integer.parseInt(idIniciativa);
            this.comentarios = servicioPT.consultarComentariosIniciativa(id);
        } catch (ServicesException e) {
            System.out.println("no consulta comentario iniciativa ");

        }
        return this.comentarios;
    }
    
    public List<Comentario> consultarComentariosIniciativaUsuario(String idUsuario, String idIniciativa) {
        try {
            int id = Integer.parseInt(idIniciativa);
            this.comentarios = servicioPT.consultarComentariosIniciativaUsuario(idUsuario,id);
        } catch (ServicesException e) {
            System.out.println("no consulta comentario iniciativa ");

        }
        return this.comentarios;
    }
    
    

    public Iniciativa consultarIniciativa(String id) {
        try {
            int idd = Integer.parseInt(id);
            return servicioPT.consultarIniciativa(idd);
        } catch (ServicesException e) {
            System.out.println("CAPTURADO EN USERBEAN consultarIniciativa x id");
        }
        return null;
    }

    public List<Iniciativa> consultarIniciativasPalabraClave(String palabraClave) {
        try {
            return servicioPT.consultarIniciativasPalabraClave(palabraClave);
        } catch (ServicesException e) {
            System.out.println("CAPTURADO EN USERBEAN consultarIniciativa x id");

        }
        return null;
    }

    public Iniciativa consultarIniciativaPalabraCLave(String palabraClave) {
        try {
            return servicioPT.palabraClaveIniciativa(palabraClave);
        } catch (ServicesException e) {
            System.out.println("CAPTURADO EN USERBEAN consultarIniciativa x id");
        }
        return null;
    }

    public void insertarComentario(String idUsuario, String idIniciativa, String contenido) {//Aqui debe ir un casteo de atributos a Date int ...
        //System.out.println("Aparece en pantallaUserBean");
        try {
            int idIni = Integer.parseInt(idIniciativa);
            int idd = servicioPT.consultarComentariosIniciativa(idIni).size() + 1;
            Date datex = new Date(Calendar.getInstance().getTime().getTime());
            servicioPT.insertarComentario(idd, idUsuario, idIni, contenido, datex);
        } catch (ServicesException e) {
            System.out.println("Entra en excepcion bean registrarIniciativa");
        }
    }

    public boolean existeVoto(String idUsuario, String idIniciativa) {
      
        try {
			  int idd = Integer.parseInt(idIniciativa);
            Voto voto = servicioPT.consultarVoto(idUsuario, idd);
            if (voto == null) {
                return false;
            } else {
                return true;
            }
        } catch (ServicesException e) {
            System.out.println("No retorna bien el voto");
        }
        return false;
    }

    public void registrarVoto(String idUsuario, String idIniciativa) {
        int idd = Integer.parseInt(idIniciativa);
        try {
            Voto voto = servicioPT.consultarVoto(idUsuario, idd);
            if (voto == null) {
                servicioPT.registrarVoto(idUsuario, idd);
            } else {
                servicioPT.borrarVoto(idUsuario, idd);
            }

        } catch (ServicesException e) {
            System.out.println("Entra en excepcion userBean VotarIniciativa");
        }
    }

    public int consultarVotosIniciativa(int idIniciativa) throws ServicesException {
        try {
            return servicioPT.consultarVotosIniciativa(idIniciativa).size();
        } catch (ServicesException ex) {
            System.out.println("CAPTURANDO EN CONSULTANDO VOTOS DE LA INICIAITVA");
            throw new ServicesException("No hay votos", ex);//en la iniciativa
        }
    }

    public List<Iniciativa> consultarIniciativasVotadas(String usuario) {
        try {
            return servicioPT.consultarIniciativasVotadas(usuario);
        } catch (ServicesException e) {
            System.out.println("CAPTURADO EN USERBEAN consultarIniciativa x id");
        }
        return null;
    }

    public List<Iniciativa> consultarInteresesIniciativas(String usuario) {
        try {
            return servicioPT.consultarInteresesIniciativas(usuario);
        } catch (ServicesException e) {
            System.out.println("CAPTURADO EN USERBEAN consultarIniciativa x id");
        }
        return null;
    }

    public List<Iniciativa> consultarComentariosUsuario(String usuario) {
        try {
			//List<Iniciativa> i=servicioPT.consultarComentariosUsuario(usuario);
			//if(i!=null){
			//	System.out.println("Entra en iniciativas nullas: "+i);
			//	selectedi=i.get(0);
			//	System.out.println("Este es el valor del SELECTEDI: "+selectedi);
			//}
			//System.out.println("NO ENTRO EN ELSE? :"+i);
			//return i;
            return servicioPT.consultarComentariosUsuario(usuario);
        } catch (ServicesException e) {
            System.out.println("CAPTURADO EN USERBEAN consultarComentarios de usuario");
        }
        return null;
    }

    public void setSelectedi(Iniciativa selectIniciativa) {
        selectedi = selectIniciativa;
    }

    public Iniciativa getSelectedi() {
        return selectedi;
    }

    public void setIniciativas(List<Iniciativa> iniciativas) {
        this.iniciativas = iniciativas;
    }

    public List<Iniciativa> getIniciativas() {
        if (iniciativas == null) {
            System.out.println("esnull");
            consultarIniciativas();
			selectedi=iniciativas.get(0);
        }
        return iniciativas;
    }

    public List<String> consultarPalabrasClaveIniciativa(int idIniciaitva) {
        try {
            
            List<PalabraClave> palabrasclave = servicioPT.consultarPalabrasClaveIniciativa(idIniciaitva);
            List<String> palabra = new ArrayList<String>();
            for (PalabraClave p : palabrasclave) {
                palabra.add(p.getPalabraClave());
            }
           
            return palabra;
            //return servicioPT.consultarPalabrasClaveIniciativa(idIniciaitva);
        } catch (ServicesException e) {
            System.out.println("Entra en excepcion userBean GETPALABRASCLAVE");
        }
        return null;
    }

    public void registrarInteres(String idUsuario, String idIniciativa) {
        int idd = Integer.parseInt(idIniciativa);
        try {
           
            Interes interes = servicioPT.consultarInteres(idUsuario, idd);
            if (interes == null) {
                servicioPT.registrarInteres(idUsuario, idd);
            } else {
                servicioPT.borrarInteres(idUsuario, idd);
            }

        } catch (ServicesException e) {
            System.out.println("Entra en excepcion userBean Interes iniciativa");
        }
    }

    public String estadoIniciativa() {  //Esto deberia ir en un bean de iniciativas
        if (selectedi.getEstado().equals("Solucionado")) {
            return "/Solucionado.png";
        } else if (selectedi.getEstado().equals("En revisión")) {
            return "/revision.png";
        } else if (selectedi.getEstado().equals("En espera de revisión")) {
            return "/espera.png";
        } else {
            return "/Proyecto.png";
        }
    }

    public ServicioProteam getServicioPT() {
        return servicioPT;
    }

    public void setServicioPT(ServicioProteam servicioPT) {
        this.servicioPT = servicioPT;
    }

    public List<Iniciativa> getSelectsi() {
        return selectsi;
    }

    public void setSelectsi(List<Iniciativa> selectsi) {
        this.selectsi = selectsi;
    }

    public Date getDate() {
        return new Date(Calendar.getInstance().getTime().getTime());
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
