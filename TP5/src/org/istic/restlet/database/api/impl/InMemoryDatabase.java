package org.istic.restlet.database.api.impl;

import java.util.ArrayList;
import java.util.List;
import org.istic.restlet.database.api.Database;
import org.istic.restlet.internals.Client;
import org.istic.restlet.internals.Navette;

/**
 *
 * In-memory database 
 *
 * @author ctedeschi
 * @author msimonin
 *
 */
public class InMemoryDatabase implements Database
{

	List<Client> clients_;
	List<Navette> navettes_;

	public InMemoryDatabase()
	{
		clients_ = new ArrayList<Client>();
		navettes_ = new ArrayList<Navette>();
	}

	/**
	 *
	 * Synchronized user creation.
	 * @param name
	 * @param age
	 *
	 * @return the user created
	 */
	@Override
	public synchronized Client createClient(int nbBillets)
	{
		Client client = new Client(nbBillets);
		clients_.add(client);
		return client;
	}
	
	public void addNavette(Navette n) {
		Navette navette = n;
		navettes_.add(navette);
	}
}
