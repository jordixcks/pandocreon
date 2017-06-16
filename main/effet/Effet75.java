package main.effet;

import java.util.ArrayList;

import main.carte.Carte;
import main.principal.Controller;
import main.principal.Effet;
import main.principal.Joueur;

/**
 * <b>Effet75 est la classe representant l'effet de la carte 75.</b>
 * <p>Son effet : Choisissez un des Guides Spirituels d'un autre joueur, et l'un des votres. Lancez le dé de Cosmogonie. Sur Jour, le Guide adverse est sacrifié, sur Nuit le votre est sacrifié, sur Néant rien ne se passe.</p>
 */
public class Effet75 implements Effet {
	Controller cont;
	private int joueurChoisi;
	private int min;

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
			System.out.println("Info : Choisissez une divinité");
			
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
			
			if (listejoueur.get(cont.getChoixCible()).getGuidePossede().size()>=1 && listejoueur.get(0).getGuidePossede().size()>=1){
				listejoueur.get(0).lancerDe(listejoueur);
				
				if (listejoueur.get(0).getResultatDe()>=0 && listejoueur.get(0).getResultatDe()<1){ // Effet jour
					System.out.println(" Effet : Dé sur la face Jour : le guide adverse est sacrifié ");
					listejoueur.get(cont.getChoixCible()).setSacrifierGuide(true);
					listejoueur.get(cont.getChoixCible()).sacrifierCarte(collection, 0,0, j, listejoueur, cible, table, tourjoueur);
					
				}
				else if (listejoueur.get(0).getResultatDe()<=1 && listejoueur.get(0).getResultatDe()<2){ // Effet nuit
					System.out.println(" Effet : Dé sur la face nuit: votre guide est sacrifié");
					listejoueur.get(0).sacrifierCarte(collection, 0, 0, j, listejoueur, cible, table, tourjoueur);
					
				}
				else{
					System.out.println("Effet : Dé sur la face néant : rien ne se passe");
				}
				
			}
		}
		
		
		else if (tourjoueur.get(j) != listejoueur.get(0)){
			min = tourjoueur.get(j).getNombreCroyantTotal();
			 joueurChoisi = cible;	
			for (int a=0; a<listejoueur.size();a++){
					if (min> listejoueur.get(a).getNombreCroyantTotal() && (listejoueur.get(a) != tourjoueur.get(j) )){
						min = listejoueur.get(a).getNombreCroyantTotal();
						joueurChoisi=a ;
				}	
			}
			
			if (listejoueur.get(joueurChoisi) == listejoueur.get(0)){
				System.out.println(" Info : Vous êtes la cible");
			}
			
			if (listejoueur.get(joueurChoisi).getGuidePossede().size()>=1 && tourjoueur.get(0).getGuidePossede().size()>=1){
				tourjoueur.get(0).lancerDe(listejoueur);
				
				if (tourjoueur.get(0).getResultatDe()>=0 && tourjoueur.get(0).getResultatDe()<1){ // Effet jour
					System.out.println(" Effet : Dé sur la face Jour : le guide adverse est sacrifié ");
					listejoueur.get(joueurChoisi).setSacrifierGuide(true);
					listejoueur.get(joueurChoisi).sacrifierCarte(collection, 0,0, j, listejoueur, cible, table, tourjoueur);
					
				}
				else if (tourjoueur.get(0).getResultatDe()<=1 && tourjoueur.get(0).getResultatDe()<2){ // Effet nuit
					System.out.println(" Effet : Dé sur la face nuit: votre guide est sacrifié");
					tourjoueur.get(0).sacrifierCarte(collection, 0, 0, j, listejoueur, cible, table, tourjoueur);
					
				}
				else{
					System.out.println(" Effet : Dé sur la face néant : rien ne se passe");
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
