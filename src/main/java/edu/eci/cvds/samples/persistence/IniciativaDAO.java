package edu.eci.cvds.samples.persistence;

import java.sql.Date;
import java.util.List;

import edu.eci.cvds.samples.entities.Iniciativa;

public interface IniciativaDAO {
	public Iniciativa palabraClaveIniciativa(String palabraclave) throws PersistenceException;	
	public Iniciativa consultarIniciativa(int id)throws PersistenceException;	
	public List<Iniciativa> consultarIniciativas() throws PersistenceException;
	public void insertIniciativa(int id,int votos,String nombre,String estado, String descripcion,String area,String usuario_i, String correo_i, Date fechar_ini) throws PersistenceException;
	public void cambiarEstado(int id,String estado) throws PersistenceException;
}