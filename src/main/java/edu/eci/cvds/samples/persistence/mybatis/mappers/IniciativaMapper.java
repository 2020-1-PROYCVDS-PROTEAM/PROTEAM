package edu.eci.cvds.samples.persistence.mybatis.mappers;

import java.sql.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.persistence.PersistenceException;

public interface IniciativaMapper {

    public Iniciativa palabraClaveIniciativa(@Param("clave") String palabraclave);

    public void insertarPalabraClave(@Param("id") int id, @Param("idIniciativa") int idIniciativa, @Param("palabraClave") String palabraClave);

    public Iniciativa consultarIniciativa(@Param("identificador") int id);

    public List<Iniciativa> consultarIniciativas();

    public List<Iniciativa> consultarIniciativasPalabraClave(@Param("clave") String palabraclave);

    public List<Iniciativa> consultarIniciativasProponente(@Param("usr") String usuario);

    public void insertarIniciativa(@Param("id") int id, @Param("votos") int votos, @Param("palabraClave") String palabraClave, @Param("nombre") String nombre, @Param("estado") String estado, @Param("descripcion") String descripcion, @Param("area") String area, @Param("usuario_i") String usuario_i, @Param("correo_i") String correo_i, @Param("fechar_ini") Date fechar_ini);

    public void cambiarEstado(@Param("id") int id, @Param("estado") String estado);

    public void agregueVoto(@Param("idIniciativa") int idIniciativa);

    public List<Iniciativa> agrupeIniciativas();

    public List<Iniciativa> agrupeEstados();

    public List<Iniciativa> consultarIniciativasRelacionadas(@Param("id") String id);

    public void relacionarIniciativas(@Param("id1") String id1, @Param("id2") String id2);

    public List<Iniciativa> consultarIniciativaPorEstado(@Param("estado") String estado);

    public void modificarIniciativa(@Param("id") int id, @Param("descripcion") String descripcion);

    public List<Iniciativa> consultarIniciativasVotadas(@Param("usuario") String usuario);

    public List<Iniciativa> consultarInteresesIniciativas(@Param("usuario") String usuario);

    public List<Iniciativa> consultarComentariosUsuario(@Param("usuario") String usuario);

}
