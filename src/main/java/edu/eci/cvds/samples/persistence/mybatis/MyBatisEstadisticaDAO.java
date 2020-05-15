/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Estadistica;
import edu.eci.cvds.samples.persistence.EstadisticaDAO;
import edu.eci.cvds.samples.persistence.PersistenceException;
import edu.eci.cvds.samples.persistence.mybatis.mappers.EstadisticaMapper;
import java.util.List;

/**
 *
 * @author Z470
 */
public class MyBatisEstadisticaDAO implements EstadisticaDAO {
    
    @Inject
    EstadisticaMapper estadisticaMapper;
    
    @Override
    public List<Estadistica> agrupeIniciativas() throws PersistenceException {
        try {
            System.out.println("MyBatisDAO agrupando  Iniciativa");
            System.out.println("Probando el retorno: " + estadisticaMapper.agrupeIniciativas());
            return estadisticaMapper.agrupeIniciativas();

        } catch (Exception e) {
            System.out.println("Este es el error: " + e);
            throw new PersistenceException("Error al agrupar la iniciativa" + e.getLocalizedMessage(), e);

        }

    }

    @Override
    public List<Estadistica> agrupeEstados() throws PersistenceException {
        try {
            System.out.println("MyBatisDAO agrupando  Iniciativa");
            return estadisticaMapper.agrupeEstados();

        } catch (Exception e) {
            System.out.println("Este es el error: " + e);
            throw new PersistenceException("Error al agrupar la iniciativa por estado" + e.getLocalizedMessage(), e);

        }

    }
    
    
    
}
