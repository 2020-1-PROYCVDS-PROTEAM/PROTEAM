package edu.eci.cvds.samples.persistence;

import java.sql.Date;
import java.util.List;

import edu.eci.cvds.samples.entities.Comentario;

public interface ComentarioDAO {
	public Comentario consultarComentario(int id, String idUsuario, int idIniciativa)throws PersistenceException;	
	public List<Comentario> consultarComentarios() throws PersistenceException;
	public List<Comentario> consultarComentariosIniciativa(int idIniciativa) throws PersistenceException;
        public List<Comentario> consultarComentariosIniciativaUsuario(String idUsuario, int idIniciativa) throws PersistenceException;
	public void insertarComentario(int id, String idUsuario, int idIniciativa, String contenido, Date fecha) throws PersistenceException;
	public void cambiarComentario(int id, String idUsuario, int idIniciativa, String contenido) throws PersistenceException;
	
}