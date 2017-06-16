package main.effet;

import java.util.ArrayList;

import main.carte.*;
import main.principal.*;


/**
 * <b>Effet18 est la classe representant l'effet de la carte 54.</b>
 * <p>Son effet : Une Divinit� d'Origine Nuit ou ayant les Dogmes Mystique ou Chaos reprend dans sa main l'un de ses Guides Spirituels. Les Croyants qui y �taient attach�s sont d�fauss�s.</p>
 */
public class Effet18 implements Effet{



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
		
		
		System.out.println("Effet: Les Divinités d'Origine Nuit ou de Dogme Mystique / Chaos , reprennent dans leur mains un de leur Guide Spirituel");
	 /*
		for (int n=0; n<listejoueur.size();n++){
			if ( (listejoueur.get(n).getDivinite().getNatureCarte1() == 2 || listejoueur.get(n).getDivinite().getNatureCarte1() == 4) || (listejoueur.get(n).getDivinite().getNatureCarte2() == 2 || listejoueur.get(n).getDivinite().getNatureCarte2() == 4) ||  (listejoueur.get(n).getDivinite().getNatureCarte3() == 2 || listejoueur.get(n).getDivinite().getNatureCarte3() == 4) || listejoueur.get(n).getDivinite().getOrigineCarte() == 3) {
				if (listejoueur.get(n) != listejoueur.get(j)) {
					for (int i = 0; i <listejoueur.get(n).getGuidePossede().get(0).getCroyantPossede().size(); i++) {
						table.add(listejoueur.get(n).getGuidePossede().get(0).getCroyantPossede().get(i));
						listejoueur.get(n).getGuidePossede().get(0).getCroyantPossede().remove(i);
					}
					
					listejoueur.get(n).getMain().add(listejoueur.get(n).getGuidePossede().get(0));
					listejoueur.get(n).getGuidePossede().remove(0);
					
				}
			}
			
		}
		*/
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection,
			ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
		// TODO Auto-generated method stub
		
	}


}
