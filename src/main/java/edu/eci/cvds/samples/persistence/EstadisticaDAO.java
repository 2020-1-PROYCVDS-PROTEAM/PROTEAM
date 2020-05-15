/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.persistence;

import edu.eci.cvds.samples.entities.Estadistica;
import java.util.List;

/**
 *
 * @author Z470
 */
public interface EstadisticaDAO {

    public List<Estadistica> agrupeIniciativas() throws PersistenceException;

    public List<Estadistica> agrupeEstados() throws PersistenceException;
}
