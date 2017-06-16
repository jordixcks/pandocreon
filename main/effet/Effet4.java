package main.effet;

import java.util.ArrayList;
import main.carte.*;
import main.principal.*;

/**
 * <b>Effet4 est la classe representant l'effet de la carte 9, 10, 11, 22, 23.</b>
 * <p>Son effet : Forcer un sacrifice croyant.</p>
 */
public class Effet4 implements Effet {

	Controller cont;
	private int max;
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
	public void utiliserEffet(ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte,
			int j, ArrayList<Carte> collection,ArrayList<Joueur> tourjoueur) { // Forcer un sacrifice croyant
		cont = Controller.getInstance();
		int id = carte.getIdentifiantCarte();
		if (id ==9 || id ==10 || id==22 || id==23){
			if (tourjoueur.get(j) == listejoueur.get(0)){
				System.out.println("Choisissez le Divinité qui sera forcer de sacrifier un croyant");
				
				cont.setChoisirCible(true);
				
				while(cont.getChoixCible()==-1){
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Effet: Le " +tourjoueur.get(j).getNom() + " force le " +listejoueur.get(cont.getChoixCible()).getNom() + " à sacrifier un Croyant");
				
				if (listejoueur.get(cont.getChoixCible()).getNombreCroyantTotal()>0){
					for(int i=0;i<listejoueur.get(cont.getChoixCible()).getGuidePossede().size();i++){
						for (int k=0;k<listejoueur.get(cont.getChoixCible()).getGuidePossede().get(i).getCroyantPossede().size();k++){
							listejoueur.get(cont.getChoixCible()).getGuidePossede().get(i).getCroyantPossede().get(k).setSelectionnee(true); // On rend possible l'utilisation de la carte
						}
					}
					
					listejoueur.get(cont.getChoixCible()).setDoitSacrifierCroyant(true);
				tourjoueur.get(j).forcerAction(cont.getChoixCible(),listejoueur.get(cont.getChoixCible()).isDoitSacrifierCroyant(), listejoueur,0,table,collection,tourjoueur);
				}
				else{
					System.out.println("Info : Le " +listejoueur.get(cont.getChoixCible()).getNom() + " n'a aucun croyant a sacrifier ");
				}
				
			}
			else{
				
				 max = 0;
					joueurCible =-1;;
				for (int i=0; i<listejoueur.size();i++){
				
					if (listejoueur.get(i).getGuidePossede().size() > max){
					max = listejoueur.get(i).getGuidePossede().size();
					joueurCible = i;
					}
				}
				
			
			System.out.println("Effet: Le " +tourjoueur.get(j).getNom() + " force le " +listejoueur.get(joueurCible).getNom() + " à sacrifier un Croyant");
			if (listejoueur.get(joueurCible).getNombreCroyantTotal()>0){
				
					for(int i=0;i<listejoueur.get(joueurCible).getGuidePossede().size();i++){
						for (int k=0;k<listejoueur.get(joueurCible).getGuidePossede().get(i).getCroyantPossede().size();k++){
							listejoueur.get(joueurCible).getGuidePossede().get(i).getCroyantPossede().get(k).setSelectionnee(true); // On rend possible l'utilisation de la carte
						}
					}
				
				
				listejoueur.get(joueurCible).setDoitSacrifierCroyant(true);
			tourjoueur.get(j).forcerAction(joueurCible,listejoueur.get(joueurCible).isDoitSacrifierCroyant(), listejoueur,0,table,collection,tourjoueur);
			}
			else{
				System.out.println("Info : Le " +listejoueur.get(joueurCible).getNom() + " n'a aucun croyant à sacrifier");
			}
				
			}
		}
		else if ( id==11){
			if (tourjoueur.get(j) == listejoueur.get(0)){
				System.out.println("Choisissez le Divinité qui sera forcer de sacrifier un guide");
				while(cont.getChoixCible()==-1){
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Effet: Le " +tourjoueur.get(j).getNom() + " force le " +listejoueur.get(cont.getChoixCible()).getNom() + " à sacrifier un Guide");
				
				if(listejoueur.get(cont.getChoixCible()).getGuidePossede().size()>0){
					for (int i=0;i<listejoueur.get(cont.getChoixCible()).getGuidePossede().size();i++){
						for(int k=0;k<listejoueur.get(cont.getChoixCible()).getGuidePossede().get(i).getCroyantPossede().size();k++){
							listejoueur.get(cont.getChoixCible()).getGuidePossede().get(i).getCroyantPossede().get(k).setSelectionnee(true);
						}
					}
					listejoueur.get(cont.getChoixCible()).setDoitSacrifierGuide(true);
					tourjoueur.get(j).forcerAction(cont.getChoixCible(),listejoueur.get(cont.getChoixCible()).isDoitSacrifierGuide(), listejoueur,0,table,collection,tourjoueur);
				}
				else{
					System.out.println("Info : Le " +listejoueur.get(joueurCible).getNom() + " n'a aucun guide à sacrifier");
				}
				
			}
			else{
				
				 max = 0;
					joueurCible =-1;;
				for (int i=0; i<listejoueur.size();i++){
				
					if (listejoueur.get(i).getGuidePossede().size() > max){
					max = listejoueur.get(i).getGuidePossede().size();
					joueurCible = i;
					}
				}
				
				System.out.println("Effet: Le " +tourjoueur.get(j).getNom() + " force le " +listejoueur.get(joueurCible).getNom() + " à sacrifier un Guide");
				if (listejoueur.get(joueurCible).getGuidePossede().size()>0){
					
						for(int i=0;i<listejoueur.get(joueurCible).getGuidePossede().size();i++){
							listejoueur.get(joueurCible).getGuidePossede().get(i).setSelectionnee(true); // On rend possible l'utilisation de la carte	
						}
					
					
					listejoueur.get(joueurCible).setDoitSacrifierGuide(true);
				tourjoueur.get(j).forcerAction(joueurCible,listejoueur.get(joueurCible).isDoitSacrifierGuide(), listejoueur,0,table,collection,tourjoueur);
				}
				else{
					System.out.println("Info : Le " +listejoueur.get(joueurCible).getNom() + " n'a aucun guide à sacrifier");
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
