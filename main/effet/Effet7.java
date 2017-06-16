package main.effet;

import java.util.ArrayList;
import main.carte.*;
import main.principal.*;

/**
 * <b>Effet7 est la classe representant l'effet de la carte 24.</b>
 * <p>Son effet : Defausse un guide spirituel d'un autre joueur pos� sur la table, les croyants retournent au centre.</p>
 */
public class Effet7 implements Effet{ 

	@Override
	/**
	 * Actionne l'effet de la carte.
	 * 
	 * @param listejoueur
	 * 			La liste des joueurs de la partie.
	 * @param cible
	 * 			La joueur contre qui l'effet sera joué.
	 * @param table
	 * 			Collection de cartes situées au centre de la table de jeu.
	 * @param carte
	 * 			La carte qui joue l'effet.
	 * @param j
	 * 			Le joueur qui joue la carte.
	 * @param collection
	 * 			Le deck de cartes.
	 * @param tourjoueur
	 * 			La liste des joueurs selon l'ordre de jeu.
	 */
	public void utiliserEffet( ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte,
			int j, ArrayList<Carte> collection,ArrayList<Joueur> tourjoueur) {
		for(int k=0; k<listejoueur.size();k++){
		if (listejoueur.get(k) != tourjoueur.get(j)){
		for (int i=0; i<listejoueur.get(cible).getGuidePossede().get(0).getCroyantPossede().size();i++){
			table.add(listejoueur.get(cible).getGuidePossede().get(0).getCroyantPossede().get(i));
			listejoueur.get(cible).getGuidePossede().get(0).getCroyantPossede().remove(i);
		}
		
	collection.add(listejoueur.get(cible).getGuidePossede().get(0));
	listejoueur.get(cible).getGuidePossede().remove(0);
		}
		}
		
		System.out.println("Effet : Tous les croyants d'un Guide de chaque Divinités, sont défaussés");
		
	}

@Override
public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection,
		ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
	// TODO Auto-generated method stub
	
}


	
}
