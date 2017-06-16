package main.effet;

import java.util.ArrayList;

import main.carte.*;
import main.principal.*;

/**
 * <b>Effet15 est la classe representant l'effet de la carte 51.</b>
 * <p>Son effet : Tous les Croyants, d'Origine Nuit ou Neant et ayant le Dogme Nature, actuellement sur la table sont defausses. Les capacites sp�ciales ne sont pas jouees.</p>
 */
public class Effet15 implements Effet{
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
		for (int i=0; i<table.size();i++) {
			 if (  ((table.get(i).getNatureCarte1() == 1 ) || (table.get(i).getNatureCarte2() == 1)) && ((table.get(i).getOrigineCarte() == 2) || (table.get(i).getOrigineCarte() == 3))) {//On fait une recherche de cartes croyants qui sont dogme 1 ou dogme 2
				 collection.add(table.get(i));
				 table.remove(i);
			 }
			}
		
		System.out.println("Effet : Les Croyants à table, d'Origine Nuit/Neant et Dogme Nature sont balayées");
			 
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection,
			ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
		// TODO Auto-generated method stub
		
	}



}
