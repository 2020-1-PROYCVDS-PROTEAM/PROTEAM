package edu.eci.cvds.samples.persistence.mybatis.mappers;

import java.sql.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Comentario;

public interface ComentarioMapper {
	public Comentario consultarComentario(@Param("id") int id, @Param("idUsuario")String idUsuario, @Param("idIniciativa")int idIniciativa);	
	public List<Comentario> consultarComentarios();
	public List<Comentario> consultarComentariosIniciativa(@Param("idIniciativa")int idIniciativa);
	public void insertarComentario(@Param("id") int id, @Param("idUsuario")String idUsuario, @Param("idIniciativa")int idIniciativa, @Param("contenido")String contenido, @Param("fecha") Date fecha);
	public void cambiarComentario(@Param("id") int id, @Param("idUsuario")String idUsuario, @Param("idIniciativa")int idIniciativa, @Param("contenido")String contenido);
}