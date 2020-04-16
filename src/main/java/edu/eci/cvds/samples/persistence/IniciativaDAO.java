package edu.eci.cvds.samples.persistence;

import java.sql.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Iniciativa;

public interface IniciativaMapper {
	public Iniciativa palabraClaveIniciativas(String palabraclave) throws PersistenceException;	
	public List<Iniciativa> consultarIniciativas() throws PersistenceException;
	public void insertIniciativa(int id,int votos,String nombre,String estado, String descripcion,String area,String usuario_i, String correo_i, Date fechar_ini) throws PersistenceException;
	public void cambiarEstado(int id,EstadoIniciativa estado) throws PersistenceException;
}