package org.istic.restlet.application;

import org.istic.restlet.resources.ClientRessource;
import org.istic.restlet.resources.NavetteRessource;
import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 *
 * Application.
 *
 * @author mathi
 *
 */
public class MyDisneylandApplication extends Application
{

    public MyDisneylandApplication(Context context)
    {
        super(context);
    }

    @Override
    public Restlet createInboundRoot()
    {
        Router router = new Router(getContext());
        router.attach("/clients", ClientRessource.class);
        router.attach("/navettes", NavetteRessource.class);

        return router;
    }
}
