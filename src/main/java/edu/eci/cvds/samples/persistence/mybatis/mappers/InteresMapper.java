package edu.eci.cvds.samples.persistence.mybatis.mappers;

import java.sql.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Interes;

public interface InteresMapper {
	public Interes consultarInteres(@Param("idUsuario")String idUsuario, @Param("idIniciativa")int idIniciativa);	
	public List<Interes> consultarIntereses();
	public List<Interes> consultarInteresIniciativa(@Param("idIniciativa")int idIniciativa);
	public void registrarInteres(@Param("idUsuario")String idUsuario, @Param("idIniciativa")int idIniciativa);
	public void borrarInteres(@Param("idUsuario")String idUsuario, @Param("idIniciativa")int idIniciativa);
}