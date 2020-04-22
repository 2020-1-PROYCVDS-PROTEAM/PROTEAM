package edu.eci.cvds.samples.Services.client;

import edu.eci.cvds.samples.Services.ServicesException;
import edu.eci.cvds.samples.Services.ServicioProteamFactory;

public class Main {

    public static void main(String[] args) throws ServicesException{
        System.out.println(ServicioProteamFactory.getInstance().getServicioProteam().consultarUsuarios());
        //System.out.println(ServicioProteamFactory.getInstance().getServicioProteam().consultarUsuario("admin"));

        System.exit(0);
    }

}