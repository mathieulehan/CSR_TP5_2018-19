package org.istic.restlet.internals;
import org.istic.restlet.internals.Billeterie;

public class ResponsableBilleterie extends Thread{

	public ResponsableBilleterie() {
		
	}
	
	public void run() {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		rechargerBilleterie();
	}
	
	void rechargerBilleterie() {
		Billeterie.setNbBilletsDispo(Billeterie.getNbBilletsInitial());
	}
}
