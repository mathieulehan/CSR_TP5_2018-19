package org.istic.restlet.resources;

import java.util.ArrayList;
import java.util.Collection;
import org.istic.restlet.backend.Backend;
import org.istic.restlet.internals.Attraction;
import org.istic.restlet.internals.Navette;
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
public class NavetteRessource extends ServerResource
{

	/** Backend.*/
	private Backend backend_;

	/**
	 * Constructor.
	 * Call for every single user request.
	 */
	public NavetteRessource()
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
		Collection<JSONObject> jsonNavettes = new ArrayList<JSONObject>();
		for (Attraction attraction : Parc.attractions) {
			for (Navette navette : attraction.getMyNavettes()) {
				JSONObject nav = new JSONObject();
				nav.put("Etat: ", navette.getEtat());
				jsonNavettes.add(nav);
			}
		}
		JSONArray jsonArray = new JSONArray(jsonNavettes);
		return new JsonRepresentation(jsonArray);
	}

}
