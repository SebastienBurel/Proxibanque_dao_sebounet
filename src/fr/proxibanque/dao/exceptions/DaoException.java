package fr.proxibanque.dao.exceptions;

public class DaoException extends Exception {

	public DaoException() {
		super("Erreur : probleme d'acces � la base de donnees");
		
	}

	public DaoException(String message) {
		super(message);
	}

	
}
