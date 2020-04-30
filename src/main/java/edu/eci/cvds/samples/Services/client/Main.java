package edu.eci.cvds.samples.Services.client;

import edu.eci.cvds.samples.Services.ServicesException;
import edu.eci.cvds.samples.Services.ServicioProteamFactory;

public class Main {

    public static void main(String[] args) throws ServicesException{
        //System.out.println(ServicioProteamFactory.getInstance().getServicioProteam().consultarUsuarios());
        //System.out.println(ServicioProteamFactory.getInstance().getServicioProteam().consultarUsuario("cesarg"));
       // System.out.println(ServicioProteamFactory.getInstance().getServicioProteam().consultarIniciativas());
    	System.out.println(ServicioProteamFactory.getInstance().getServicioProteam().palabraClaveIniciativa("S"));
        System.exit(0);
    }

}