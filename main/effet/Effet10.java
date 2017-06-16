package main.effet;

import java.util.ArrayList;
import main.principal.*;
import main.carte.*;

/**
 * <b>Effet24 est la classe representant l'effet de la carte 37.</b>
 * <p>Son effet :Jusqu'à la fin du tour, plus aucune Divinité ne reçoit de points d'Action..</p>
 */
public class Effet10 implements Effet{ // id = 37

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
			int j, ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
		
		for (int i =0; i<listejoueur.size();i++){ 
			if (tourjoueur.get(j) == listejoueur.get(i)){
			}
			else{
				listejoueur.get(i).setStopPointAction(true);
				System.out.println("Effet: Toutes les Divinités sont interdit de Points d'Action ce tour !");
			}
			
	
		}
		
	}

@Override
public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection,
		ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
	// TODO Auto-generated method stub
	
}


}
