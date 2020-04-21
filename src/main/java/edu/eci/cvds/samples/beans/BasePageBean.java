package edu.eci.cvds.samples.beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import com.google.inject.Injector;

public abstract class BasePageBean implements Serializable {

    private Injector injector;

    public Injector getInjector() {
        if (injector == null) {
			System.out.println("EL INYECTOR ESTA VACIO");
			ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
			
			System.out.println("serveletContext = "+servletContext);
            injector = (Injector) servletContext.getAttribute(Injector.class.getName());
			System.out.println("INYECTOR 1 = "+injector);
			if(injector==null){
				injector = (Injector) servletContext.getAttribute(Injector.class.getName());
				System.out.println("SIGUE 22222222");
			}
			if(injector==null){
				//injector = (Injector) servletContext.getAttribute(Injector.class.getName());
				System.out.println("INCREIBLEMENTE SIGUE VACIO");
			}
			
        }
		else{
			System.out.println("ENTRA EN ELSE DE BAGEPBEAN");
		}
        return injector;
    }

    public void setInjector(Injector injector) {
        this.injector = injector;
    }

    @PostConstruct
    public void init() {
		System.out.println("ONOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        getInjector().injectMembers(this);
		System.out.println("DESPUES DE LA INYECION EN INIT USUUUUUUUUUUUUUUUUUUAUAAAAAA");
    }
}