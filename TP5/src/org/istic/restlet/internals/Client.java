package org.istic.restlet.internals;

public class Client extends Thread{

	private int nbBillets;
	private int nbAttraction = 2;
	public static enum etatsClient {INIT, ENTERED, RIDE1, TRANSIT, RIDE2};
	private etatsClient etat;
	
	public Client(int nbBillets) {
		super();
		this.nbBillets = nbBillets;
	}
	
	public void start() {
		try {
			setEtat(etatsClient.INIT);
			acheterBillets(nbBillets);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			seRendreDansAttraction();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int getNbAttraction() {
		return this.nbAttraction;
	}
	
	public etatsClient getEtat() {
		return this.etat;
	}
	
	public void setEtat(etatsClient e) {
		this.etat = e;
	}
	
	private void acheterBillets(int nouveauxBillets) throws InterruptedException {
		Billeterie.vendreTickets(nouveauxBillets);
		this.nbBillets += nouveauxBillets;
		setEtat(etatsClient.ENTERED);
	}
	
	private void seRendreDansAttraction() throws InterruptedException {
		int randomNum = 0 + (int)(Math.random() * 14);
		Attraction attraction = Parc.attractions[randomNum];
		attraction.clientArrive(this);
	}
	
	public void clientDescend() throws InterruptedException {
		this.nbAttraction--;
		if(nbAttraction != 0) {
			seRendreDansAttraction();
		}
	}
}
