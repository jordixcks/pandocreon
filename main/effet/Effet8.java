package main.effet;

import java.util.ArrayList;
import main.principal.*;
import main.carte.*;

/**
 * <b>Effet8 est la classe representant l'effet de la carte 26.</b>
 * <p>Son effet : Utilise l'effet d'une carte croyant d'un autre joueur, la carte reste en jeu.</p>
 */
public class Effet8 implements Effet{
	
	private int carteAleatoire=-1;
	private Controller cont;
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
			int j, ArrayList<Carte> collection,ArrayList<Joueur> tourjoueur) {
	
		cont = Controller.getInstance();
	if( tourjoueur.get(j) == listejoueur.get(0)){ // Si c'est le joueur humain qui utilise
		cont.setChoisirCible(true);
		
		while(cont.getChoixCible()==-1){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		cont.setChoisirCible(false);
		
		for (int i=0; i<listejoueur.get(cont.getChoixCible()).getMain().size();i++){
			if (listejoueur.get(cont.getChoixCible()).getMain().get(i).getIdentifiantCarte()>=1 && listejoueur.get(cont.getChoixCible()).getMain().get(i).getIdentifiantCarte()<=37){
				carteAleatoire = i;
				break;
			}
		}
		if (carteAleatoire!=-1){
		listejoueur.get(cont.getChoixCible()).getMain().get(carteAleatoire).getEffet().utiliserEffet(listejoueur, 0, table,listejoueur.get(cont.getChoixCible()).getMain().get(carteAleatoire), j, collection, tourjoueur);
		}
		
		System.out.println("Effet : Le " +tourjoueur.get(j).getNom()+ " utilise l'Effet d'une carte du " +listejoueur.get(cont.getChoixCible()).getNom() );
	}
	else if( tourjoueur.get(j) != listejoueur.get(0)){ // Si c'est l'IA qui utilise
		 min = tourjoueur.get(j).getNombreCroyantTotal();
			joueurChoisi = cible;	
			for (int a=0; a<listejoueur.size();a++){
					if (min> listejoueur.get(a).getNombreCroyantTotal() && (listejoueur.get(a) != tourjoueur.get(j) )){
						min = listejoueur.get(a).getNombreCroyantTotal();
						joueurChoisi=a ;
				}
			}
			
			for (int i=0; i<listejoueur.get(joueurChoisi).getMain().size();i++){
				if (listejoueur.get(joueurChoisi).getMain().get(i).getIdentifiantCarte()>=1 && listejoueur.get(joueurChoisi).getMain().get(i).getIdentifiantCarte()<=37){
					carteAleatoire = i;
					break;
				}
			}
			if (carteAleatoire!=-1){
			listejoueur.get(joueurChoisi).getMain().get(carteAleatoire).getEffet().utiliserEffet(listejoueur, 0, table,listejoueur.get(joueurChoisi).getMain().get(carteAleatoire), j, collection, tourjoueur);
			}
			
			System.out.println("Effet : Le " +tourjoueur.get(j).getNom()+ " utilise l'Effet d'une carte du " +listejoueur.get(joueurChoisi).getNom());
	}
		
		
		
		
	}

@Override
public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection,
		ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
	// TODO Auto-generated method stub
	
}


}
