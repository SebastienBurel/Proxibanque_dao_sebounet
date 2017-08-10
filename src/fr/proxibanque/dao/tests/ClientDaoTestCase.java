package fr.proxibanque.dao.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fr.proxibanque.dao.ClientDao;
import fr.proxibanque.dao.exceptions.DaoException;
import fr.proxibanque.dao.exceptions.DuplicatedDaoException;
import fr.proxibanque.dao.jdbc.ClientDaoImpl;
import fr.proxibanque.metier.Client;

public class ClientDaoTestCase {

	@Test
	public final void testSearchAll() {
		
		try {
			ClientDao clientDao = new ClientDaoImpl();
			List<Client> liste = clientDao.searchAll();
			assertNotNull(liste);
			assertEquals(2, liste.size());
			for(Client item : liste)			{
				System.out.println(item);
			}
			
		} catch (DaoException e) {
			fail(e.getMessage());
		}
		
	}

	@Test
	public final void testCreate() {
		
		ClientDao clientDao = new ClientDaoImpl();
		try {
			Client client = new Client(0,"OUAHIDI","Hafid","06300","17 rue droite","Nice","0619643172");
			
			clientDao.create(client);
		
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		} 
	}
	
	@Test
	public final void testSearchById() {
		
		ClientDao clientDao = new ClientDaoImpl();
		try {
			Client client = clientDao.searchById(1);
			assertNotNull(client);
			assertEquals("OUAHIDI",client.getNom());
		
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		} 
	}

	
	@Test
	public final void testRemove() {
		
		ClientDao clientDao = new ClientDaoImpl();
		try {
			Client client = clientDao.remove(12);
			assertNull(client);
			assertNotEquals("OUAHIDI",client.getNom());
		
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		} 
	}
}
