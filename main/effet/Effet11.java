package main.effet;

import java.util.ArrayList;
import main.principal.*;
import main.carte.*;

/**
 * <b>Effet11 est la classe representant l'effet de la carte 25.</b>
 * <p>Son effet : Récupérez les points d'Action d'une Divinité n'ayant pas encore joue durant ce tour. Les points d'Action gardent leur Origine. La Divinite perd ses points.</p>
 */
public class Effet11 implements Effet { // Id = 25
	

	private Controller cont;
	private int joueurCible;
	
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
	cont = Controller.getInstance();

if (j+1 < listejoueur.size()-1){
	for(int i=j+1; i<listejoueur.size();i++){
		joueurCible = i;
		if( cont.getResultatDe()==1){
			if ( tourjoueur.get(i).getDivinite().getOrigineCarte() == 1){ // Si le joueur a une Divinité d'origine jour
				tourjoueur.get(j).setPointAction(1,2); //On donne 2 pts jour
				tourjoueur.get(i).setPointAction(1, -2);
				break;
			}
			if ( tourjoueur.get(i).getDivinite().getOrigineCarte() == 4){
				tourjoueur.get(j).setPointAction(1,1);
				tourjoueur.get(i).setPointAction(1,-1);
				break;
			}	
			
		}
		else if (cont.getResultatDe()==2){ // Face nuit 
			if (tourjoueur.get(i).getDivinite().getOrigineCarte() == 3){
				tourjoueur.get(j).setPointAction(3,2);
				tourjoueur.get(i).setPointAction(3,-2);
				break;
			}
			if (tourjoueur.get(i).getDivinite().getOrigineCarte() == 5){
				tourjoueur.get(j).setPointAction(3,1);
				tourjoueur.get(i).setPointAction(3,-1);
				break;
			}
			
		}
		else if (cont.getResultatDe()==3){
			if ( tourjoueur.get(i).getDivinite().getOrigineCarte()==4 || tourjoueur.get(i).getDivinite().getOrigineCarte()==5){
				tourjoueur.get(j).setPointAction(2,1);
				tourjoueur.get(i).setPointAction(2,-1);
				break;
				}
		}
		
	}
	cont.setTexte("Effet: Le " +tourjoueur.get(j).getNom() +" récupère les points Action du " +listejoueur.get(joueurCible).getNom());
	
	}
	else{
		cont.setTexte(" Effet: Le " +tourjoueur.get(j).getNom() + " est le dernier joueur, l'effet n'est pas joué");
	}
	}
@Override
public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection,
		ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
	// TODO Auto-generated method stub
	
}



}
