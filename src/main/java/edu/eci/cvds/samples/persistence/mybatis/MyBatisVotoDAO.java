
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Voto;
import edu.eci.cvds.samples.persistence.VotoDAO;
import edu.eci.cvds.samples.persistence.PersistenceException;
import edu.eci.cvds.samples.persistence.mybatis.mappers.VotoMapper;
import edu.eci.cvds.samples.persistence.mybatis.mappers.IniciativaMapper;

import java.util.List;

/**
 *
 * @author
 */
public class MyBatisVotoDAO implements VotoDAO {

    @Inject
    VotoMapper votoMapper;
    @Inject
    IniciativaMapper iniciativaMapper;

    @Override
    public Voto consultarVoto(String idUsuario, int idIniciativa) throws PersistenceException {
        try {
            Voto v = votoMapper.consultarVoto(idUsuario, idIniciativa);
            if (v == null) {
                return null;
            }
            return v;
        } catch (Exception e) {
            throw new PersistenceException("Error al consultar el voto:" + e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<Voto> consultarVotos() throws PersistenceException {
        try {
            return votoMapper.consultarVotos();
        } catch (Exception e) {
            throw new PersistenceException("Error al consultar los votos:" + e.getLocalizedMessage(), e);
        }

    }

    @Override
    public List<Voto> consultarVotosIniciativa(int idIniciativa) throws PersistenceException {
        try {
            return votoMapper.consultarVotosIniciativa(idIniciativa);
        } catch (Exception e) {
            throw new PersistenceException("Error al consultar los votos:" + e.getLocalizedMessage(), e);
        }

    }

    @Override
    public void registrarVoto(String idUsuario, int idIniciativa) throws PersistenceException {
        try {
            votoMapper.registrarVoto(idUsuario, idIniciativa);
            iniciativaMapper.agregueVoto(idIniciativa);
        } catch (Exception e) { 
            throw new PersistenceException("Error al registrar el voto de la iniciativa" + e.getLocalizedMessage(), e);
        }

    }

    @Override
    public void borrarVoto(String idUsuario, int idIniciativa) throws PersistenceException {
        try {
            votoMapper.borrarVoto(idUsuario, idIniciativa);
        } catch (Exception e) {
            throw new PersistenceException("Error al borrar el voto de la iniciativa" + e.getLocalizedMessage(), e);
        }
    }

}
