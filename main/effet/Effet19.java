package main.effet;

import java.util.ArrayList;

import main.principal.*;
import main.carte.*;
/**
 * <b>Effet19 est la classe representant l'effet de la carte 55.</b>
 * <p>Son effet : Echangez l'un de vos Guides Spirituels avec un d'une autre Divinité.Vous choisissez les deux guides spirituels en question. Les Croyants restent attachés aux mêmes cartes.</p>
 */
public class Effet19 implements Effet{ // id = 55
	
	Controller cont;

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
			int j, ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
	
		cont = Controller.getInstance();
		
		if (tourjoueur.get(j)==listejoueur.get(0)){
			if(listejoueur.get(0).getGuidePossede().size()>0){
			System.out.println(" Info : Choisissez votre guide à échanger");
			
			cont.setDoitSacrifierGuide(true);
			
			while(cont.isDoitSacrifierGuide()==true){
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			cont.setChoisirCible(false);
			System.out.println(" Info : Choisissez avec qui vous voulez l'échanger");
			
			cont.setChoisirCible(true);
			
			while (cont.getChoixCible()==-1){
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			cont.setChoisirCible(false);
			
			if (listejoueur.get(cont.getChoixCible()).getGuidePossede().size()>0){
			
				listejoueur.get(0).getGuidePossede().add(listejoueur.get(cont.getChoixCible()).getGuidePossede().get(0));
				listejoueur.get(cont.getChoixCible()).getGuidePossede().remove(0);
				listejoueur.get(cont.getChoixCible()).getGuidePossede().add(listejoueur.get(0).getGuidePossede().get(cont.getCarteChoisie()));
				listejoueur.get(0).getGuidePossede().remove(cont.getCarteChoisie());
			}
			else{
				System.out.println("Info : Votre cible n'a pas de guide");
			}
			
			
			
			}
			
			else{
				System.out.println("Info : Vous n'avez pas de guide à échanger");
			}
			
		}
		else if (tourjoueur.get(j) != listejoueur.get(0)){
		
			if (tourjoueur.get(j).getGuidePossede().size()>0){
				for (int a=0; a<listejoueur.size();a++){
					if (min> listejoueur.get(a).getNombreCroyantTotal() && (listejoueur.get(a) != tourjoueur.get(j) )){
						min = listejoueur.get(a).getNombreCroyantTotal();
						joueurChoisi=a ;
				}
			}
				
				if (listejoueur.get(joueurChoisi).getGuidePossede().size()>0){
					tourjoueur.get(j).getGuidePossede().add(listejoueur.get(joueurChoisi).getGuidePossede().get(0));
					listejoueur.get(joueurChoisi).getGuidePossede().remove(0);
					listejoueur.get(joueurChoisi).getGuidePossede().add(tourjoueur.get(j).getGuidePossede().get(0));
					tourjoueur.get(j).getGuidePossede().remove(0);
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
