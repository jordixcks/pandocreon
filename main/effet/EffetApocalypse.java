package main.effet;

import java.util.*;


import main.carte.*;
import main.principal.*;
/**
 * <b>EffetApocalypse est la classe representant l'effet de la carte Apocalypse.</b>
 * <p>Son effet : Elimine le joueur qui possède le moins de croyants. </p>
 */
public class EffetApocalypse implements Effet {

	
private int min;
private int min2;
private int joueur;


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
public void utiliserEffet( ArrayList<Joueur> listeJoueur, int cible, ArrayList<Carte> table, Carte carte, int j, ArrayList<Carte> collection, ArrayList<Joueur> tourJoueur ){	
	min =99;
	joueur = 99;
	min2 = 99;
	for (int i=0; i<listeJoueur.size();i++){
		if (listeJoueur.get(i).getNombreCroyantTotal() <= min){
			min = listeJoueur.get(i).getNombreCroyantTotal();
			joueur = i;
		}
	}
	
	for (int k=0; k<listeJoueur.size();k++){
		if ( listeJoueur.get(k).getNombreCroyantTotal() <= min2 && listeJoueur.get(k)!=listeJoueur.get(joueur)){
			min2 = listeJoueur.get(k).getNombreCroyantTotal();
		}
		
	}
	
	if (min == min2){
		System.out.println("La carte apocalypse n'a aucun effet");
	}
	else{
		
		for (int x=0; x<listeJoueur.size();x++){
			if(listeJoueur.get(joueur).getDivinite() == tourJoueur.get(x).getDivinite()){
				if (joueur==0){
					listeJoueur.get(0).setPartieTerminee(true);
					break;
				}
				else{
					if ( joueur > listeJoueur.get(0).getPointDecalage() ){
						listeJoueur.get(x).setDecalage(1);
						listeJoueur.get(0).setPointDecalage(joueur);
					}
				listeJoueur.remove(joueur);
				tourJoueur.remove(x);
				break;
				}
			}
		}
	}
	

}

@Override
public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection,
		ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
	// TODO Auto-generated method stub
	
}



	
	
	
	
	
	
	
	
	
	
}
