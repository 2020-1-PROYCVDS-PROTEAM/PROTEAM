package edu.eci.cvds.samples.persistence;

import java.sql.Date;
import java.util.List;

import edu.eci.cvds.samples.entities.Voto;

public interface VotoDAO {
	public Voto consultarVoto(String idUsuario, int idIniciativa)throws PersistenceException;	
	public List<Voto> consultarVotos() throws PersistenceException;
	public List<Voto> consultarVotosIniciativa(int idIniciativa) throws PersistenceException;
	public void registrarVoto(String idUsuario, int idIniciativa) throws PersistenceException;
	public void borrarVoto(String idUsuario, int idIniciativa) throws PersistenceException;
	
}