package main.effet;

import java.util.ArrayList;

import main.carte.Carte;
import main.principal.Controller;
import main.principal.Effet;
import main.principal.Joueur;

/**
 * <b>Effet60 est la classe representant l'effet des cartes 60.</b>
 * <p>Son effet : Protège un Guide Sprituel et ses Croyants jusqu'à ce que cette soit annulée ou jusqu'à la prochaine tentative d'Apocalypse.</p>
 */
public class Effet60 implements Effet{

	private Controller cont;
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
		if (tourjoueur.get(j) == listejoueur.get(0)){ // Si c'est l'humain qui utilise
			if (listejoueur.get(0).getGuidePossede().size()==0){
				System.out.println("Info : Vous n'avez pas de guide à proteger");
			}
			else{
			System.out.println("Info : Choisissez le guide que vous voulez proteger");
				
			cont.setDoitSacrifierGuide(true);
			while (cont.isDoitSacrifierGuide()==true){
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			listejoueur.get(0).getGuidePossede().get(cont.getReponse1()).setEstProtege(true);
			for (int i=0; i<listejoueur.get(0).getGuidePossede().get(cont.getReponse1()).getCroyantPossede().size();i++){
				listejoueur.get(0).getGuidePossede().get(cont.getReponse1()).getCroyantPossede().get(i).setEstProtege(true);
			}
			
			System.out.println("Effet : Le " +tourjoueur.get(j).getNom()+ " protège une de ses cartes" );
			}
		}
		else if (tourjoueur.get(j) != listejoueur.get(0)){
			if (tourjoueur.get(j).getGuidePossede().size()==0){
				// L'effet ne s'applique pas
			}
			else{
				tourjoueur.get(j).getGuidePossede().get(0).setEstProtege(true);
				for (int i=0; i<tourjoueur.get(j).getGuidePossede().get(0).getCroyantPossede().size();i++){
					tourjoueur.get(0).getGuidePossede().get(0).getCroyantPossede().get(i).setEstProtege(true);
				}
				System.out.println("Effet : Le " +tourjoueur.get(j).getNom()+ " protège une de ses cartes" );
			}
			
		}
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection,
			ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
		// TODO Auto-generated method stub
		
	}

}
