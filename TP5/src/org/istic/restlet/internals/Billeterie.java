package org.istic.restlet.internals;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Billeterie {

	private final static int nbBilletsInitial = 100;

	private static int nbBilletsDispo = nbBilletsInitial;

	static ResponsableBilleterie respo;
	
	public Billeterie(int nbBilletsInitial) {
		super();
	}

	public int getNbBilletsDispo() {
		return nbBilletsDispo;
	}

	public synchronized static void setNbBilletsDispo(int nb) {
		nbBilletsDispo = nb;
	}
	
	public static int getNbBilletsInitial() {
		return nbBilletsInitial;
	}
	
	synchronized static void vendreTickets(int nbTickets) throws InterruptedException {
		if (nbBilletsDispo > nbTickets) {
			imprimerTickets(nbTickets);
			nbBilletsDispo -= nbTickets;
		}
		respo.rechargerBilleterie();
	}
	
	private synchronized static void imprimerTickets(int nbTickets) throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
	}
}
