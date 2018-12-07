package org.istic.restlet.internals;

import java.util.HashSet;
import java.util.Set;

public class Parc {
	
	public static Attraction[] attractions;
	private static Set<Client> mesClients;
	
	public static Set<Client> getClients(){
		return mesClients;
	}
	
	public static void main(String[] args) {
		
		attractions = new Attraction[15];
		mesClients = new HashSet<Client>();
		Billeterie.respo = new ResponsableBilleterie();
		
		
		for (int i = 0; i < 15; i++) {
			Attraction attraction = new Attraction(i, i%2, i%3);
			for (int j = 0; j < 5; j++) {
				Navette navette = new Navette();
				attraction.addNavette(j, navette);
			}
			attractions[i] = attraction;
		}
		
		for (int i = 0; i < 15; i++) {
			Client client = new Client(i);
			mesClients.add(client);
			client.start();
		}
		
	}
}
