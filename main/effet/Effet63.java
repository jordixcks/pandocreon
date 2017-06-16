package main.effet;

import java.util.ArrayList;

import main.carte.Carte;
import main.principal.Controller;
import main.principal.Effet;
import main.principal.Joueur;

/**
 * <b>Effet63 est la classe representant l'effet de la carte 63.</b>
 * <p>Son effet : Prenez 3 cartes dans la main d'un autre joueur et incluez les à votre main.</p>
 */
public class Effet63 implements Effet {

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
			System.out.println(" Info : Choisissez une cible à qui vous voulez voler 3 cartes");
			
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
			
			for (int i=0;i<3;i++){
				tourjoueur.get(j).getMain().add(listejoueur.get(cont.getChoixCible()).getMain().get(0));
				tourjoueur.get(cont.getChoixCible()).getMain().remove(0);
				}
			System.out.println("Effet : Le " +tourjoueur.get(j).getNom()+ " vole 3 cartes de la main du " +listejoueur.get(cont.getChoixCible()));
			
			
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
			
			for (int i=0;i<3;i++){
			tourjoueur.get(j).getMain().add(listejoueur.get(joueurChoisi).getMain().get(0));
			tourjoueur.get(joueurChoisi).getMain().remove(0);
			}
			
			System.out.println("Effet : Le " +tourjoueur.get(j).getNom()+ " vole 3 cartes de la main du " +listejoueur.get(joueurChoisi));
		}
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection,
			ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
		// TODO Auto-generated method stub
		
	}

}
