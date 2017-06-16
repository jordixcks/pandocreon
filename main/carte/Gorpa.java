package main.carte;

import java.util.ArrayList;

import main.carte.Divinite;
import main.principal.*;

public class Gorpa implements Effet{

	private Controller cont;
	private int min;
	private int joueurChoisi;
	/*
	public void utiliserEffetDivinite(int cible, Partie p){ // Prends les pts action d'un joueur et les rajoute aux notres
		for (int i = 1; i<=3;i++){
			this.setPointAction(i, p.getListeJoueur().get(cible).getPtsAction(i));
			p.getListeJoueur().get(cible).setPointAction(p.getListeJoueur().get(cible).getPtsAction(i), 0);
		}
	}
*/
	@Override
	public void utiliserEffet(ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte, int j,
			ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j,ArrayList<Carte> collection, ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
		// TODO Auto-generated method stub
		System.out.println("Effet Gorpa utilisé");
		cont = Controller.getInstance();
		
		if (tourJoueur.get(j) == listejoueur.get(0)){ // Si c'est un humain qui utilise 
			System.out.println("Choisissez le joueur à qui vous voulez voler les points d'influence de ce tour");
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
		
		if (cont.getResultatDe()==1){ // Si on est jour
			int n = listejoueur.get(cont.getChoixCible()).getPtsAction(1);
			tourJoueur.get(j).setPointAction(1,n);
			listejoueur.get(cont.getChoixCible()).setPointAction(1,-n);
		}
		else if (cont.getResultatDe()==2){ // Si on est en nuit
			int n = listejoueur.get(cont.getChoixCible()).getPtsAction(3);
			tourJoueur.get(j).setPointAction(3,n);
			listejoueur.get(cont.getChoixCible()).setPointAction(3,-n);
		}
		else{
			int n = listejoueur.get(cont.getChoixCible()).getPtsAction(2);
			tourJoueur.get(j).setPointAction(2,n);
			listejoueur.get(cont.getChoixCible()).setPointAction(2,-n);
		}
			
			
			
		}
		else if (tourJoueur.get(j) != listejoueur.get(0)){ // Si c'est un ordi qui utilise
			min = tourJoueur.get(j).getNombreCroyantTotal();
			joueurChoisi = cible;	
			for (int a=0; a<listejoueur.size();a++){
					if (min> listejoueur.get(a).getNombreCroyantTotal() && (listejoueur.get(a) != tourJoueur.get(j) )){
						min = listejoueur.get(a).getNombreCroyantTotal();
						joueurChoisi=a ;
				}
			}
			
			if (cont.getResultatDe()==1){ // Si on est jour
				int n = listejoueur.get(joueurChoisi).getPtsAction(1);
				tourJoueur.get(j).setPointAction(1,n);
				listejoueur.get(joueurChoisi).setPointAction(1,-n);
				if (listejoueur.get(joueurChoisi) == listejoueur.get(0)){
					cont.setPtsJour(0);
				}
			}
			else if (cont.getResultatDe()==2){ // Si on est en nuit
				int n = listejoueur.get(joueurChoisi).getPtsAction(3);
				tourJoueur.get(j).setPointAction(3,n);
				listejoueur.get(joueurChoisi).setPointAction(3,-n);
				if (listejoueur.get(joueurChoisi) == listejoueur.get(0)){
					cont.setPtsNuit(0);
				}
			}
			else{
				int n = listejoueur.get(joueurChoisi).getPtsAction(2);
				tourJoueur.get(j).setPointAction(2,n);
				listejoueur.get(joueurChoisi).setPointAction(2,-n);
				if (listejoueur.get(joueurChoisi) == listejoueur.get(0)){
					cont.setPtsNeant(0);
				}
			}
			
		}
		
		
	}
	
}
