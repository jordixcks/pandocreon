package main.effet;

import java.util.ArrayList;
import java.util.Scanner;

import main.carte.*;
import main.principal.*;
/**
 * <b>Effet9 est la classe representant l'effet de la carte 36.</b>
 * <p>Son effet :Imposez le sacrifice d'une carte de Croyants � autant de Divinit�s que vous le voulez. Chaque Divinit� choisit la carte � sacrifier. Les capacit�s sp�ciales sont jou�es.</p>
 */
public class Effet9 implements Effet{
	protected Scanner sc;
	private Controller cont;
	private int nombreAleatoire;
	private int idJoueurAleatoire;

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
		
		if (tourjoueur.get(j)==listejoueur.get(0)){ // Si c'est le joueur humain qui utilise l'effet
			System.out.println("Choisissez la ou les cibles");
			
			cont.setChoisirCibleMultiple(true);
			while(cont.isChoisirCibleMultiple()==true){
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			for (int i=0; i<listejoueur.size();i++){
				if (cont.getChoixCibleMultiple()[i]!=-1){
					
					System.out.println("Effet : Le " +listejoueur.get(i).getNom()+ " doit sacrifier une carte Croyant");
					for(int k=0;k<listejoueur.get(i).getGuidePossede().size();k++){
						for (int z=0;z<listejoueur.get(i).getGuidePossede().get(k).getCroyantPossede().size();z++){
							listejoueur.get(i).getGuidePossede().get(k).getCroyantPossede().get(z).setSelectionnee(true);
						}
					}
					tourjoueur.get(j).forcerAction(i, listejoueur.get(i).isDoitSacrifierCroyant(), listejoueur, 0, table, collection, tourjoueur);
				}
			}
		}
		else if (tourjoueur.get(j) != listejoueur.get(0)){ // Si c'est le joueur machine qui utilise l'effet
			nombreAleatoire = 1 + (int)(Math.random()* (listejoueur.size()-1));
				for (int i=0; i<= nombreAleatoire ; i++){
					idJoueurAleatoire = 1 + (int)(Math.random()*(listejoueur.size()-1));
					 if(listejoueur.get(idJoueurAleatoire) != tourjoueur.get(j)){
						 
						 System.out.println("Effet : Le " +listejoueur.get(idJoueurAleatoire).getNom()+ " doit sacrifier une carte Croyant");
						 for( int k=0;i<listejoueur.get(idJoueurAleatoire).getGuidePossede().size();i++){
							 for (int z=0; z<listejoueur.get(idJoueurAleatoire).getGuidePossede().get(k).getCroyantPossede().size();z++){
								 listejoueur.get(idJoueurAleatoire).getGuidePossede().get(k).getCroyantPossede().get(z).setSelectionnee(true);
							 }
						 }
						 tourjoueur.get(j).forcerAction(idJoueurAleatoire, listejoueur.get(idJoueurAleatoire).isDoitSacrifierCroyant(), listejoueur,0, table, collection, tourjoueur);
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
