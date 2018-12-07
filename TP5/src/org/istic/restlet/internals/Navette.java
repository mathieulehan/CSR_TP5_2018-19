package org.istic.restlet.internals;

import java.util.HashSet;
import java.util.Set;

import org.istic.restlet.internals.Client.etatsClient;

public class Navette extends Thread{

	private int nbPlacesMaximales;
	private int nbPlacesDisponibles;
	private Attraction monAttraction;
	private Set<Client> mesClients;
	public static enum etatsNavette {STOPPED, TRAVELLING};
	private etatsNavette etat;

	public Navette() {
		mesClients = new HashSet<Client>();
	}
	
	public void run() {
		try {
			voyager();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public etatsNavette getEtat() {
		return etat;
	}

	public void setEtat(etatsNavette e) {
		this.etat = e;
	}
	
	/**
	 * Fait le parcours typique de la navette
	 * @throws InterruptedException 
	 */
	public void voyager() throws InterruptedException {
		monAttraction.navetteArrive(this);
		if(this.mesClients.size() > 0) {
			for(Client client : mesClients) {
				if(client.getEtat() != Client.etatsClient.RIDE2) {
					client.clientDescend();
					mesClients.remove(client);
					client.setEtat(etatsClient.TRANSIT);
				}
				else {
					mesClients.remove(client);
				}
			}
		}
		int tempsArret = monAttraction.getDureeArret();
		try { Thread.sleep(tempsArret); } catch(InterruptedException e) {}
		monAttraction.navetteDemarre(this);
	}
	
	public boolean hasPlaces() {
		return nbPlacesMaximales > nbPlacesDisponibles;
	}
	
	public void clientMonte(Client c) throws InterruptedException {
		this.nbPlacesDisponibles--;
		mesClients.add(c);
	}
	
}
