package edu.eci.cvds.samples.persistence.mybatis.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Rol;
import edu.eci.cvds.samples.entities.Usuario;


public interface UsuarioMapper {

	public Usuario consultarUsuario(@Param("us") String usuario);
	public void registrarUsuario(@Param("usuario")String usuario,@Param("passw")String passw,@Param("correo") String correo,@Param("nombre") String nombre,@Param("apellido") String apellido, @Param("rol") String rol);
	public List<Usuario> consultarUsuarios();
	public void cambiarRol(@Param("usuario") String usuario,@Param("rol")String rol);
}