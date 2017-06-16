package main.carte;

import java.util.ArrayList;
import main.effet.*;
import main.principal.*;



import main.principal.Effet;

public class Drinded implements Effet {

public void utiliserEffetDivinite( ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection, ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur){ // Peut empêcher le sacrifice d'un guide à n'importe quel joueur
	// On active une boolean en arrière plan, lorsque quelqu'un veut sacrifier un guide, si l'effet de la carte est activé, on rappelle l'effet pour qu'il annule le sacrifice
	System.out.println("Effet Drinded utilisé");
	
	
	for (int i=0;i<listejoueur.size();i++){
		if (tourJoueur.get(j)!=listejoueur.get(i)){
			if (listejoueur.get(j).getBlocageSacrificeGuide() == false){
			listejoueur.get(j).setBlocageSacrificeGuide(true);
		}
	}
	}
	
		// On enlève le guide qu'il veut sacrifier, et remet ses croyants dans le deck
		// D'abord on enlève tous ses croyants
		// ON PEUT METTRE CA DANS SACRIFIER, DANS LES CONDITION





}

@Override
public void utiliserEffet( ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte,
		int j, ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
	// TODO Auto-generated method stub
	
}
	
}
