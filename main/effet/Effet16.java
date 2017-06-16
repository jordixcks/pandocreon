package main.effet;

import java.util.ArrayList;
import main.carte.*;
import main.principal.*;

/**
 * <b>Effet16 est la classe representant l'effet de la carte 52.</b>
 * <p>Son effet : Sacrifie 2 cartes Croyants d'une Divinit� ayant le Dogme Humain ou Symboles. Les capacit�s sp�ciales sont jou�es normalement.</p>
 */
public class Effet16 implements Effet{ 

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
	@Override
	public void utiliserEffet( ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte,
			int j, ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
		boolean boucle = true;
		int n =0;
		while (boucle && n<listejoueur.size()) {
		
			if ( (listejoueur.get(n).getDivinite().getNatureCarte1() == 3 || listejoueur.get(n).getDivinite().getNatureCarte1() == 5) || (listejoueur.get(n).getDivinite().getNatureCarte2() == 3 || listejoueur.get(n).getDivinite().getNatureCarte2() == 5) ||  (listejoueur.get(n).getDivinite().getNatureCarte3() == 3 || listejoueur.get(n).getDivinite().getNatureCarte3() == 5)) {
				if (listejoueur.get(n) != listejoueur.get(j)) {
					//listejoueur.get(n).croyantPossede.get(0).utiliserEffet(listejoueur.get(n).croyantPossede.get(0));
					//listejoueur.get(n).croyantPossede.get(0).utiliserEffet(listejoueur.get(n).croyantPossede.get(1));
					boucle = false;
				}
			}
			n++;
		}
		
	}

@Override
public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection,
		ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
	// TODO Auto-generated method stub
	
}


}
