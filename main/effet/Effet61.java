package main.effet;

import java.util.*;

import main.carte.*;
import main.principal.*;

/**
 * <b>Effet61 est la classe representant l'effet des cartes 61, 64.</b>
 * <p>Son effet : Vous récupérez un des Guides Spirituels posés devant une autre Divinité et le placez devant vous avec les Coyants qui y sont attachés.</p>
 */
public class Effet61 implements Effet{
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
	public void utiliserEffet(ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte, int j,
			ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
		cont = Controller.getInstance();
		
		if (tourjoueur.get(j) == listejoueur.get(0)){ 
			
			System.out.println(" Info : Choisissez la Divinité à qui vous voulez voler son guide");
			cont.setChoisirCible(true);
			cont.setChoixCible(-1);
			
			while(cont.getChoixCible()==-1){
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
					for (int i=0; i<listejoueur.get(cont.getChoixCible()).getGuidePossede().get(0).getCroyantPossede().size();i++){
						listejoueur.get(cont.getChoixCible()).getGuidePossede().get(0).getCroyantPossede().remove(i);
					}
					listejoueur.get(cont.getChoixCible()).getGuidePossede().remove(0);
					listejoueur.get(cont.getChoixCible()).getNombreCroyantTotal();
			System.out.println("Effet : Le " +tourjoueur.get(j).getNom() + " récupère le Guide Spirituel du " +listejoueur.get(cont.getChoixCible()).getNom());
			}
			else{
				System.out.println("Info : Aucun guide à prendre");
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
				if (listejoueur.get(joueurChoisi).getGuidePossede().size()>0){
					tourjoueur.get(j).getGuidePossede().add(listejoueur.get(joueurChoisi).getGuidePossede().get(0));
						for (int i=0; i<listejoueur.get(joueurChoisi).getGuidePossede().get(0).getCroyantPossede().size();i++){
							listejoueur.get(joueurChoisi).getGuidePossede().get(0).getCroyantPossede().remove(i);
						}
						listejoueur.get(joueurChoisi).getGuidePossede().remove(0);
						listejoueur.get(joueurChoisi).getNombreCroyantTotal();
						
						System.out.println("Effet : Le " +tourjoueur.get(j).getNom() + " récupère le Guide Spirituel du " +listejoueur.get(joueurChoisi).getNom());
				}
				else{
					System.out.println("Info : Aucun guide à prendre");
				}
				
		}
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection,
			ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
		// TODO Auto-generated method stub
		
	}
}
