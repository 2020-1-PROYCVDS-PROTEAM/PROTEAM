
package edu.eci.cvds.samples.beans;

import java.sql.Date;
import java.util.List;
//import java.text.SimpleDateFormat;
import java.text.ParseException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.Services.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import org.primefaces.event.FlowEvent;

@Named
@RequestScoped
public class ToolbarView {
     
    public void save() {
        addMessage("Success", "Data saved");
    }
     
    public void update() {
        addMessage("Success", "Data updated");
    }
     
    public void delete() {
        addMessage("Success", "Data deleted");
    }
     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}