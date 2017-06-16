package main.effet;

import java.util.ArrayList;

import main.carte.*;
import main.principal.*;
/**
 * <b>Effet24 est la classe representant l'effet des cartes 67, 68, 69, 70, 71.</b>
 * <p>Son effet : Annule la capacité spéciale.</p>
 */
public class Effet24 implements Effet{ 

Controller cont;
private int carteChoisie;
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
		
		if (tourjoueur.get(j) == listejoueur.get(0)){
			System.out.println(" Info : Choisissez la Divinité à qui vous voulez annuler l'effet de la carte");
			
			
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
			
			if (carte.getIdentifiantCarte()==67){
				for (int i=0; i<listejoueur.get(cont.getChoixCible()).getMain().size();i++){
					if (listejoueur.get(cont.getChoixCible()).getMain().get(i).getOrigineCarte()==3 || listejoueur.get(cont.getChoixCible()).getMain().get(i).getOrigineCarte()==2){
						System.out.println(cont.getChoixCible());
						carteChoisie = i;
						break;
					}
				}
			
			System.out.println("Effet : Le " +tourjoueur.get(j).getNom()+ " annule l'Effet d'une Carte du " +listejoueur.get(cont.getChoixCible()).getNom());
			listejoueur.get(cont.getChoixCible()).getMain().get(carteChoisie).setEffetAnnule(true);
			}
			
			if (carte.getIdentifiantCarte()==68){
				for (int i=0; i<listejoueur.get(cont.getChoixCible()).getMain().size();i++){
					if (listejoueur.get(cont.getChoixCible()).getMain().get(i).getOrigineCarte()==1 || listejoueur.get(cont.getChoixCible()).getMain().get(i).getOrigineCarte()==2){
						System.out.println(cont.getChoixCible());
						carteChoisie = i;
						break;
					}
				}
			
				System.out.println("Effet : Le " +tourjoueur.get(j).getNom()+ " annule l'Effet d'une Carte du " +listejoueur.get(cont.getChoixCible()).getNom());
			listejoueur.get(cont.getChoixCible()).getMain().get(carteChoisie).setEffetAnnule(true);
			}
			
			if (carte.getIdentifiantCarte()==69){
				for (int i=0; i<listejoueur.get(cont.getChoixCible()).getMain().size();i++){
					if (listejoueur.get(cont.getChoixCible()).getMain().get(i).getOrigineCarte()==1 || listejoueur.get(cont.getChoixCible()).getMain().get(i).getOrigineCarte()==3){
						System.out.println(cont.getChoixCible());
						carteChoisie = i;
						break;
					}
				}
			
				System.out.println("Effet : Le " +tourjoueur.get(j).getNom()+ " annule l'Effet d'une Carte du " +listejoueur.get(cont.getChoixCible()).getNom());
			listejoueur.get(cont.getChoixCible()).getMain().get(carteChoisie).setEffetAnnule(true);
			}
			
			if (carte.getIdentifiantCarte()==70 ||carte.getIdentifiantCarte()==71||carte.getIdentifiantCarte()==71  ){
				for (int i=0; i<listejoueur.get(cont.getChoixCible()).getMain().size();i++){
					if (listejoueur.get(cont.getChoixCible()).getMain().get(i).getIdentifiantCarte()>=1 && listejoueur.get(cont.getChoixCible()).getMain().get(i).getIdentifiantCarte()<=57){
						System.out.println(cont.getChoixCible());
						carteChoisie = i;
						break;
					}
				}
			
				System.out.println("Effet : Le " +tourjoueur.get(j).getNom()+ " annule l'Effet d'une Carte du " +listejoueur.get(cont.getChoixCible()).getNom());
			listejoueur.get(cont.getChoixCible()).getMain().get(carteChoisie).setEffetAnnule(true);
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
			
			if(carte.getIdentifiantCarte()==67){
				for (int i=0; i<listejoueur.get(joueurChoisi).getMain().size();i++){
					if (listejoueur.get(joueurChoisi).getMain().get(i).getOrigineCarte()==3 || listejoueur.get(joueurChoisi).getMain().get(i).getOrigineCarte()==2){
						carteChoisie = i;
						break;
					}
				}
			
				System.out.println("Effet : Le " +tourjoueur.get(j).getNom()+ " annule l'Effet d'une Carte du " +listejoueur.get(joueurChoisi).getNom());
			listejoueur.get(joueurChoisi).getMain().get(carteChoisie).setEffetAnnule(true);
			if (listejoueur.get(joueurChoisi) ==  listejoueur.get(0)){
				System.out.println("Votre carte " +listejoueur.get(0).getMain().get(carteChoisie).getInfosCarte()+ " a son effet annulé");
			}
			}
			
			if(carte.getIdentifiantCarte()==68){
				for (int i=0; i<listejoueur.get(joueurChoisi).getMain().size();i++){
					if (listejoueur.get(joueurChoisi).getMain().get(i).getOrigineCarte()==1 || listejoueur.get(joueurChoisi).getMain().get(i).getOrigineCarte()==2){
						carteChoisie = i;
						break;
					}
				}
				System.out.println("Effet : Le " +tourjoueur.get(j).getNom()+ " annule l'Effet d'une Carte du " +listejoueur.get(joueurChoisi).getNom());
			listejoueur.get(joueurChoisi).getMain().get(carteChoisie).setEffetAnnule(true);
			if (listejoueur.get(joueurChoisi) ==  listejoueur.get(0)){
				System.out.println("Votre carte " +listejoueur.get(0).getMain().get(carteChoisie).getInfosCarte()+ " a son effet annulé");
			}
			}
			
			if (carte.getIdentifiantCarte()==69){
				for (int i=0; i<listejoueur.get(joueurChoisi).getMain().size();i++){
					if (listejoueur.get(joueurChoisi).getMain().get(i).getOrigineCarte()==1 || listejoueur.get(joueurChoisi).getMain().get(i).getOrigineCarte()==3){
						carteChoisie = i;
						break;
					}
				}
				System.out.println("Effet : Le " +tourjoueur.get(j).getNom()+ " annule l'Effet d'une Carte du " +listejoueur.get(joueurChoisi).getNom());
			listejoueur.get(joueurChoisi).getMain().get(carteChoisie).setEffetAnnule(true);
			if (listejoueur.get(joueurChoisi) ==  listejoueur.get(0)){
				System.out.println("Votre carte " +listejoueur.get(0).getMain().get(carteChoisie).getInfosCarte()+ " a son effet annulé");
			}
			}
			
			if (carte.getIdentifiantCarte()==70 ||carte.getIdentifiantCarte()==71 ||carte.getIdentifiantCarte()==71  ){
				for (int i=0; i<listejoueur.get(joueurChoisi).getMain().size();i++){
					if (listejoueur.get(joueurChoisi).getMain().get(i).getIdentifiantCarte()>=1 && listejoueur.get(joueurChoisi).getMain().get(i).getIdentifiantCarte()<=57){
						carteChoisie = i;
						break;
					}
				}
				System.out.println("Effet : Le " +tourjoueur.get(j).getNom()+ " annule l'Effet d'une Carte du " +listejoueur.get(joueurChoisi).getNom());
			listejoueur.get(joueurChoisi).getMain().get(carteChoisie).setEffetAnnule(true);
			if (listejoueur.get(joueurChoisi) ==  listejoueur.get(0)){
				System.out.println("Votre carte " +listejoueur.get(0).getMain().get(carteChoisie).getInfosCarte()+ " a son effet annulé");
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
