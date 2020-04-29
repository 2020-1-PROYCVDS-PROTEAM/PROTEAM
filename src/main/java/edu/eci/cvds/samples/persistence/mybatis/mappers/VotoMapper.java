package edu.eci.cvds.samples.persistence.mybatis.mappers;

import java.sql.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Voto;

public interface VotoMapper {
	public Voto consultarVoto(@Param("idUsuario")String idUsuario, @Param("idIniciativa")int idIniciativa);	
	public List<Voto> consultarVotos();
	public List<Voto> consultarVotosIniciativa(@Param("idIniciativa")int idIniciativa);
	public void registrarVoto(@Param("idUsuario")String idUsuario, @Param("idIniciativa")int idIniciativa);
	public void borrarVoto(@Param("idUsuario")String idUsuario, @Param("idIniciativa")int idIniciativa);
}