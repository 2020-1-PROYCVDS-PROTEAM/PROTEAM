
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.PalabraClave;
import edu.eci.cvds.samples.persistence.PalabraClaveDAO;
import edu.eci.cvds.samples.persistence.PersistenceException;
import edu.eci.cvds.samples.persistence.mybatis.mappers.PalabraClaveMapper;


import java.util.List;

/**
 *
 * @author 
 */
public class MyBatisPalabraClaveDAO implements PalabraClaveDAO{

    @Inject
    PalabraClaveMapper palabraClaveMapper;
    
    @Override
    public List<PalabraClave> consultarPalabrasClave() throws PersistenceException {
         try{
             System.out.println("Entra en DAOMybatisPalabrasclave CONSULTARPALABRAS CLAVE");
            return palabraClaveMapper.consultarPalabrasClave();
        }catch(Exception e){
            System.out.println("CAPTURADO EN EXCEPCION consultarPalabras");
            throw new PersistenceException("Error al consultar las palabras clave:"+e.getLocalizedMessage(), e);   
        }
      
    }

	@Override
	public List<PalabraClave> consultarPalabrasClaveIniciativa(int idIniciativa) throws PersistenceException {
            try{   
                System.out.println("Entra en DAOMybatisPalabrasclave Iniciativas palabrasCLAVE");
                return palabraClaveMapper.consultarPalabrasClaveIniciativa(idIniciativa);
           }catch(Exception e){
               System.out.println("CAPTURADO EN EXCEPCION consultas Paabras inciativa");
               throw new PersistenceException("Error al consultar la palabra clave:"+e.getLocalizedMessage(), e);   
           }	
	}
	
//	@Override
//	public void insertarPalabraClave(int id, int idIniciativa,String palabraClave) throws PersistenceException {
//		 try{
//                System.out.println("ENTRANDO EN INSERTARPALABRACLAVE MYBATISDAOpalabraClave");
//                palabraClaveMapper.insertarPalabraClave(id, idIniciativa,palabraClave);
//	        }catch(Exception e){
//                    System.out.println("ATRAPADO EN MYBATISDAOpalabraClave");
//	            throw new PersistenceException("Error al insertar  la palabraClave:"+e.getLocalizedMessage(), e);   
//	        }	
//		
//	}

    
}