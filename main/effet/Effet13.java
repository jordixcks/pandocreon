package main.effet;
import main.principal.*;
import main.carte.*;



import java.util.ArrayList;

/**
 * <b>Effet13 est la classe representant l'effet de la carte 49.</b>
 * <p>Son effet : Sacrifie tous les Croyants d'Origine N�ant d'une Divinit� ayant le Dogme Humain. Les capacit�s sp�ciales sont jou�es normalement.</p>
 */
public class Effet13 implements Effet{ 

	Controller cont;
	
	/**
	 * Actionne l'effet de la carte.
	 * 
	 * @param listejoueur
	 * 			La liste des joueurs de la partie.
	 * @param cible
	 * 			La joueur contre qui l'effet sera jou�.
	 * @param table
	 * 			Collection de cartes situ�es au centre de la table de jeu.
	 * @param carte
	 * 			La carte qui joue l'effet.
	 * @param j
	 * 			Le joueur qui joue la carte.
	 * @param collection
	 * 			Le deck de cartes.
	 * @param tourjoueur
	 * 			La liste des joueurs selon l'ordre de jeu.
	 */
	@Override
	public void utiliserEffet( ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte,
			int j, ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
		// TODO Auto-generated method stub
		
	cont = Controller.getInstance();
	
		for (int i=0;i<listejoueur.size();i++){
			if (listejoueur.get(i) != tourjoueur.get(j)){
				
				if ((listejoueur.get(i).getDivinite().getNatureCarte1()==5) || (listejoueur.get(i).getDivinite().getNatureCarte2()==5) || (listejoueur.get(i).getDivinite().getNatureCarte3()==5)){
					for (int k = 0; k<listejoueur.get(i).getGuidePossede().size();k++){

						for (int n=0; n<listejoueur.get(i).getGuidePossede().get(k).getCroyantPossede().size();n++){
							if (listejoueur.get(i).getGuidePossede().get(k).getCroyantPossede().get(n).getOrigineCarte()==2){
								listejoueur.get(i).sacrifierCarte(collection, n,k, j, listejoueur, cible, table, tourjoueur);
							}
						}
					
				}
				}
			}
		}
		
		System.out.println("Effet : Tous les croyants d'Origine Neant des Divinit�s Humain , leurs effets sont jou�s");
		
		
	}

@Override
public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection,
		ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
	// TODO Auto-generated method stub
	
}


}
