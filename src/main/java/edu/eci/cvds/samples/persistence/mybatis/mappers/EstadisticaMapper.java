/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.persistence.mybatis.mappers;

import edu.eci.cvds.samples.entities.Estadistica;
import java.util.List;

/**
 *
 * @author Z470
 */
public interface EstadisticaMapper {
    
    public List<Estadistica> agrupeIniciativas();

    public List<Estadistica> agrupeEstados();
    
}
