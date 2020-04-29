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
    @Inject
    private ServicioProteam servicioPT;
    /**
    public bean() {

    }
     * @return 
    */
    public PieChartModel getModel() {
                System.out.println("Esta entrando por acá!");
                model = new PieChartModel();
		List<java.util.HashMap<String,java.lang.Long>> iniciativas=null;
		try{
			iniciativas = servicioPT.agrupeIniciativas();
		}catch(ServicesException e){
			System.out.println("Capturado en consultarIniciativas bean");
		}
                finally{
		if(iniciativas!=null){
        
			for(HashMap<String, Long> iniciativa:iniciativas){
                            
                            for (Map.Entry<String, Long> entry : iniciativa.entrySet()) {
                                String key = entry.getKey();
                                Object value = entry.getValue();
                                model.set(key, (Number) value);
                            }
                            
                        }
                            
                        System.out.println("estas son las iniciativas: "+iniciativas);
			//System.out.println(iniciativa.getArea()+" "+iniciativa.getCantidad()+" "+iniciativa);  
			//}
			//model.set(iniciativa.area,iniciativa,cantidad);
		}
/*                
        model.set("Brand 1", 540);
        model.set("Brand 2", 325);
        model.set("Brand 3", 702);
        model.set("Brand 4", 421);
*/
        model.setTitle("Custom Pie");
        model.setLegendPosition("e");
        model.setFill(false);
        model.setShowDataLabels(true);
        model.setDiameter(150);
        
        }
                return model;  
    }
     
}