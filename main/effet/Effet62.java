package main.effet;
import java.util.ArrayList;

import main.carte.*;
import main.principal.*;

/**
 * <b>Effet62 est la classe representant l'effet de la carte 62.</b>
 * <p>Son effet : Sacrifiez 2 cartes Croyants d'une autre Divinité. Les capacités spéciales ne sont pas jouées.</p>
 */
public class Effet62 implements Effet {

	Controller cont;
	private int nombre;
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
			System.out.println("Info : Choisissez une cible, qui devra sacrifier 2 cartes croyants");
			
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
			
			nombre =0;
			
		
				for (int i=0; i<listejoueur.get(cont.getChoixCible()).getGuidePossede().size();i++){
					if (listejoueur.get(cont.getChoixCible()).getGuidePossede().get(i).getCroyantPossede().size()>=1 && nombre<3){
						listejoueur.get(cont.getChoixCible()).getGuidePossede().get(i).getCroyantPossede().remove(0);
						nombre++;
					}
			}
				
			for (int k=0; k<listejoueur.get(cont.getChoixCible()).getGuidePossede().size();k++){
				if (listejoueur.get(cont.getChoixCible()).getGuidePossede().get(k).getCroyantPossede().size()==0){
					listejoueur.get(cont.getChoixCible()).getGuidePossede().remove(k);
				}
			}
				
			System.out.println("Effet : La cible a sacrifié " +nombre+ " croyants");
			
			
			
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
			
			nombre =0;
			
			
			for (int i=0; i<listejoueur.get(joueurChoisi).getGuidePossede().size();i++){
				if (listejoueur.get(joueurChoisi).getGuidePossede().get(i).getCroyantPossede().size()>=1 && nombre<3){
					listejoueur.get(joueurChoisi).getGuidePossede().get(i).getCroyantPossede().remove(0);
					nombre++;
				}
		}
			
		for (int k=0; k<listejoueur.get(joueurChoisi).getGuidePossede().size();k++){
			if (listejoueur.get(joueurChoisi).getGuidePossede().get(k).getCroyantPossede().size()==0){
				listejoueur.get(joueurChoisi).getGuidePossede().remove(k);
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
