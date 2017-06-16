package main.carte;

import java.util.ArrayList;

import main.principal.Controller;
import main.principal.Effet;
import main.principal.Joueur;

public class Shingva implements Effet {

	private Controller cont;
	private int carteChoisie;
	private int min;
	private int joueurChoisi;
	@Override
	public void utiliserEffet(ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte, int j,
			ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j,ArrayList<Carte> collection, ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
		// TODO Auto-generated method stub
		
		// Oblige la cible à sacrifier un guide spirituel ayant le dogme symbole ou nature
		System.out.println("Effet Shingva utilisé");
		cont = Controller.getInstance();
		if (tourJoueur.get(j)== listejoueur.get(0)){ // Si c'est le joueur humain qui lance
			
			
				
				System.out.println("Choisissez le joueur à qui vous voulez obligé de poser un guide (symbole/nature)");
				cont.setChoisirCible(true);
				///////////////////////
				///////////////////////
				/////////////////////////
				// Mettre une boolean sur tous les labels, qui interdisent l'utilisation si choisirCible est activée, donc tout marche if choisirCible == false
				//////////////////////
				/////////////////////
				/////////////////////
				while(cont.getChoixCible()==-1){
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				cont.setChoisirCible(false);
				
				carteChoisie =-1;
				for (int i = 0; i<listejoueur.get(cont.getChoixCible()).getGuidePossede().size();i++){
					if (listejoueur.get(cont.getChoixCible()).getGuidePossede().get(i).getNatureCarte2()==1 || listejoueur.get(cont.getChoixCible()).getGuidePossede().get(i).getNatureCarte2() == 3 || listejoueur.get(cont.getChoixCible()).getGuidePossede().get(i).getNatureCarte3() == 1 || listejoueur.get(cont.getChoixCible()).getGuidePossede().get(i).getNatureCarte3() ==3 ){
						carteChoisie = i;
						// Ne pas oublier de créer une condition pour qu'on choissise la carte avec le bon dogme
						tourJoueur.get(j).forcerAction(cont.getChoixCible(), listejoueur.get(cont.getCarteChoisie()).isDoitSacrifierGuide(), listejoueur,0, table, collection, tourJoueur);
						break;
					}
				
				}
				
				if (carteChoisie ==-1){
					System.out.println("La cible n'a pas de guide Spirituel de ce genre");
				}
				
				cont.setChoixCible(-1);
				
				
			
		}
		else if(tourJoueur.get(j) != listejoueur.get(0)){
			min = tourJoueur.get(j).getNombreCroyantTotal();
			joueurChoisi = cible;	
			for (int a=0; a<listejoueur.size();a++){
					if (min> listejoueur.get(a).getNombreCroyantTotal() && (listejoueur.get(a) != tourJoueur.get(j) )){
						min = listejoueur.get(a).getNombreCroyantTotal();
						joueurChoisi=a ;
				}
			}
			
			for (int i=0; i<listejoueur.get(joueurChoisi).getGuidePossede().size();i++){
				if (listejoueur.get(joueurChoisi).getGuidePossede().get(i).getNatureCarte2()==1 || listejoueur.get(joueurChoisi).getGuidePossede().get(i).getNatureCarte2() == 3 || listejoueur.get(joueurChoisi).getGuidePossede().get(i).getNatureCarte3() == 1 || listejoueur.get(joueurChoisi).getGuidePossede().get(i).getNatureCarte3() ==3 ){
					if (listejoueur.get(joueurChoisi) == listejoueur.get(0)){
						cont.getCarteSuivie(i,0).setDoitEtrePose(true);
					}
					else{
						listejoueur.get(joueurChoisi).getGuidePossede().get(i).setDoitEtrePose(true);
					}
					listejoueur.get(j).forcerAction(joueurChoisi, listejoueur.get(joueurChoisi).isDoitSacrifierGuide(),listejoueur, 0, table, collection, tourJoueur);
					break;
				}
			}
			
		}
		
		
	}


}

