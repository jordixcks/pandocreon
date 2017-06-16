package main.effet;

import java.util.ArrayList;

import main.carte.*;
import main.principal.*;
/**
 * <b>Effet22 est la classe representant l'effet de la carte 65.</b>
 * <p>Son effet : Aucun autre joueur ne gagne de points d'Action durant ce tour.</p>
 */
public class Effet22 implements Effet {


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
			int j, ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
		System.out.println("Effet : Plus personne ne gagne de Points Action durant ce tour sauf le " +tourjoueur.get(j).getNom());
		for(int n=0; n<listejoueur.size(); n++) {
			if (listejoueur.get(n)!=tourjoueur.get(j)){
			listejoueur.get(n).setStopPointAction(true);
			}
		}
		
	}

@Override
public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection,
		ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
	// TODO Auto-generated method stub
	
}



}
