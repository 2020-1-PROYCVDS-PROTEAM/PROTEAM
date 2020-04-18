package edu.eci.cvds.samples.Services;

import edu.eci.cvds.samples.persistence.PersistenceException;

public class ServicesException extends Exception {
	
	

	public ServicesException(String string) {
		super(string);
	}
	
	public ServicesException(String string, PersistenceException ex) {
		super(string, ex);
	}


}
