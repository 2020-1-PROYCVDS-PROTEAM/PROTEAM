package edu.eci.cvds.samples.persistence.mybatis.mappers;

import java.sql.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Iniciativa;

public interface IniciativaMapper {
	public Iniciativa palabraClaveIniciativa(@Param("passw") String palabraclave);	
	public Iniciativa consultarIniciativa(@Param("id") int id);	
	public List<Iniciativa> consultarIniciativas();
	public void insertarIniciativa(@Param("id") int id,@Param("votos") int votos,@Param("palabraClave") String palabraClave,@Param("nombre") String nombre,@Param("estado") String estado,@Param("descripcion") String descripcion,@Param("area") String area,@Param("usuario_i") String usuario_i,@Param("correo_i") String correo_i,@Param("fechar_ini") Date fechar_ini);
	public void cambiarEstado(@Param("id") int id,@Param("estado") String estado);
}