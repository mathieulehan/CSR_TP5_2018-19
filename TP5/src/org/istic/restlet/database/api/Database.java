package org.istic.restlet.database.api;

import java.util.Collection;
import java.util.List;

import org.istic.restlet.internals.Client;

/**
 *
 * Interface to the database.
 *
 * @author msimonin
 *
 */
public interface Database
{

    /**
     *
     * Create a new client in the database.
     *
     * @param nbBillets mle nb de billets du client
     * @return  the new client.
     */
    Client createClient(int nbBillets);
}
