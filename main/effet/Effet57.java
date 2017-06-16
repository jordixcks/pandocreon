package main.effet;

import java.util.ArrayList;

import main.carte.Carte;
import main.principal.Controller;
import main.principal.Effet;
import main.principal.Joueur;

/**
 * <b>Effet57 est la classe representant l'effet de la carte 57.</b>
 * <p>Son effet : Le joueur pose le dé de Cosmogonie sur la face qu'il désire et commence un nouveau tour de jeu.</p>
 */
public class Effet57 implements Effet {

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
	public void utiliserEffet(ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte, int j,
			ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
		cont = Controller.getInstance();
		
		if (tourjoueur.get(j) == listejoueur.get(0)){
			System.out.println("Info : Choisissez la face du dé");
			
			cont.setChoixInfluence(true);
			while ( cont.getResultatDe()==-1){
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			System.out.println("Effet : Le " +tourjoueur.get(j).getNom()+ " choisit de changer l'influence ");
			for (int i=0; i<listejoueur.size(); i++){
			if (cont.getResultatDe()==1){
				if ( listejoueur.get(i).getDivinite().getOrigineCarte() == 1 ){ // Si le joueur a une Divinité d'origine jour
					listejoueur.get(i).setPointAction(1,2); //On donne 2 pts jour
				
				}
				if ( listejoueur.get(i).getDivinite().getOrigineCarte() == 4){
					listejoueur.get(i).setPointAction(1,1);
				}
			}
			else if (cont.getResultatDe()==2){
				if (listejoueur.get(i).getDivinite().getOrigineCarte() == 3){
					listejoueur.get(i).setPointAction(3,2);
				}
				if (listejoueur.get(i).getDivinite().getOrigineCarte() == 5){
					listejoueur.get(i).setPointAction(3,1);
				}
			}
			else if (cont.getResultatDe()==3){
				if ( listejoueur.get(i).getDivinite().getOrigineCarte()==4 || listejoueur.get(i).getDivinite().getOrigineCarte()==5){
					listejoueur.get(i).setPointAction(2,1);
					}
			}
			}
			
			
		}
		else if (tourjoueur.get(j) != listejoueur.get(0)){
			
			System.out.println("Effet : Le " +tourjoueur.get(j).getNom()+ " choisit de changer l'influence ");
			
			if (tourjoueur.get(j).getDivinite().getOrigineCarte()==1){
				cont.setResultatDe(1);
			}
			else if (tourjoueur.get(j).getDivinite().getOrigineCarte()==2 ||tourjoueur.get(j).getDivinite().getOrigineCarte()==4 || tourjoueur.get(j).getDivinite().getOrigineCarte()==5 ){
				cont.setResultatDe(3);
			}
			else if (tourjoueur.get(j).getDivinite().getOrigineCarte()==3){
				cont.setResultatDe(2);
			}
			
			for (int i=0; i<listejoueur.size(); i++){
				if (cont.getResultatDe()==1){
					if ( listejoueur.get(i).getDivinite().getOrigineCarte() == 1 ){ // Si le joueur a une Divinité d'origine jour
						listejoueur.get(i).setPointAction(1,2); //On donne 2 pts jour
					
					}
					if ( listejoueur.get(i).getDivinite().getOrigineCarte() == 4){
						listejoueur.get(i).setPointAction(1,1);
					}
				}
				else if (cont.getResultatDe()==2){
					if (listejoueur.get(i).getDivinite().getOrigineCarte() == 3){
						listejoueur.get(i).setPointAction(3,2);
					}
					if (listejoueur.get(i).getDivinite().getOrigineCarte() == 5){
						listejoueur.get(i).setPointAction(3,1);
					}
				}
				else if (cont.getResultatDe()==3){
					if ( listejoueur.get(i).getDivinite().getOrigineCarte()==4 || listejoueur.get(i).getDivinite().getOrigineCarte()==5){
						listejoueur.get(i).setPointAction(2,1);
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
