package org.istic.restlet.internals;

import org.istic.restlet.internals.Client.etatsClient;
import org.istic.restlet.internals.Navette.etatsNavette;

public class Attraction {

	private int dureeArret;
	private int dureeVoyage;
	public int getDureeArret() {
		return dureeArret;
	}

	private boolean hasNavetteOnQuai;
	private int dureeStationnementQuai;
	private Navette[] mesNavettes;
	public Navette navetteAQuai;

	public Attraction(int dureeArret, int dureeVoyage, int dureeStationnement) {
		super();
		this.dureeArret = dureeArret;
		this.dureeVoyage = dureeVoyage;
		this.mesNavettes = new Navette[5];
	}

	public Navette[] getMyNavettes() {
		return this.mesNavettes;
	}
	
	public void addNavette(int nb, Navette navette) {
		this.mesNavettes[nb] = navette;
	}
	
	public void setDureeArret(int dureeArret) {
		this.dureeArret = dureeArret;
	}

	public int getDureeVoyage() {
		return dureeVoyage;
	}

	public void setDureeVoyage(int dureeVoyage) {
		this.dureeVoyage = dureeVoyage;
	}

	public int getDureeStationnementQuai() {
		return dureeStationnementQuai;
	}

	public void setDureeStationnementQuai(int dureeStationnementQuai) {
		this.dureeStationnementQuai = dureeStationnementQuai;
	}
	
	public void navetteArrive(Navette navette) throws InterruptedException {
		if (!this.navetteAQuai.equals(null)) {
			wait();
		}
		this.navetteAQuai = navette;
		navette.setEtat(etatsNavette.STOPPED);
	}

	public void navetteDemarre(Navette navette) {
		this.navetteAQuai = null;
		navette.setEtat(etatsNavette.TRAVELLING);
		notify();
	}
	
	public synchronized void clientArrive(Client c) throws InterruptedException{
		while(!hasNavetteOnQuai && !navetteAQuai.hasPlaces()) {}
		if(c.getNbAttraction() == 1) {
			c.setEtat(etatsClient.RIDE2);
		}
		else {
			c.setEtat(etatsClient.RIDE1);
		}
		navetteAQuai.clientMonte(c);
	}
	
}
