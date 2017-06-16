package main.carte;

import java.util.*;
import main.carte.*;
import main.principal.*;
import main.strategie.*;
import main.effet.*;


public class Yarstur implements Effet { // Peut d�truire toutes les cartes au centre d'origine N�ant

	private Controller cont;
@Override
public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection, ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
	
	System.out.println("Effet Yarstur utilis�");
	cont = Controller.getInstance();
	if (listejoueur.get(j).getDivinite().identifiantCarte == 3 ){
	for (int i=0; i<table.size();i++){
		if ( table.get(i).origineCarte==3){
			collection.add(table.get(i));
			table.remove(i);
		}
	}
	cont.setTable(table);
	
}
else if ( listejoueur.get(j).getDivinite().identifiantCarte == 6){
	for (int i=0; i<table.size();i++){
		if (table.get(i).origineCarte == 1){
			collection.add(table.get(i));
			table.remove(i);
		}
	}
	cont.setTable(table);
}
}

@Override
public void utiliserEffet(ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte, int j,
		ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
	// TODO Auto-generated method stub
	
}
	
	
}

