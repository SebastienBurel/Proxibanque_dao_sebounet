package fr.proxibanque.dao;

import java.util.List;

import fr.proxibanque.dao.exceptions.DaoException;
import fr.proxibanque.dao.exceptions.DuplicatedDaoException;
import fr.proxibanque.dao.exceptions.RemoveException;
import fr.proxibanque.dao.exceptions.SearchException;
import fr.proxibanque.metier.Client;

public interface ClientDao {
	
	public Client searchById(int id) throws DaoException, SearchException;
	public List<Client> searchAll() throws DaoException;
	public void  create(Client client) throws DaoException, DuplicatedDaoException;
	public void  update(Client client);
	public void  remove(int id) throws DaoException, RemoveException;

}
