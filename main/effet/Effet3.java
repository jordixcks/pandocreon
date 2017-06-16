package main.effet;

import java.util.ArrayList;


import main.carte.*;
import main.principal.*;
/**
 * <b>Effet3 est la classe representant l'effet des cartes 8, 21, 34.</b>
 * <p>Son effet : Pioche deux cartes au hasard dans la main d'un autre joueur.</p>
 */
public class Effet3 implements Effet {



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
		
		int n = 1;
		for (int i =0; i<2; i++){
			int nombreAleatoire = 1 +(int)(Math.random()*(listejoueur.get(cible).getMain().size()-n));
			listejoueur.get(j).getMain().add(listejoueur.get(cible).getMain().get(nombreAleatoire));
			listejoueur.get(cible).getMain().remove(nombreAleatoire);
			n++;
		}

		System.out.println("Effet: Le joueur " +j+ " pioche 2 cartes aux hasard, dans les mains du joueur " +cible);
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection,
			ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
		// TODO Auto-generated method stub
		
	}


}
