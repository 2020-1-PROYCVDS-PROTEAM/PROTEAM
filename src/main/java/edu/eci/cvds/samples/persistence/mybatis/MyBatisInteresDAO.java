
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Interes;
import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.persistence.IniciativaDAO;
import edu.eci.cvds.samples.persistence.InteresDAO;
import edu.eci.cvds.samples.persistence.PersistenceException;
import edu.eci.cvds.samples.persistence.mybatis.mappers.InteresMapper;
import edu.eci.cvds.samples.persistence.mybatis.mappers.IniciativaMapper;


import java.sql.Date;
import java.util.List;

/**
 *
 * @author 
 */
public class MyBatisInteresDAO implements InteresDAO{

    @Inject
    InteresMapper interesMapper;
	@Inject
    IniciativaMapper iniciativaMapper;

    @Override
    public Interes consultarInteres(String idUsuario, int idIniciativa) throws PersistenceException  {
         try{
			 System.out.println("ConsultarVotoMyBatisDAO");
        	 Interes v = interesMapper.consultarInteres(idUsuario,idIniciativa);
			 System.out.println("Despues de consultar voto en mybatisDAO");
            if(v == null) {
				System.out.println("VOTO NULO ENTONCES ARROJA EXCEPTION");
				return null;
            	//throw new PersistenceException("No existe el idUsuario,idIniciativa voto");
            }
            return v;
        }catch(Exception e){
            throw new PersistenceException("Error al consultar el voto:"+e.getLocalizedMessage(), e);   
        }
    }
	
    @Override
    public List<Interes> consultarIntereses() throws PersistenceException {
         try{

            return interesMapper.consultarIntereses();
        }catch(Exception e){
            throw new PersistenceException("Error al consultar los votos:"+e.getLocalizedMessage(), e);   
        }
      
    }
	
	@Override
    public List<Interes> consultarInteresIniciativa(int idIniciativa) throws PersistenceException {
         try{

            return interesMapper.consultarInteresIniciativa(idIniciativa);
        }catch(Exception e){
            throw new PersistenceException("Error al consultar los votos:"+e.getLocalizedMessage(), e);   
        }
      
    }

	@Override
	public void registrarInteres(String idUsuario, int idIniciativa) throws PersistenceException {
		try{
			System.out.println("MyBatisDAO registrando voto");
            interesMapper.registrarInteres(idUsuario,idIniciativa);
			System.out.println("MyBatisDAO DESPUES DE REGISTRANDO voto");
			//iniciativaMapper.agregueVoto(idIniciativa);//ESTO CREO QUE ESTA SUPER ULTRA MAL
			System.out.println("Registro correctamente el voto y la iniciativa ");
        }catch (Exception e) { //org.apache.ibatis.exceptions.PersistenceException

            throw new PersistenceException("Error al registrar el voto de la iniciativa"+e.getLocalizedMessage(), e);

        }
		
	}
	
	@Override
	public void borrarInteres(String idUsuario, int idIniciativa)throws PersistenceException{
		try{
			System.out.println("MyBatisDAO borrando interes");
			interesMapper.borrarInteres(idUsuario,idIniciativa);
			System.out.println("Borro correctamente el interes");
		}catch(Exception e){
			throw new PersistenceException("Error al borrar el voto de la iniciativa"+e.getLocalizedMessage(), e);
		}
	}

    
    
}