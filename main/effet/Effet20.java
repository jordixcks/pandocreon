package main.effet;

import java.util.ArrayList;
import main.carte.*;
import main.principal.*;

/**
 * <b>Effet20 est la classe representant l'effet de la carte 56.</b>
 * <p>Son effet : Défausse tous les Croyants ayant le Dogme Mysitque actuellement au centre de la table.</p>
 */
public class Effet20 implements Effet{


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
		
		System.out.println("Effet : Tous les Croyants au centre de la table ayant le Dogme Mystique sont défaussés");
		for (int i=0; i<table.size();i++) {
			if (table.get(i).getNatureCarte1()==4 || table.get(i).getNatureCarte2()==4 || table.get(i).getNatureCarte3()==4) {
				collection.add(table.get(i));
				table.remove(i);
			}	
		}
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection,
			ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
		// TODO Auto-generated method stub
		
	}



}
