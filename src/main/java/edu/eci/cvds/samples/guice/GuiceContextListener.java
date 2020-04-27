package edu.eci.cvds.samples.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import edu.eci.cvds.samples.persistence.UsuarioDAO;
import edu.eci.cvds.samples.persistence.IniciativaDAO;
import edu.eci.cvds.samples.persistence.ComentarioDAO;
import edu.eci.cvds.samples.persistence.PersistenceException;
import edu.eci.cvds.samples.persistence.mybatis.MyBatisUsuarioDAO;
import edu.eci.cvds.samples.persistence.mybatis.MyBatisIniciativaDAO;
import edu.eci.cvds.samples.persistence.mybatis.MyBatisComentarioDAO;

import edu.eci.cvds.samples.Services.ServicioProteam;
import edu.eci.cvds.samples.Services.ServicioProteamFactory;
import edu.eci.cvds.samples.Services.ServicesException;
import edu.eci.cvds.samples.Services.impl.ServicioProteamImpl;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }
    
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
				
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");
				System.out.println("GuiceConextENTRA");
                // TODO Add service class associated to Stub implementation
                //bind(ItemDAO.class).to(MyBATISItemDAO.class);
                bind(IniciativaDAO.class).to(MyBatisIniciativaDAO.class);
				bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
				bind(ComentarioDAO.class).to(MyBatisComentarioDAO.class);
                bind(ServicioProteam.class).to(ServicioProteamImpl.class);
				System.out.println("SUPERO TODOS LOS BEANS");
            }
        });

		ServletContext servletContext = servletContextEvent.getServletContext();
        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}