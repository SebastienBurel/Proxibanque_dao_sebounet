package fr.proxibanque.dao.exceptions;

public class RemoveException extends Exception {

	public RemoveException() {
		super("Erreur : probleme de suppression de client");
	}

	public RemoveException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	

}
