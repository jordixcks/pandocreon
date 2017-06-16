package main.effet;

import java.util.ArrayList;

import main.principal.*;
import main.carte.*;

/**
 * <b>Effet17 est la classe representant l'effet de la carte 53.</b>
 * <p>Son effet : Oblige une Divinit� ayant leDogme Nature ou Mystique� sacrifier l'un de ses GuidesSpirituels.</p>
 */
public class Effet17 implements Effet { 

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
	/*	

			System.out.println("Effet: Toutes les Divinité de Dogme Nature ou Mystique doivent sacrifier un Guide Spirituel");
		for (int k=0;k<listejoueur.size();k++){
			if (listejoueur.get(k) != tourjoueur.get(j)){
				if ((listejoueur.get(k).getDivinite().getNatureCarte1()==1 || listejoueur.get(k).getDivinite().getNatureCarte1()==4) || (listejoueur.get(k).getDivinite().getNatureCarte2()==1 || listejoueur.get(k).getDivinite().getNatureCarte2()==4) || (listejoueur.get(k).getDivinite().getNatureCarte3()==1 || listejoueur.get(k).getDivinite().getNatureCarte3()==4)){
					if(listejoueur.get(k).getGuidePossede().size()>0){
					listejoueur.get(k).getGuidePossede().get(0).getEffet().utiliserEffet(listejoueur, 0, table, listejoueur.get(k).getGuidePossede().get(0), j, collection, tourjoueur);
					for (int i=0;i<listejoueur.get(k).getGuidePossede().get(0).getCroyantPossede().size();i++){
						table.add(listejoueur.get(k).getGuidePossede().get(0).getCroyantPossede().get(i));
						listejoueur.get(k).getGuidePossede().get(0).getCroyantPossede().remove(i);
					}
					collection.add(listejoueur.get(k).getGuidePossede().get(0));
					listejoueur.get(k).getGuidePossede().remove(0);
				}
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
