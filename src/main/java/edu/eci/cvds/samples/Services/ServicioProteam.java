package edu.eci.cvds.samples.Services;

import java.sql.Date;
import java.util.List;

import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.Usuario;


public interface ServicioProteam {
	
	
	public Usuario consultarUsuario(String usuario)throws ServicesException;
	public List<Usuario> consultarUsuarios()throws ServicesException;
	public Iniciativa palabraClaveIniciativa(String palabraclave) throws ServicesException;	
	public Iniciativa consultarIniciativa(int id)throws ServicesException;	
	public List<Iniciativa> consultarIniciativas() throws ServicesException;
	public void insertIniciativa(int id,int votos,String nombre,String estado, String descripcion,String area,String usuario_i, String correo_i, Date fechar_ini) throws ServicesException;
	public void cambiarEstado(int id,String estado) throws ServicesException;
}
