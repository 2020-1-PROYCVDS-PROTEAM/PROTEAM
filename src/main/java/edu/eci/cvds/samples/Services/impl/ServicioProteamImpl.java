package edu.eci.cvds.samples.Services.impl;

import java.sql.Date;
import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.text.SimpleDateFormat;
import java.text.ParseException;

import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.entities.Comentario;
import edu.eci.cvds.samples.entities.Voto;
import edu.eci.cvds.samples.entities.Interes;
import edu.eci.cvds.samples.entities.PalabraClave;
import edu.eci.cvds.samples.persistence.IniciativaDAO;
import edu.eci.cvds.samples.persistence.ComentarioDAO;
import edu.eci.cvds.samples.persistence.VotoDAO;
import edu.eci.cvds.samples.persistence.InteresDAO;
import edu.eci.cvds.samples.persistence.PalabraClaveDAO;
import edu.eci.cvds.samples.persistence.PersistenceException;
import edu.eci.cvds.samples.persistence.UsuarioDAO;
import edu.eci.cvds.samples.Services.ServicesException;
import edu.eci.cvds.samples.Services.ServicioProteam;

@Singleton
public class ServicioProteamImpl implements ServicioProteam {

    @Inject
    private UsuarioDAO daoUsuario;
    @Inject
    private IniciativaDAO daoIniciativa;
    @Inject
    private ComentarioDAO daoComentario;
    @Inject
    private VotoDAO daoVoto;
    @Inject
    private PalabraClaveDAO daoPalabraClave;
	@Inject 
	private InteresDAO daoInteres;

    @Override
    public Usuario consultarUsuario(String usuario) throws ServicesException {
        try {
            Usuario u = daoUsuario.consultarUsuario(usuario);
            if (u == null) {
                throw new ServicesException("El usuario no existe");
            } else {
                return u;
            }

        } catch (Exception ex) {
            throw new ServicesException("No fue posible consultar el usuario ", ex);
        }
    }

    @Override
    public List<Usuario> consultarUsuarios() throws ServicesException {
        try {
            return daoUsuario.consultarUsuarios();
        } catch (Exception ex) {
            throw new ServicesException("No existen usuarios", ex);
        }
    }

    @Override
    public List<Iniciativa> consultarIniciativasPalabraClave(String palabraclave) throws ServicesException {
        try {
            return daoIniciativa.consultarIniciativasPalabraClave(palabraclave);
        } catch (Exception ex) {
            throw new ServicesException("No fue posible consultar las palabras clave", ex);
        }
    }

    @Override
    public Iniciativa palabraClaveIniciativa(String palabraclave) throws ServicesException {
        try {
            return daoIniciativa.palabraClaveIniciativa(palabraclave);
        } catch (Exception ex) {
            throw new ServicesException("No fue posible consultar la palabra clave", ex);
        }
    }

    @Override
    public Iniciativa consultarIniciativa(int id) throws ServicesException {
        try {
            return daoIniciativa.consultarIniciativa(id);
        } catch (Exception ex) {
            throw new ServicesException("No fue posible consultar la iniciativa", ex);
        }
    }

    @Override
    public List<Iniciativa> consultarIniciativas() throws ServicesException {
        try {
            //System.out.println("ServicioProTeamIMPL INICIATIVA");
            return daoIniciativa.consultarIniciativas();
        } catch (Exception ex) {
            throw new ServicesException("No hay iniciativas", ex);
        }
    }

    @Override
    public Comentario consultarComentario(int id, String idUsuario, int idIniciativa) throws ServicesException {
        try {
            //System.out.println("ServicioProTeamIMPL COMENTARIO");
            return daoComentario.consultarComentario(id, idUsuario, idIniciativa);
        } catch (Exception ex) {
            throw new ServicesException("No fue posible consultar el comentario.", ex);
        }
    }

    @Override
    public List<Comentario> consultarComentarios() throws ServicesException {
        try {
            //System.out.println("ServicioProTeamIMPLCONSULTAR COMENTARIOOS");
            return daoComentario.consultarComentarios();
        } catch (Exception ex) {
            throw new ServicesException("No hay comentarios", ex);
        }
    }

    @Override
    public List<Comentario> consultarComentariosIniciativa(int idIniciativa) throws ServicesException {
        try {
            //System.out.println("ServicioProTeamIMPLCONSULTAR COMENTARIOOSIniciativa");
            return daoComentario.consultarComentariosIniciativa(idIniciativa);
        } catch (Exception ex) {
            throw new ServicesException("No hay comentarios", ex);//en la iniciativa
        }
    }

    @Override
    public void insertIniciativa(int id, int votos, String palabraClave, String nombre, String estado, String descripcion, String area, String usuario_i, String correo_i, Date fechar_ini) throws ServicesException {
        try {
            daoIniciativa.insertIniciativa(id, votos, palabraClave, nombre, estado, descripcion, area, usuario_i, correo_i, fechar_ini);
        } catch (Exception ex) {
            throw new ServicesException("No fue posible agregar la nueva iniciativa", ex);
        }
    }

    @Override
    public void registrarUsuario(String usuario, String passwd, String nombre, String apellido, String correo, String rol) throws ServicesException {
        try {

            daoUsuario.registrarUsuario(usuario, passwd, nombre, apellido, correo, rol);
        } catch (Exception ex) {
            throw new ServicesException("No fue posible registrar el usuario", ex);
        }
    }

    @Override
    public void cambiarEstado(int id, String estado) throws ServicesException {
        try {
            daoIniciativa.cambiarEstado(id, estado);
        } catch (Exception ex) {
            throw new ServicesException("No fue posible cambiar el estado", ex);
        }
    }

    @Override
    public void cambiarRol(String usuario, String rol) throws ServicesException {
        try {
            System.out.println("ENTRA EN SERVICIOSPT CAMBIARROL");
            daoUsuario.cambiarRol(usuario, rol);
        } catch (Exception ex) {
            throw new ServicesException("No fue posible modificar el rol", ex);
        }
    }

    @Override
    public void insertarComentario(int id, String idUsuario, int idIniciativa, String contenido, Date fecha) throws ServicesException {
        try {

            daoComentario.insertarComentario(id, idUsuario, idIniciativa, contenido, fecha);
        } catch (Exception ex) {
            throw new ServicesException("No fue posible agregar el nuevo comentario", ex);
        }
    }

    @Override
    public void cambiarComentario(int id, String idUsuario, int idIniciativa, String contenido) throws ServicesException {
        try {
            daoComentario.cambiarComentario(id, idUsuario, idIniciativa, contenido);
        } catch (Exception ex) {
            throw new ServicesException("No fue posible cambiar el comentario", ex);
        }
    }

    @Override
    public Voto consultarVoto(String idUsuario, int idIniciativa) throws ServicesException {
        try {
            return daoVoto.consultarVoto(idUsuario, idIniciativa);
        } catch (Exception ex) {
            throw new ServicesException("No fue posible consultar el voto.", ex);
        }
    }

    @Override
    public List<Voto> consultarVotos() throws ServicesException {
        try {
            System.out.println("ServicioProTeamIMPLCONSULTAR VOTOS");
            return daoVoto.consultarVotos();
        } catch (Exception ex) {
            throw new ServicesException("No hay votos", ex);
        }
    }

    @Override
    public List<Voto> consultarVotosIniciativa(int idIniciativa) throws ServicesException {
        try {

            return daoVoto.consultarVotosIniciativa(idIniciativa);
        } catch (Exception ex) {
            throw new ServicesException("No hay votos", ex);//en la iniciativa
        }
    }

    @Override
    public void registrarVoto(String idUsuario, int idIniciativa) throws ServicesException {
        try {
            daoVoto.registrarVoto(idUsuario, idIniciativa);
        } catch (Exception ex) {
            throw new ServicesException("No fue posible agregar el nuevo voto", ex);
        }
    }

    @Override
    public void borrarVoto(String idUsuario, int idIniciativa) throws ServicesException {
        try {
            daoVoto.borrarVoto(idUsuario, idIniciativa);
            System.out.println("Borro efectivamente el voto del usuario: "+idUsuario+" de la iniciativa: "+idIniciativa);
        } catch (Exception ex) {
            throw new ServicesException("No fue posible borrar el voto", ex);
        }
    }

    @Override
    public List<Iniciativa> agrupeIniciativas() throws ServicesException {
        try {
            return daoIniciativa.agrupeIniciativas();
        } catch (Exception ex) {
            throw new ServicesException("No fue posible agrupar las iniciativas", ex);
        }
    }

    @Override
    public List<Iniciativa> agrupeEstados() throws ServicesException {
        try {
            return daoIniciativa.agrupeEstados();
        } catch (Exception ex) {
            throw new ServicesException("No fue posible agrupar las iniciativas por estado", ex);
        }
    }

    @Override
    public void insertarPalabraClave(int id, int idIniciativa, String palabraClave) throws ServicesException {
        try {
            daoIniciativa.insertarPalabraClave(id, idIniciativa, palabraClave);
        } catch (Exception ex) {
            throw new ServicesException("No fue posible agregar la nueva palabra clave", ex);
        }
    }

    @Override
    public void relacionarIniciativas(String id1, String id2) throws ServicesException {
        try {
            daoIniciativa.relacionarIniciativas(id1, id2);
        } catch (Exception ex) {
            throw new ServicesException("No fue posible agregar la nueva palabra clave", ex);
        }

    }

    @Override
    public List<Iniciativa> consultarIniciativasRelacionadas(String id) throws ServicesException {
        try {
            return daoIniciativa.consultarIniciativasRelacionadas(id);
        } catch (Exception ex) {
            throw new ServicesException("No fue posible consultar las iniciativas relacionadas", ex);
        }
    }

    @Override
    public List<PalabraClave> consultarPalabrasClaveIniciativa(int idIniciativa) throws ServicesException {
        try {
            return daoPalabraClave.consultarPalabrasClaveIniciativa(idIniciativa);
        } catch (Exception ex) {
            throw new ServicesException("No fue posible consultar las palabras claves de la iniciativa", ex);
        }

    }

    @Override
    public List<Iniciativa> consultarIniciativaPorEstado(String estado) throws ServicesException {
        try {
            return daoIniciativa.consultarIniciativaPorEstado(estado);
        } catch (Exception ex) {
            throw new ServicesException("No fue posible consultar las iniciativas con ese estado", ex);
        }
    }

    @Override
    public void modificarIniciativa(int id, String descripcion) throws ServicesException {
        try {
            daoIniciativa.modificarIniciativa(id, descripcion);
        } catch (Exception ex) {
            throw new ServicesException("No fue posible modificar la iniciativa", ex);
        }
    }

    @Override
    public List<Iniciativa> consultarIniciativasProponente(String usuario) throws ServicesException {
        try {
            return daoIniciativa.consultarIniciativasProponente(usuario);
        } catch (Exception ex) {
            throw new ServicesException("No fue posible consultar las iniciativas del proponente", ex);
        }
    }
	
	@Override
    public List<Iniciativa> consultarIniciativasVotadas(String usuario) throws ServicesException {
        try {
            return daoIniciativa.consultarIniciativasVotadas(usuario);
        } catch (Exception ex) {
            throw new ServicesException("No fue posible consultar las iniciativas del proponente", ex);
        }
    }
	
	@Override
    public List<Iniciativa> consultarComentariosUsuario(String usuario) throws ServicesException {
        try {
            return daoIniciativa.consultarComentariosUsuario(usuario);
        } catch (Exception ex) {
            throw new ServicesException("No fue posible consultar los comentarios del usuario", ex);
        }
    }
	
    @Override
    public List<Iniciativa> consultarInteresesIniciativas(String usuario) throws ServicesException {
        try {
            return daoIniciativa.consultarInteresesIniciativas(usuario);
        } catch (Exception ex) {
            throw new ServicesException("No fue posible consultar las iniciativas del proponente", ex);
        }
    }
	
	
   @Override
    public Interes consultarInteres(String idUsuario, int idIniciativa) throws ServicesException {
        try {
            return daoInteres.consultarInteres(idUsuario, idIniciativa);
        } catch (Exception ex) {
            throw new ServicesException("No fue posible consultar el voto.", ex);
        }
    }

    @Override
    public List<Interes> consultarIntereses() throws ServicesException {
        try {
            System.out.println("ServicioProTeamIMPLCONSULTAR VOTOS");
            return daoInteres.consultarIntereses();
        } catch (Exception ex) {
            throw new ServicesException("No hay votos", ex);
        }
    }

    @Override
    public List<Interes> consultarInteresIniciativa(int idIniciativa) throws ServicesException {
        try {

            return daoInteres.consultarInteresIniciativa(idIniciativa);
        } catch (Exception ex) {
            throw new ServicesException("No hay votos", ex);//en la iniciativa
        }
    }

    @Override
    public void registrarInteres(String idUsuario, int idIniciativa) throws ServicesException {
        try {
            daoInteres.registrarInteres(idUsuario, idIniciativa);
        } catch (Exception ex) {
            throw new ServicesException("No fue posible agregar el nuevo voto", ex);
        }
    }

    @Override
    public void borrarInteres(String idUsuario, int idIniciativa) throws ServicesException {
        try {
            daoInteres.borrarInteres(idUsuario, idIniciativa);
            System.out.println("Elimino el interes del usuario: "+idUsuario+" de la iniciativa: "+idIniciativa);
        } catch (Exception ex) {
            System.out.println("ENTRO EN NO PUDE BORRAR EL INTERES");
            throw new ServicesException("No fue posible eliminar el interes", ex);
        }
    }	

}
