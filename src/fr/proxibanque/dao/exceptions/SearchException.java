package fr.proxibanque.dao.exceptions;

public class SearchException extends Exception {

	public SearchException() {
		super("Erreur : probleme de lecture de client");
	}

	public SearchException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
}
