package edu.eci.cvds.samples.Services;

import java.util.Optional;

import org.mybatis.guice.XMLMyBatisModule;

import com.google.inject.Injector;
import static com.google.inject.Guice.createInjector;
import edu.eci.cvds.samples.persistence.IniciativaDAO;
import edu.eci.cvds.samples.persistence.UsuarioDAO;
import edu.eci.cvds.samples.persistence.mybatis.MyBatisIniciativaDAO;
import edu.eci.cvds.samples.persistence.mybatis.MyBatisUsuarioDAO;

public class ServicioProteamFactory {
	private static ServicioProteamFactory instance = new ServicioProteamFactory();
	private static Optional <Injector> optInjector;
	
	private Injector myBatisInjector(String env, String pathResource) {
		return createInjector(new XMLMyBatisModule() {
			@Override
			protected void initialize() {
				setEnvironmentId(env);
				setClassPathResource(pathResource);
				bind(IniciativaDAO.class).to(MyBatisIniciativaDAO.class);
				bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
			}
		});
	}
	
	private ServicioProteamFactory(){
        optInjector = Optional.empty();
    }
	
	
	
	public ServicioProteam getServicioProteam(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(ServicioProteam.class);
    }
	
	public ServicioProteam getServiciosAlquilerTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }

        return optInjector.get().getInstance(ServicioProteam.class);
    }
	
	public static ServicioProteamFactory getInstance(){
        return instance;
    }
	
}
