package edu.eci.cvds.samples.Services;

import java.sql.Date;
import java.util.List;

import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.entities.Comentario;
import edu.eci.cvds.samples.entities.Voto;
import edu.eci.cvds.samples.entities.Interes;
import edu.eci.cvds.samples.entities.Estadistica;
import edu.eci.cvds.samples.entities.PalabraClave;
import edu.eci.cvds.samples.persistence.PersistenceException;

public interface ServicioProteam {

    public abstract Usuario consultarUsuario(String usuario) throws ServicesException;

    public abstract List<Usuario> consultarUsuarios() throws ServicesException;

    public abstract Iniciativa palabraClaveIniciativa(String palabraclave) throws ServicesException;

    public abstract List<Iniciativa> consultarIniciativasPalabraClave(String palabraclave) throws ServicesException;

    public abstract void insertarPalabraClave(int id, int idIniciativa, String palabraClave) throws ServicesException;

    public abstract Iniciativa consultarIniciativa(int id) throws ServicesException;

    public abstract List<Iniciativa> consultarIniciativas() throws ServicesException;

    public abstract Comentario consultarComentario(int id, String idUsuario, int idIniciativa) throws ServicesException;

    public List<Comentario> consultarComentarios() throws ServicesException;

    public List<Comentario> consultarComentariosIniciativa(int idIniciativa) throws ServicesException;

    public abstract Voto consultarVoto(String idUsuario, int idIniciativa) throws ServicesException;

    public abstract List<Voto> consultarVotos() throws ServicesException;

    public abstract List<Voto> consultarVotosIniciativa(int idIniciativa) throws ServicesException;

    public abstract void insertIniciativa(int id, int votos, String palabraClave, String nombre, String estado, String descripcion, String area, String usuario_i, String correo_i, Date fechar_ini) throws ServicesException;

    public abstract void registrarUsuario(String usuario, String passwd, String nombre, String apellido, String correo, String rol) throws ServicesException;

    public abstract void cambiarEstado(int id, String estado) throws ServicesException;

    public abstract void cambiarRol(String usuario, String rol) throws ServicesException;

    public abstract void insertarComentario(int id, String idUsuario, int idIniciativa, String contenido, Date fecha) throws ServicesException;

    public abstract void cambiarComentario(int id, String idUsuario, int idIniciativa, String contenido) throws ServicesException;

    public abstract void registrarVoto(String idUsuario, int idIniciativa) throws ServicesException;

    public abstract void borrarVoto(String idUsuario, int idIniciativa) throws ServicesException;

    public abstract void relacionarIniciativas(String id1, String id2) throws ServicesException;

    public List<Iniciativa> consultarIniciativasRelacionadas(String id) throws ServicesException;

    public abstract List<Estadistica> agrupeIniciativas() throws ServicesException;

    public abstract List<Estadistica> agrupeEstados() throws ServicesException;

    public abstract List<PalabraClave> consultarPalabrasClaveIniciativa(int idIniciativa) throws ServicesException;

    public abstract List<Iniciativa> consultarIniciativaPorEstado(String estado) throws ServicesException;

    public List<Iniciativa> consultarIniciativasProponente(String usuario) throws ServicesException;

    public abstract void modificarIniciativa(int id, String descripcion) throws ServicesException;

    public abstract List<Iniciativa> consultarIniciativasVotadas(String usuario) throws ServicesException;

    public abstract List<Iniciativa> consultarComentariosUsuario(String usuario) throws ServicesException;

    public abstract Interes consultarInteres(String idUsuario, int idIniciativa) throws ServicesException;

    public abstract List<Interes> consultarIntereses() throws ServicesException;

    public abstract List<Interes> consultarInteresIniciativa(int idIniciativa) throws ServicesException;

    public abstract void registrarInteres(String idUsuario, int idIniciativa) throws ServicesException;

    public abstract void borrarInteres(String idUsuario, int idIniciativa) throws ServicesException;

    public List<Iniciativa> consultarInteresesIniciativas(String usuario) throws ServicesException;

}
