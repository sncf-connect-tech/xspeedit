package com.anthony.app.xspeedit.exception;

/**
 * Classe de gestion d'exeption pour une saisie utilisateur non valide
 * @author aarchamb
 *
 */
public class InvalidEntryException extends Exception  {

	 public InvalidEntryException()
	    {
	        super();
	    }
	 
	    public InvalidEntryException (String message)
	    {
	        super (message);
	    }

}
