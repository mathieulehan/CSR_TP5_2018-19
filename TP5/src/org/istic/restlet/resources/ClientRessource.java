package org.istic.restlet.resources;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.istic.restlet.backend.Backend;
import org.istic.restlet.internals.Client;
import org.istic.restlet.internals.Parc;
import org.restlet.resource.ServerResource;
import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;

/**
 *
 * @author M & Y
 *
 */
public class ClientRessource extends ServerResource
{

	/** Backend.*/
	private Backend backend_;

	/**
	 * Constructor.
	 * Call for every single user request.
	 */
	public ClientRessource ()
	{
		backend_ = (Backend) getApplication().getContext().getAttributes()
				.get("backend");
	}

	/**
	 * Renvoie les navettes
	 * @throws Exception
	 */
	@Get("json")
	public Representation getNavettes() throws Exception
	{
		Collection<JSONObject> jsonClients = new ArrayList<JSONObject>();
		Set<Client> clients = Parc.getClients();
		for (Client client : clients) {
			JSONObject cli = new JSONObject();
			cli.put("Etat: ", client.getEtat());
			jsonClients.add(cli);
		}
		JSONArray jsonArray = new JSONArray(jsonClients);
		return new JsonRepresentation(jsonArray);
	}

}
