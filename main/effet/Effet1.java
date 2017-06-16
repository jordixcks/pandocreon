package main.effet;

import java.util.ArrayList;
import main.principal.*;
import main.carte.*;
/**
 * <b>Effet1 est la classe representant l'effet des cartes 1, 2, 3, 4, 5, 14, 15, 16, 17, 18, 27, 28, 29, 30, 31.</b>
 * <p>Son effet : Le joueur reçoit 1 point Action</p>
 */
public class Effet1 implements Effet {



	private Controller cont;
	/**
	 * ID de la carte.
	 */
	private int id;

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
	public void utiliserEffet( ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte, int j , ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
		
		 id = carte.getIdentifiantCarte();
		 cont = Controller.getInstance();
		 
		if (id==1 || id==2 || id==3 || id==4 || id==5 ){
			tourjoueur.get(j).setPointAction(1,1); // Donne un point d'action jour
			System.out.println(" Le joueur " +tourjoueur.get(j).getNom()+ " reçoit 1 point d'action Jour") ;
		}
		if( id==14 || id ==15 || id == 16 || id ==17 || id ==18){
			tourjoueur.get(j).setPointAction(3,1); // Donne un point d'action Nuit
			System.out.println(" Le joueur " +tourjoueur.get(j).getNom()+ " reçoit 1 point d'action Nuit");
		}
			
		if (id==27 || id==28 || id==29 || id==30 || id==31){ // Donne un point d'action néant
			listejoueur.get(j).setPointAction(2,1);
			System.out.println(" Le joueur " +tourjoueur.get(j).getNom()+ " reçoit 1 point d'action Néant");
		}
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection,
			ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
		// TODO Auto-generated method stub
		
	}


	
	
	
}
