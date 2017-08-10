package fr.proxibanque.dao.exceptions;

public class DuplicatedDaoException extends Exception {

	public DuplicatedDaoException() {
		super("Erreur : probleme d'acces à la base de donnees");
		
	}

	public DuplicatedDaoException(String message) {
		super(message);
	}

	
}
