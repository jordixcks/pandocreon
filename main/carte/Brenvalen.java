package main.carte;

import java.util.*;
import main.principal.*;

import main.principal.Effet;
public class Brenvalen implements Effet {

@Override
public void utiliserEffet(ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte,
		int j, ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
	// TODO Auto-generated method stub
	
}


@Override
public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection, ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
	 // Peut emp�cher l'utilisation d'une carte Apocalypse
		// On active une boolean en arri�re plan, lors qu'on pose une carte, si l'effet est activ� on r�appelle l'effet pour qu'il annule l'apocalypse
		System.out.println("Effet Brenvalen utilis�");
		for (int i=0; i<listejoueur.size();i++){
			if (tourJoueur.get(j)!=listejoueur.get(i)){
				if (listejoueur.get(i).isBlocageApocalypse()==false){
					listejoueur.get(i).setBlocageApocalypse(true);
				}
				
			}
		}

	
}
	
}
