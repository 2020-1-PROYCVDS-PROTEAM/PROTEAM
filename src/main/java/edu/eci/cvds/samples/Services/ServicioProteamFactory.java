package edu.eci.cvds.samples.Services;

import com.google.inject.Injector;

import edu.eci.cvds.samples.Services.impl.ServicioProteamImpl;
import edu.eci.cvds.samples.persistence.IniciativaDAO;
import edu.eci.cvds.samples.persistence.UsuarioDAO;
import edu.eci.cvds.samples.persistence.ComentarioDAO;
import edu.eci.cvds.samples.persistence.VotoDAO;
import edu.eci.cvds.samples.persistence.InteresDAO;
import edu.eci.cvds.samples.persistence.PalabraClaveDAO;
import edu.eci.cvds.samples.persistence.mybatis.MyBatisIniciativaDAO;
import edu.eci.cvds.samples.persistence.mybatis.MyBatisUsuarioDAO;
import edu.eci.cvds.samples.persistence.mybatis.MyBatisComentarioDAO;
import edu.eci.cvds.samples.persistence.mybatis.MyBatisVotoDAO;
import edu.eci.cvds.samples.persistence.mybatis.MyBatisInteresDAO;
import edu.eci.cvds.samples.persistence.mybatis.MyBatisPalabraClaveDAO;

import org.mybatis.guice.XMLMyBatisModule;


import java.util.Optional;

import static com.google.inject.Guice.createInjector;

public class ServicioProteamFactory {

   private static ServicioProteamFactory instance = new ServicioProteamFactory();

   private static Optional<Injector> optInjector;

   private Injector myBatisInjector(String env, String pathResource) {
       return createInjector(new XMLMyBatisModule() {
           @Override
           protected void initialize() {
               setEnvironmentId(env);
               setClassPathResource(pathResource);
               bind(IniciativaDAO.class).to(MyBatisIniciativaDAO.class);
               bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
               bind(ComentarioDAO.class).to(MyBatisComentarioDAO.class);
               bind(VotoDAO.class).to(MyBatisVotoDAO.class);
               bind(PalabraClaveDAO.class).to(MyBatisPalabraClaveDAO.class);
			   bind(InteresDAO.class).to(MyBatisInteresDAO.class);
               bind(ServicioProteam.class).to(ServicioProteamImpl.class);
           }
       });
   }
   private ServicioProteamFactory(){
       optInjector = Optional.empty();
   }

   public ServicioProteam getServicioProteam() {
       if (!optInjector.isPresent()) {
           optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
       }

       return optInjector.get().getInstance(ServicioProteam.class);
   }




   public static ServicioProteamFactory getInstance(){
       return instance;
   }

}