package edu.eci.cvds.samples.persistence;

import java.sql.Date;
import java.util.List;

import edu.eci.cvds.samples.entities.Iniciativa;

public interface IniciativaDAO {

    public Iniciativa palabraClaveIniciativa(String palabraclave) throws PersistenceException;

    public List<Iniciativa> consultarIniciativasPalabraClave(String palabraclave) throws PersistenceException;

    public void insertarPalabraClave(int id, int idIniciativa, String palabraClave) throws PersistenceException;

    public Iniciativa consultarIniciativa(int id) throws PersistenceException;

    public List<Iniciativa> consultarIniciativas() throws PersistenceException;

    public List<Iniciativa> consultarIniciativasProponente(String usuario) throws PersistenceException;

    public void insertIniciativa(int id, int votos, String palabraClave, String nombre, String estado, String descripcion, String area, String usuario_i, String correo_i, Date fechar_ini) throws PersistenceException;

    public void cambiarEstado(int id, String estado) throws PersistenceException;

    public abstract void relacionarIniciativas(String id1, String id2) throws PersistenceException;

    public List<Iniciativa> consultarIniciativasRelacionadas(String id) throws PersistenceException;

    public List<Iniciativa> agrupeIniciativas() throws PersistenceException;

    public List<Iniciativa> agrupeEstados() throws PersistenceException;

    public List<Iniciativa> consultarIniciativaPorEstado(String estado) throws PersistenceException;

    public void modificarIniciativa(int id, String descripcion) throws PersistenceException;

    public List<Iniciativa> consultarIniciativasVotadas(String usuario) throws PersistenceException;

    public List<Iniciativa> consultarInteresesIniciativas(String usuario) throws PersistenceException;

    public List<Iniciativa> consultarComentariosUsuario(String usuario) throws PersistenceException;

}
