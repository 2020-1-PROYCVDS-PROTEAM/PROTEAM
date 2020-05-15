
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Comentario;
import edu.eci.cvds.samples.persistence.ComentarioDAO;
import edu.eci.cvds.samples.persistence.PersistenceException;
import edu.eci.cvds.samples.persistence.mybatis.mappers.ComentarioMapper;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author 
 */
public class MyBatisComentarioDAO implements ComentarioDAO{

    @Inject
    ComentarioMapper comentarioMapper;
    

    @Override
    public Comentario consultarComentario(int id, String idUsuario, int idIniciativa) throws PersistenceException  {
         try{
        	 Comentario c = comentarioMapper.consultarComentario(id,idUsuario,idIniciativa);
            if(c == null) {
            	throw new PersistenceException("No existe el id,idUsuario,idIniciativa comentario");
            }
            return c;
        }catch(Exception e){
            throw new PersistenceException("Error al consultar el comentario:"+e.getLocalizedMessage(), e);   
        }
    }
	
    @Override
    public List<Comentario> consultarComentarios() throws PersistenceException {
         try{

            return comentarioMapper.consultarComentarios();
        }catch(Exception e){
            throw new PersistenceException("Error al consultar los comentarios:"+e.getLocalizedMessage(), e);   
        }
      
    }
    
    @Override
    public List<Comentario> consultarComentariosIniciativaUsuario(String idUsuario, int idIniciativa) throws PersistenceException {
         try{

            return comentarioMapper.consultarComentariosIniciativaUsuario(idUsuario, idIniciativa);
        }catch(Exception e){
            throw new PersistenceException("Error al consultar los comentarios:"+e.getLocalizedMessage(), e);   
        }
      
    }
    
	
	@Override
    public List<Comentario> consultarComentariosIniciativa(int idIniciativa) throws PersistenceException {
         try{

            return comentarioMapper.consultarComentariosIniciativa(idIniciativa);
        }catch(Exception e){
            throw new PersistenceException("Error al consultar los comentarios:"+e.getLocalizedMessage(), e);   
        }
      
    }


	@Override
	public void insertarComentario(int id, String idUsuario, int idIniciativa, String contenido, Date fecha) throws PersistenceException {
		 try{
                System.out.println("Se cuentra en mybatisDaoInsertarCOMENTARIO");
                comentarioMapper.insertarComentario(id,idUsuario,idIniciativa,contenido,fecha);
	        }catch(Exception e){
                    System.out.println("Fue atrapado intentando insertarComentario MyBatisDaoComentario");
	            throw new PersistenceException("Error al insertar el comentario:"+e.getLocalizedMessage(), e);   
	        }	
		
	}

	@Override
	public void cambiarComentario(int id, String idUsuario, int idIniciativa, String contenido) throws PersistenceException {
		try {
			System.out.println("MyBatisDAO cambiando comentario");
            comentarioMapper.cambiarComentario(id,idUsuario,idIniciativa,contenido);
			System.out.println("Cambio correctamente el comentario");
        } catch (Exception e) { //org.apache.ibatis.exceptions.PersistenceException

            throw new PersistenceException("Error al cambiar el contenido del comentario"+e.getLocalizedMessage(), e);

        }
		
	}

    
    
}