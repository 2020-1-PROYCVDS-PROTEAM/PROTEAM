package edu.eci.cvds.samples.Services;

import java.sql.Date;
import java.util.List;

import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.entities.Comentario;
import edu.eci.cvds.samples.entities.Voto;

public interface ServicioProteam {
	
	
	public abstract Usuario consultarUsuario(String usuario)throws ServicesException;
	public abstract List<Usuario> consultarUsuarios()throws ServicesException;
	public abstract Iniciativa palabraClaveIniciativa(String palabraclave) throws ServicesException;	
	public abstract Iniciativa consultarIniciativa(int id)throws ServicesException;	
	public abstract List<Iniciativa> consultarIniciativas() throws ServicesException;
	public abstract Comentario consultarComentario(int id, String idUsuario, int idIniciativa)throws ServicesException;
	public List<Comentario> consultarComentarios() throws ServicesException;
	public List<Comentario> consultarComentariosIniciativa(int idIniciativa) throws ServicesException;
	public abstract Voto consultarVoto(String idUsuario, int idIniciativa) throws ServicesException;
	public abstract List<Voto> consultarVotos() throws ServicesException;
	public abstract List<Voto> consultarVotosIniciativa(int idIniciativa) throws ServicesException;
	public abstract void insertIniciativa(int id,int votos,String palabraClave,String nombre,String estado, String descripcion,String area,String usuario_i, String correo_i, Date fechar_ini) throws ServicesException;
	public abstract void registrarUsuario(String usuario,String passwd,String nombre,String apellido,String correo,String rol) throws ServicesException;
	public abstract void cambiarEstado(int id,String estado) throws ServicesException;
	public abstract void cambiarRol(String usuario, String rol) throws ServicesException;
	public abstract void insertarComentario(int id, String idUsuario, int idIniciativa, String contenido, Date fecha) throws ServicesException;
	public abstract void cambiarComentario(int id, String idUsuario, int idIniciativa, String contenido) throws ServicesException;
	public abstract void registrarVoto(String idUsuario, int idIniciativa) throws ServicesException;
	public abstract void borrarVoto(String idUsuario, int idIniciativa) throws ServicesException;
}
