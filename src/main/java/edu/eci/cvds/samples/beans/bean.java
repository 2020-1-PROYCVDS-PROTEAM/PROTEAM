/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.beans;

import edu.eci.cvds.samples.Services.ServicesException;
import edu.eci.cvds.samples.entities.Iniciativa;
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
    List<Iniciativa> iniciativas = null;
    List<Iniciativa> iniciativasEstado = null;
    
    @Inject
    private ServicioProteam servicioPT;

    public PieChartModel getModel() {
        System.out.println("Esta entrando por acá!");
        model = new PieChartModel();
        try {
            iniciativas = servicioPT.agrupeIniciativas();

        } catch (ServicesException e) {
            System.out.println("Capturado en consultarIniciativas bean");
        } finally {
            if (iniciativas != null) {
                System.out.println("estas son las iniciativas: " + iniciativas);
                for (Iniciativa iniciativa : iniciativas) {
                    System.out.println("iniciativa getArea: " + iniciativa.getArea2() + " iniciativaCantidad: " + iniciativa.getCantidad());
                    model.set(iniciativa.getArea2(), iniciativa.getCantidad());
                }
                System.out.println("Iniciativas: " + model);
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
                System.out.println("Iniciativas por estado: " + iniciativasEstado);
                for (Iniciativa iniciativa : iniciativasEstado) {
                    if(iniciativa.getEstados().equals("Proyecto"))
                        proyecto.set(iniciativa.getEstados(), iniciativa.getCantidad());
                    else if(iniciativa.getEstados().equals("Solucionado"))
                        solucionado.set(iniciativa.getEstados(), iniciativa.getCantidad());
                    else if(iniciativa.getEstados().equals("En espera de revisión"))
                        enRevision.set(iniciativa.getEstados(), iniciativa.getCantidad());
                    else
                        enEstado.set(iniciativa.getEstados(), iniciativa.getCantidad());
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

//    public Bean() {
//        barModel = new BarChartModel();
//        ChartSeries boys = new ChartSeries();
//        boys.setLabel("Boys");
//        boys.set("2004", 120);
//        boys.set("2005", 100);
//        boys.set("2006", 44);
//        boys.set("2007", 150);
//        boys.set("2008", 25);
//        ChartSeries girls = new ChartSeries();
//        girls.setLabel("Girls");
//        girls.set("2004", 52);
//        girls.set("2005", 60);
//        girls.set("2006", 110);
//        girls.set("2007", 135);
//        girls.set("2008", 120);
//        model.addSeries(boys);
//        model.addSeries(girls);
//        model.setTitle("Bar Chart");
//        model.setLegendPosition("ne");
//        Axis xAxis = barModel.getAxis(AxisType.X);
//        xAxis.setLabel("Gender");
//        Axis yAxis = model.getAxis(AxisType.Y);
//        yAxis.setLabel("Births");
//        yAxis.setMin(0);
//        yAxis.setMax(200);
//    }

    public void setIniciativas(List<Iniciativa> iniciativas) {
        this.iniciativas = iniciativas;
    }

    public List<Iniciativa> getIniciativas() {
        return iniciativas;
    }

    public List<Iniciativa> getIniciativasEstado() {
        return iniciativasEstado;
    }

    public void setIniciativasEstado(List<Iniciativa> iniciativasEstado) {
        this.iniciativasEstado = iniciativasEstado;
    }
    
    

}
