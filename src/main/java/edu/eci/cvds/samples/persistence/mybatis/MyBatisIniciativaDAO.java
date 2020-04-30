
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.persistence.IniciativaDAO;
import edu.eci.cvds.samples.persistence.PersistenceException;
import edu.eci.cvds.samples.persistence.mybatis.mappers.IniciativaMapper;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author 
 */
public class MyBatisIniciativaDAO implements IniciativaDAO{

    @Inject
    IniciativaMapper iniciativaMapper;
    

    @Override
    public Iniciativa consultarIniciativa(int id) throws PersistenceException  {
         try{
        	 Iniciativa i = iniciativaMapper.consultarIniciativa(id);
            if(i == null) {
            	throw new PersistenceException("No existe el Id iniciativa");
            }
            return i;
        }catch(Exception e){
            throw new PersistenceException("Error al consultar la iniciativa:"+e.getLocalizedMessage(), e);   
        }
    }
    @Override
    public List<Iniciativa> consultarIniciativas() throws PersistenceException {
         try{

            return iniciativaMapper.consultarIniciativas();
        }catch(Exception e){
            throw new PersistenceException("Error al consultar las iniciativas:"+e.getLocalizedMessage(), e);   
        }
      
    }

	@Override
	public Iniciativa palabraClaveIniciativa(String palabraclave) throws PersistenceException {
         try{
        	return iniciativaMapper.palabraClaveIniciativa(palabraclave);
        }catch(Exception e){
            throw new PersistenceException("Error al consultar la iniciativa:"+e.getLocalizedMessage(), e);   
        }	
	}
	@Override
	public void insertIniciativa(int id, int votos,String palabraClave, String nombre, String estado, String descripcion, String area, String usuario_i, String correo_i, Date fechar_ini) throws PersistenceException {
		 try{
                System.out.println("Se cuentra en mybatisDaoInsertarIniciativa");
                iniciativaMapper.insertarIniciativa(id, votos,palabraClave, nombre, estado, descripcion, area, usuario_i, correo_i, fechar_ini);
	        }catch(Exception e){
                    System.out.println("ATRAPADO EN MYBATISDAOINICIATIVA");
	            throw new PersistenceException("Error al insertar  la iniciativa:"+e.getLocalizedMessage(), e);   
	        }	
		
	}

	@Override
	public void cambiarEstado(int id, String estado) throws PersistenceException {
		try {
			System.out.println("MyBatisDAO modificando estado");
            iniciativaMapper.cambiarEstado(id,estado);
			System.out.println("Cambui la idea");
        } catch (Exception e) { //org.apache.ibatis.exceptions.PersistenceException

            throw new PersistenceException("Error al cambiar estado iniciativa"+e.getLocalizedMessage(), e);

        }
		
	}

	@Override
	public List<Iniciativa> agrupeIniciativas() throws PersistenceException {
		try {
                    System.out.println("MyBatisDAO agrupando  Iniciativa");
                    System.out.println("Probando el retorno: "+iniciativaMapper.agrupeIniciativas());
                    return iniciativaMapper.agrupeIniciativas();
			
        } catch (Exception e) { //org.apache.ibatis.exceptions.PersistenceException
			System.out.println("Este es el error: "+e);
            throw new PersistenceException("Error al agrupar la iniciativa"+e.getLocalizedMessage(), e);

        }
		
	}
	@Override
	public void insertarPalabraClave(int id, int idIniciativa, String palabraClave) throws PersistenceException {
		 try{
                       iniciativaMapper.insertarPalabraClave(id, idIniciativa, palabraClave);
	        }catch(Exception e){
                    System.out.println("SE ATRAPO EN MYBATISDAOBROU");
	            throw new PersistenceException("Error al insertar  la palabra clave:"+e.getLocalizedMessage(), e);   
	        }	
		
	} 
 
    
}