
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Interes;
import edu.eci.cvds.samples.persistence.InteresDAO;
import edu.eci.cvds.samples.persistence.PersistenceException;
import edu.eci.cvds.samples.persistence.mybatis.mappers.InteresMapper;
import edu.eci.cvds.samples.persistence.mybatis.mappers.IniciativaMapper;

import java.util.List;

/**
 *
 * @author
 */
public class MyBatisInteresDAO implements InteresDAO {

    @Inject
    InteresMapper interesMapper;
    @Inject
    IniciativaMapper iniciativaMapper;

    @Override
    public Interes consultarInteres(String idUsuario, int idIniciativa) throws PersistenceException {
        try {
            Interes v = interesMapper.consultarInteres(idUsuario, idIniciativa);
            if (v == null) {
                return null;
            }
            return v;
        } catch (Exception e) {
            throw new PersistenceException("Error al consultar el voto:" + e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<Interes> consultarIntereses() throws PersistenceException {
        try {
            return interesMapper.consultarIntereses();
        } catch (Exception e) {
            throw new PersistenceException("Error al consultar los votos:" + e.getLocalizedMessage(), e);
        }

    }

    @Override
    public List<Interes> consultarInteresIniciativa(int idIniciativa) throws PersistenceException {
        try {
            return interesMapper.consultarInteresIniciativa(idIniciativa);
        } catch (Exception e) {
            throw new PersistenceException("Error al consultar los votos:" + e.getLocalizedMessage(), e);
        }

    }

    @Override
    public void registrarInteres(String idUsuario, int idIniciativa) throws PersistenceException {
        try {
            interesMapper.registrarInteres(idUsuario, idIniciativa);
        } catch (Exception e) {
            throw new PersistenceException("Error al registrar el voto de la iniciativa" + e.getLocalizedMessage(), e);

        }

    }

    @Override
    public void borrarInteres(String idUsuario, int idIniciativa) throws PersistenceException {
        try {
            interesMapper.borrarInteres(idUsuario, idIniciativa);
        } catch (Exception e) {
            throw new PersistenceException("Error al borrar el voto de la iniciativa" + e.getLocalizedMessage(), e);
        }
    }

}
