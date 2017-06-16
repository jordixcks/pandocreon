package main.effet;

import java.util.ArrayList;

import main.carte.Carte;
import main.principal.Controller;
import main.principal.Effet;
import main.principal.Joueur;

/**
 * <b>Effet66 est la classe representant l'effet de la carte 66.</b>
 * <p>Son effet : Permet de bénéficier de la capacité spéciale de l'un de vos Croyants ou Guides Spirituels sans sacrifier la carte.</p>
 */
public class Effet66 implements Effet{

	private Controller cont;
	private int carteChoisie;
	
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
			System.out.println("Choisissez la carte dont vous voulez copier l'effet");
			
			cont.setDoitSacrifierGuide(true);
			cont.setDoitSacrifierCroyant(true);
			
			while (cont.isChoixJoueur()!=true){
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (cont.getReponse2()!=-1){ // Si c'est un croyant
				carte.setEffet(tourjoueur.get(j).getGuidePossede().get(cont.getReponse1()).getCroyantPossede().get(cont.getReponse2()).getEffet());
				carte.getEffet().utiliserEffet(listejoueur, cible, table, listejoueur.get(0).getMain().get(cont.getCarteChoisie()), j, collection, tourjoueur);
				System.out.println("Effet : Le " +tourjoueur.get(j).getNom()+ " vole l'Effet d'une autre carte");
			}
			else{
				
			}
		}
		else if (tourjoueur.get(j) != listejoueur.get(0)){
			for (int i=0; i<tourjoueur.get(j).getMain().size();i++){
				if (tourjoueur.get(j).getMain().get(i).getIdentifiantCarte()>=1 && tourjoueur.get(j).getMain().get(i).getIdentifiantCarte()<=57){
					carteChoisie = i;
					break;
				}
			}
			
			carte.setEffet(tourjoueur.get(j).getMain().get(carteChoisie).getEffet());
			carte.getEffet().utiliserEffet(listejoueur, cible, table, tourjoueur.get(j).getMain().get(carteChoisie), j, collection, tourjoueur);
			
			System.out.println("Effet : Le " +tourjoueur.get(j).getNom()+ " vole l'Effet d'une autre carte");
		}
		
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection,
			ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
		// TODO Auto-generated method stub
		
	}

}
