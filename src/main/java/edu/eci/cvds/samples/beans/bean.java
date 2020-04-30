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

/**
 *
 * @author Z470
 */

@SuppressWarnings("serial")
@ManagedBean(name = "bean")
@ApplicationScoped
public class bean extends BasePageBean implements Serializable{
    private PieChartModel model;
    List<Iniciativa> iniciativas=null;
    @Inject
    private ServicioProteam servicioPT;


 
    public PieChartModel getModel() {
                System.out.println("Esta entrando por acá!");
                model = new PieChartModel();
		try{
			iniciativas = servicioPT.agrupeIniciativas();
                        
		}catch(ServicesException e){
			System.out.println("Capturado en consultarIniciativas bean");
		}
                finally{
                    if(iniciativas!=null){
                        System.out.println("estas son las iniciativas: "+iniciativas);
                        for(Iniciativa iniciativa: iniciativas){
                            System.out.println("iniciativa getArea: "+iniciativa.getArea2()+" iniciativaCantidad: "+iniciativa.getCantidad());
                            model.set(iniciativa.getArea2(),iniciativa.getCantidad());
                        }
                        System.out.println("Iniciativas: "+model);
		}

                model.setTitle("Custom Pie");
                model.setLegendPosition("e");
                model.setShowDataLabels(true);
                model.setDiameter(150);
        
        }
                return model;  
    }
    
    public void setIniciativas(List<Iniciativa> iniciativas){
        this.iniciativas=iniciativas;
    }
    
    public List<Iniciativa> getIniciativas(){
        return iniciativas;
    }    
     
}