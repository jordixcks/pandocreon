package main.effet;

import java.util.ArrayList;

import main.carte.Carte;
import main.principal.Controller;
import main.principal.Effet;
import main.principal.Joueur;

/**
 * <b>Effet74 est la classe representant l'effet de la carte 74.</b>
 * <p>Son effet : Relancez le dé de Cosmogonie. Le tour de jeu se terminera normalement mais sous la nouvelle influence.</p>
 */
public class Effet74 implements Effet{
private Controller cont;

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
	public void utiliserEffet(ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte, int j,
			ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
		cont = Controller.getInstance();
		tourjoueur.get(j).lancerDe(listejoueur);
		cont.setInfluence((int)tourjoueur.get(0).getResultatDes());
		
		System.out.println("Effet: Le " +tourjoueur.get(j).getNom()+ " relance le Dé de Cosmogonie, l'influence change");
		
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection,
			ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
		// TODO Auto-generated method stub
		
	}

}
