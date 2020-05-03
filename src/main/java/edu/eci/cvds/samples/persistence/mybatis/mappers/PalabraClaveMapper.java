package edu.eci.cvds.samples.persistence.mybatis.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.PalabraClave;

public interface PalabraClaveMapper {
	public List<PalabraClave> consultarPalabrasClave();
	public List<PalabraClave> consultarPalabrasClaveIniciativa(@Param("idiniciativa") int idiniciativa);
	//public void insertarPalabraClave(@Param("id") int id,@Param("idiniciativa") int idiniciativa,@Param("palabraclave") String palabraclave);
}