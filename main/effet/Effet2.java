package main.effet;

import java.util.ArrayList;


import main.carte.*;
import main.principal.*;
/**
 * <b>Effet2 est la classe representant l'effet des cartes 6, 7, 19, 20, 32, 33.</b>
 * <p>Son effet : Empeche une divinité de sacrifier ses cartes croyants durant ce tour.</p>
 */
public class Effet2 implements Effet{ 
	/**
	 * Représente les dogmes de la Divinité.
	 */
		private int n1 , n2;
		private Controller cont;
		private int min;
		private int joueurChoisi;

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
				int id = carte.getIdentifiantCarte();
				
				if (id == 6 || id ==32){
					n1 = 1; // Nature
					n2 = 4; // Mystique
					
					System.out.println("Effet: Toutes les Divinités de Dogme Nature/Mystique ne peuvent pas sacrifier de Croyant ce tour ");
				}
				else if (id ==7 || id == 33){
					n1=2 ; // Chaos
					n2=4 ; // Mystique
					
					System.out.println("Effet: Toutes les Divinités de Dogme Chaos/Mystique ne peuvent pas sacrifier de Croyant ce tour ");
				}
				else if (id == 19){
					n1 =5; // Humain
					n2 =4; // Mystique
					
					System.out.println("Effet: Toutes les Divinités de Dogme Humain/Mystique ne peuvent pas sacrifier de Croyant ce tour ");
				}
				else if (id ==20){
					n1=5; // Humain
					n2=3; // Symboles
					
					System.out.println("Effet: Toutes les Divinités de Dogme Humain/Symbole ne peuvent pas sacrifier de Croyant ce tour ");
				}
		//Empeche une divinité n1 ou n2 de sacrifier ses cartes croyants durant ce tour
			for (int i=0;i<listejoueur.size();i++){
				if (listejoueur.get(i).getDivinite()!=tourjoueur.get(j).getDivinite()){
				if ((listejoueur.get(i).getDivinite().getNatureCarte1() == n1 || listejoueur.get(i).getDivinite().getNatureCarte1() == n2) || (listejoueur.get(i).getDivinite().getNatureCarte2() == n1 || listejoueur.get(i).getDivinite().getNatureCarte2() == n2) || (listejoueur.get(i).getDivinite().getNatureCarte3() == n1 || listejoueur.get(i).getDivinite().getNatureCarte3() == n2)) {
					listejoueur.get(i).setBlocageSacrificeCroyantTour(true);
				if (listejoueur.get(i) == listejoueur.get(0)){
					cont.setBlocageSacrificeCroyantTour(true);
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
