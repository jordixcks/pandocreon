package main.effet;

import java.util.ArrayList;

import main.principal.*;
import main.carte.*;

/**
 * <b>Effet12 est la classe representant l'effet des cartes 41, 42, 43, 44, 45, 46, 47, 48.</b>
 * <p>Son effet : Fait gagner un nombre de points d'Action egal au nombre de cartes de Croyants rattaches. L'Origine des points d'Action est au choix du joueur..</p>
 */
public class Effet12 implements Effet{
	
	Controller cont;
	private int nb;


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
		
		if (tourjoueur.get(j)==listejoueur.get(0)){ 
			nb = carte.getCroyantPossede().size();
			System.out.println("Info : Choisissez l'origine en cliquant sur une icone");
			
			cont.setModePoserCarte(false);
			cont.setChoixInfluence(true);
			
			while(cont.getResultatDe()==-1){
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			cont.setChoixInfluence(false);
			
			if( cont.getResultatDe()==1){
				listejoueur.get(0).setPointAction(1, nb);
				System.out.println("Effet: Le " +tourjoueur.get(j).getNom()+ " gagne " +nb+ " points d'Action Jour");
			}
			else if (cont.getResultatDe()==2){
				listejoueur.get(0).setPointAction(3, nb);
				System.out.println("Effet: Le " +tourjoueur.get(j).getNom()+ " gagne " +nb+ " points d'Action Nuit");
			}
			else if (cont.getResultatDe()==3){
				listejoueur.get(0).setPointAction(2, nb);
				System.out.println("Effet: Le " +tourjoueur.get(j).getNom()+ " gagne " +nb+ " points d'Action Neant");
			}
			
		}
		
		
		
		else if (tourjoueur.get(j)!= listejoueur.get(0)){ 
			 nb = carte.getCroyantPossede().size();
			
			
			if (tourjoueur.get(j).getDivinite().getOrigineCarte()==1){
				tourjoueur.get(j).setPointAction(1, nb);
				System.out.println(" Effet: Le " +tourjoueur.get(j).getNom()+ " gagne " +nb+ " points d'Action Jour");
			}
			else if (tourjoueur.get(j).getDivinite().getOrigineCarte()==2 ||tourjoueur.get(j).getDivinite().getOrigineCarte()==4 || tourjoueur.get(j).getDivinite().getOrigineCarte()==5 ){
				tourjoueur.get(j).setPointAction(2, nb);
				System.out.println("Effet: Le " +tourjoueur.get(j).getNom()+ " gagne " +nb+ " points d'Action Neant");
			}
			else if (tourjoueur.get(j).getDivinite().getOrigineCarte()==3){
				tourjoueur.get(j).setPointAction(3,nb);
				System.out.println("Effet: Le " +tourjoueur.get(j).getNom()+ " gagne " +nb+ " points d'Action Nuit");
			}
			
		}
		
	}


	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection,
			ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
		// TODO Auto-generated method stub
		
	}


}
