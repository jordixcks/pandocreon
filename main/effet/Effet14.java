package main.effet;
import java.util.ArrayList;

import main.principal.*;
import main.carte.*;

/**
 * <b>Effet14 est la classe representant l'effet de la carte 50.</b>
 * <p>Son effet : Sacrifie un Guide Spirituel, si lui ou sa Divinite ne croit pas au Dogme Chaos. Les capacites speciales sont jouees normalement.</p>
 */
public class Effet14 implements Effet {
	Controller cont;


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
		cont = Controller.getInstance();
		
		for (int i=0; i<listejoueur.size();i++){
			if (listejoueur.get(i) != tourjoueur.get(j)){
				for (int k=0; k<listejoueur.get(i).getGuidePossede().size();k++){
					if (listejoueur.get(i).getDivinite().getNatureCarte1() != 2 && listejoueur.get(i).getDivinite().getNatureCarte2() != 2 && listejoueur.get(i).getDivinite().getNatureCarte3() != 2 && listejoueur.get(i).getGuidePossede().get(k).getNatureCarte2() != 2 && listejoueur.get(i).getGuidePossede().get(k).getNatureCarte3() != 2){
						listejoueur.get(i).sacrifierCarte(collection, 0, k, j, listejoueur, cible, table, tourjoueur);
					}
				}
			}
		}
		
		System.out.println("Effet: Tous les Guides Spirituels dont leur Dogme, ou celui de leur Divinité n'est pas Chaos.\n Leurs effets sont joués.");
			
			
		}

@Override
public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection,
		ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
	// TODO Auto-generated method stub
	
}

	}
	
	


