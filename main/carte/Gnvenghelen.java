package main.carte;

import java.util.ArrayList;

import main.carte.Divinite;
import main.principal.*;


public class Gnvenghelen implements Effet{
	
	private Controller cont;
	private int max;
	private int joueurCible;

	@Override
	public void utiliserEffet(ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte, int j,
			ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection, ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
		// TODO Auto-generated method stub
		cont = Controller.getInstance();
		
		System.out.println("Effet Gnvenghelen utilisé");
		
		if (tourJoueur.get(j) == listejoueur.get(0)){ // Si c'est le joueur humain qui utilise
			System.out.println("Choisissez le joueur à qui vous voulez récupérer des points d'action Néant");
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
			
			tourJoueur.get(j).setPointAction(2, listejoueur.get(cont.getChoixCible()).getGuidePossede().size());
			cont.setChoixCible(-1);
			
			System.out.println("Effet: Le joueur " +tourJoueur.get(j).getNom() + " vole les Points Action du joueur " +cont.getChoixCible());
			
		}
		else if (tourJoueur.get(j) != listejoueur.get(0)){ // Si c'est l'IA qui utilise
				 max = 0;
				joueurCible =-1;;
			for (int i=0; i<listejoueur.size();i++){
			
				if (listejoueur.get(i).getGuidePossede().size() > max){
				max = listejoueur.get(i).getGuidePossede().size();
				joueurCible = i;
				}
			}
			
			if (max==0 ){
				joueurCible=0;
			}
			tourJoueur.get(j).setPointAction(2, listejoueur.get(joueurCible).getGuidePossede().size());
			System.out.println("Effet: Le joueur " +j+ " vole les Points Action du joueur " +joueurCible);
		}
		
		
	}

}
