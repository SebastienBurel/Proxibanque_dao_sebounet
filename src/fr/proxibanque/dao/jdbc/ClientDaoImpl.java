package fr.proxibanque.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.proxibanque.dao.ClientDao;
import fr.proxibanque.dao.exceptions.DaoException;
import fr.proxibanque.dao.exceptions.DuplicatedDaoException;
import fr.proxibanque.dao.exceptions.RemoveException;
import fr.proxibanque.dao.exceptions.SearchException;
import fr.proxibanque.metier.Client;

public class ClientDaoImpl implements ClientDao {
	
	

	@Override
	public Client searchById(int id) throws DaoException, SearchException {
		
		PreparedStatement stmt = null;
		Connection connection = null;
		
		try {
		// 1 - Chargement de driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					// 2 - Creation d'une connection
					// localhost = 127.0.0.1
					String url = "jdbc:mysql://PARME38:3306/proxibanque?useSSL=true&useLegacyDatetimeCode=false&serverTimezone=America/New_York";
					String login = "root";
					String password ="root";
					connection = DriverManager.getConnection(url, login, password);
					// 3 - preparation de la requete
					String requete = "select numero, nom, prenom, adresse, code_postal, ville, telephone from client where numero = ?";
					stmt = connection.prepareStatement(requete);
					stmt.setInt(1, id);
					//4 - execution de la requete
					ResultSet resultat = stmt.executeQuery();
					//5 - traitement du resultat
					Client c = null; 
					
					if(resultat.next())	{
						c = new Client();
						c.setNumero(resultat.getInt("numero"));
						c.setAdresse(resultat.getString("adresse"));
						c.setNom(resultat.getString("nom"));
						c.setPrenom(resultat.getString("prenom"));
						
					}else {
						throw new SearchException("Erreur");
					}
					return c;
		}catch (Exception e) {		
			throw new DaoException( "Erreur " + e.getMessage() ) ;
			
		}finally {
			// 6 - Liberation des ressources
			try {
				if(stmt != null)			stmt.close();
				if(connection != null)			connection.close();
			}catch(Exception e) {
				throw new DaoException( "Erreur " + e.getMessage() ) ;
			}
		}
			
		
		}
	
	

	@Override
	public List<Client> searchAll() throws DaoException {
		Statement stmt = null;
		Connection connection = null;
		
		try {
			// 1 - Chargement de driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2 - Creation d'une connection
			// localhost = 127.0.0.1
			String url = "jdbc:mysql://PARME38:3306/proxibanque?useSSL=true&useLegacyDatetimeCode=false&serverTimezone=America/New_York";
			String login = "root";
			String password ="root";
			connection = DriverManager.getConnection(url, login, password);
			// 3 - preparation de la requete
			String requete = "select numero, nom, prenom, adresse, code_postal, ville, telephone from client";
			stmt = connection.createStatement();
		
			// 4 - Execution de la requete
			ResultSet resultat = stmt.executeQuery(requete);
			// 5 - Traitement du resultat
			List<Client> clients = new ArrayList<>();
			
			while(resultat.next()==true) {
				Client c = new Client();
				c.setNumero(resultat.getInt("numero"));
				c.setAdresse(resultat.getString("adresse"));
				c.setNom(resultat.getString("nom"));
				c.setPrenom(resultat.getString("prenom"));
				
				clients.add(c);
			}
			
			return clients;
		
		}catch (Exception e) {		
			throw new DaoException( "Erreur " + e.getMessage() ) ;
			
		}finally {
			// 6 - Liberation des ressources
			try {
				if(stmt != null)			stmt.close();
				if(connection != null)			connection.close();
			}catch(Exception e) {
				throw new DaoException( "Erreur " + e.getMessage() ) ;
			}
		}
	}

	@Override
	public void create(Client client) throws DaoException, DuplicatedDaoException{
		
		try {
			// 1 - Chargement de driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2 - Creation d'une connection
			// localhost = 127.0.0.1
			String url = "jdbc:mysql://PARME38:3306/proxibanque?useSSL=true&useLegacyDatetimeCode=false&serverTimezone=America/New_York";
			String login = "root";
			String password ="root";
			Connection connection = DriverManager.getConnection(url, login, password);
			// 3 - preparation de la requete
			String requete = "INSERT INTO client (nom, prenom, adresse, code_postal, ville, telephone) VALUES (?,?,?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(requete);
			stmt.setString(1, client.getNom());
			stmt.setString(2, client.getPrenom());
			stmt.setString(3, client.getAdresse());
			stmt.setString(4, client.getCodePostal());
			stmt.setString(5, client.getVille());
			stmt.setString(6, client.getTelephone());
			// 4 - Execution de la requete
			int nombre = stmt.executeUpdate();
			// 5 - Traitement du resultat
			// 6 - Liberation des ressources
			stmt.close();
			connection.close();
		
		}catch(SQLIntegrityConstraintViolationException e) {
			
			throw new DuplicatedDaoException( "Erreur nom duplique -detail : " + e.getMessage() ) ;
		}catch (Exception e) {
			//e.printStackTrace();
			throw new DaoException( "Erreur " + e.getMessage() ) ;
			
		}
	}

	@Override
	public void update(Client client) {
		
	

	}

	@Override
	public void remove(int id) throws DaoException, RemoveException {
		PreparedStatement stmt = null;
		Connection connection = null;
		
		try {
		// 1 - Chargement de driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					// 2 - Creation d'une connection
					// localhost = 127.0.0.1
					String url = "jdbc:mysql://PARME38:3306/proxibanque?useSSL=true&useLegacyDatetimeCode=false&serverTimezone=America/New_York";
					String login = "root";
					String password ="root";
					connection = DriverManager.getConnection(url, login, password);
					// 3 - preparation de la requete
					String requete = "delete from client where numero = ?";
					stmt = connection.prepareStatement(requete);
					stmt.setInt(1, id);
					//4 - execution de la requete
					int nombre = stmt.executeUpdate();
					//5 - traitement du resultat
					
					
					if(nombre == 0)	{
						
						throw new RemoveException("Erreur");
					}
					
		}catch (Exception e) {		
			throw new DaoException( "Erreur " + e.getMessage() ) ;
			
		}finally {
			// 6 - Liberation des ressources
			try {
				if(stmt != null)			stmt.close();
				if(connection != null)			connection.close();
			}catch(Exception e) {
				throw new DaoException( "Erreur " + e.getMessage() ) ;
			}
		}
		

	}

}
