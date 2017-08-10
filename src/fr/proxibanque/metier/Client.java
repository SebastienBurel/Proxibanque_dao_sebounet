package fr.proxibanque.metier;

import java.util.Hashtable;

/**
 * Methode des clients
 * 
 * @author Sebounet team
 *
 */

//Exemple de classe de type POJO : Plain Old Java Object == Java beans
public class Client {
	
	private int numero;
	private String nom;
	private String prenom;
	private String codePostal;
	private String adresse;
	private String ville;
	private String telephone;
	
	public Client() {
		
	}
	

	public Client(int numero, String nom, String prenom, String codePostal, String adresse, String ville,
			String telephone) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
		this.codePostal = codePostal;
		this.adresse = adresse;
		this.ville = ville;
		this.telephone = telephone;
	}


	
	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	@Override
	public String toString() {
		return "Client [ nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", codePostal=" + codePostal
				+ ", ville=" + ville + ", numeroTelephone=" + telephone + "]";
	}

}
