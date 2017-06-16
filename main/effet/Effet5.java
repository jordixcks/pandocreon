package main.effet;

import java.util.ArrayList;

import main.carte.*;
import main.principal.*;
/**
 * <b>Effet5 est la classe representant l'effet de la carte 12.</b>
 * <p>Son effet : Le joueur recup�re dans sa main un de ses guides spirituels pos�s sur la table, les croyants retournent au centre de la table.</p>
 */
public class Effet5 implements Effet{


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
	for(int k=0;k<listejoueur.size();k++){
	if (listejoueur.get(k) != tourjoueur.get(j)){
		for (int i=0; i<listejoueur.get(j).getGuidePossede().get(0).getCroyantPossede().size();i++){
			table.add(listejoueur.get(j).getGuidePossede().get(0).getCroyantPossede().get(i));
			listejoueur.get(j).getGuidePossede().get(0).getCroyantPossede().remove(i);
		}
		
		listejoueur.get(j).getMain().add(listejoueur.get(j).getGuidePossede().get(0));
		listejoueur.get(j).getGuidePossede().remove(0);
	}
	
	System.out.println("Effet: Toutes les Divinités, récupèrent dans leur main un de leur Guide Spirituel, et perdent leur croyant");
		
	}
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection,
			ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
		// TODO Auto-generated method stub
		
	}


	
}
