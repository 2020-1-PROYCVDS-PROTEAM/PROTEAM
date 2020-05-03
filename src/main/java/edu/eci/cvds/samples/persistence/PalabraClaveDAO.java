package edu.eci.cvds.samples.persistence;

import java.sql.Date;
import java.util.List;


import edu.eci.cvds.samples.Services.ServicesException;
import edu.eci.cvds.samples.entities.PalabraClave;

public interface PalabraClaveDAO {
	public List<PalabraClave> consultarPalabrasClave() throws PersistenceException;	
	public List<PalabraClave> consultarPalabrasClaveIniciativa(int idIniciativa) throws PersistenceException;	
	//public void insertarPalabraClave(int id,int idIniciativa,String palabraClave) throws PersistenceException;	
}