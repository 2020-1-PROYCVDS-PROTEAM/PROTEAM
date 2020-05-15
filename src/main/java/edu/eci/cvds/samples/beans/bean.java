/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.beans;

import edu.eci.cvds.samples.Services.ServicesException;
import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.Estadistica;
import edu.eci.cvds.samples.Services.ServicioProteam;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.PieChartModel;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import java.util.List;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author Z470
 */
@SuppressWarnings("serial")
@ManagedBean(name = "bean")
@ApplicationScoped
public class bean extends BasePageBean implements Serializable {

    private PieChartModel model;
    private BarChartModel barModel;
    List<Estadistica> iniciativas = null;
    List<Estadistica> iniciativasEstado = null;
    
    @Inject
    private ServicioProteam servicioPT;

    public PieChartModel getModel() {
        //System.out.println("Esta entrando por acá!");
        model = new PieChartModel();
        try {
            iniciativas = servicioPT.agrupeIniciativas();

        } catch (ServicesException e) {
            System.out.println("Capturado en consultarIniciativas bean");
        } finally {
            if (iniciativas != null) {
                //System.out.println("estas son las iniciativas: " + iniciativas);
                for (Estadistica iniciativa : iniciativas) {
                    System.out.println("iniciativa getArea: " + iniciativa.getNombre() + " iniciativaCantidad: " + iniciativa.getCantidad());
                    model.set(iniciativa.getNombre(), iniciativa.getCantidad());
                }
                //System.out.println("Iniciativas: " + model);
            }

            model.setTitle("Áreas de iniciativas.");
            model.setLegendPosition("e");
            model.setShowDataLabels(true);
            model.setDiameter(150);

        }
        return model;
    }

    public BarChartModel getBarModel() {
        barModel = new BarChartModel();
        ChartSeries proyecto = new ChartSeries();
        ChartSeries solucionado = new ChartSeries();
        ChartSeries enRevision = new ChartSeries();
        ChartSeries enEstado = new ChartSeries();
        proyecto.setLabel("Proyecto");
        solucionado.setLabel("Solucionado");
        enRevision.setLabel("En revisión");
        enEstado.setLabel("En espera de revisión");
        try {
            iniciativasEstado = servicioPT.agrupeEstados();

        } catch (ServicesException e) {
            System.out.println("Capturado en consultarIniciativas bean"); //lanzar la excepcion
        } finally {
            if (iniciativasEstado != null) {
                //System.out.println("Iniciativas por estado: " + iniciativasEstado);
                for (Estadistica iniciativa : iniciativasEstado) {
                    if(iniciativa.getNombre().equals("Proyecto"))
                        proyecto.set(iniciativa.getNombre(), iniciativa.getCantidad());
                    else if(iniciativa.getNombre().equals("Solucionado"))
                        solucionado.set(iniciativa.getNombre(), iniciativa.getCantidad());
                    else if(iniciativa.getNombre().equals("En espera de revisión"))
                        enRevision.set(iniciativa.getNombre(), iniciativa.getCantidad());
                    else
                        enEstado.set(iniciativa.getNombre(), iniciativa.getCantidad());
                }
                barModel.addSeries(enEstado);
                barModel.addSeries(enRevision);
                barModel.addSeries(proyecto);
                barModel.addSeries(solucionado);
                barModel.setTitle("Estados iniciativas");
                barModel.setLegendPosition("ne");
                Axis xAxis = barModel.getAxis(AxisType.X);
                xAxis.setLabel("Estados iniciativas");
                Axis yAxis = barModel.getAxis(AxisType.Y);
                yAxis.setLabel("Cantidad");
                yAxis.setMin(0);
                yAxis.setMax(10);
            }
        }
        return barModel;
    }

    public void setIniciativas(List<Estadistica> iniciativas) {
        this.iniciativas = iniciativas;
    }

    public List<Estadistica> getIniciativas() {
        return iniciativas;
    }

    public List<Estadistica> getIniciativasEstado() {
        return iniciativasEstado;
    }

    public void setIniciativasEstado(List<Estadistica> iniciativasEstado) {
        this.iniciativasEstado = iniciativasEstado;
    }
    
    
    public void publicarComentario() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Comentario publicado."));
    }
    
    public void campoEditado() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Campo modificado."));
    }
    
	 public void votoRegistrado() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Su voto ha sido registrado."));
    }
	
	public void interesRegistrado() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Su interes ha sido registrado."));
    }

}
