package edu.eci.cvds.samples.persistence;

import java.sql.Date;
import java.util.List;

import edu.eci.cvds.samples.entities.Interes;

public interface InteresDAO {
	public Interes consultarInteres(String idUsuario, int idIniciativa)throws PersistenceException;	
	public List<Interes> consultarIntereses() throws PersistenceException;
	public List<Interes> consultarInteresIniciativa(int idIniciativa) throws PersistenceException;
	public void registrarInteres(String idUsuario, int idIniciativa) throws PersistenceException;
	public void borrarInteres(String idUsuario, int idIniciativa) throws PersistenceException;
	
}