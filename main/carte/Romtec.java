package main.carte;

import java.util.*;

import main.carte.Divinite;
import main.principal.*;




public class Romtec implements Effet { // On empeche un joueur de poser sa carte Guide

	private Controller cont;
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
		System.out.println("Effet Romtec utilisé");
		
		cont = Controller.getInstance();
		
		if (tourJoueur.get(j) == listejoueur.get(0)){ // Si c'est le joueur humain qui utilise
			// On lui demande de cibler un joueur
			System.out.println("Choisissez le joueur à qui vous voulez privé l'utilisation d'une carte guide");
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
			
			if (listejoueur.get(cont.getChoixCible()).isBlocagePoserGuide()==false){
				listejoueur.get(cont.getChoixCible()).setBlocagePoserGuide(true);
			}
			else{
				System.out.println("Le joueur est déjà bloqué");
			}
			cont.setChoixCible(-1);
			
			
			
		}
		else if (tourJoueur.get(j)!= listejoueur.get(0)){ // Si c'est l'IA qui utilise
			// Etape pour choisir une cible si il le faut
			min = tourJoueur.get(j).getNombreCroyantTotal();
			 joueurChoisi = cible;	
			for (int a=0; a<listejoueur.size();a++){
					if (min> listejoueur.get(a).getNombreCroyantTotal() && (listejoueur.get(a) != tourJoueur.get(j) )){
						min = listejoueur.get(a).getNombreCroyantTotal();
						joueurChoisi=a ;
				}
					
					
			}
				
				if (listejoueur.get(joueurChoisi).isBlocagePoserGuide()==false){
					listejoueur.get(joueurChoisi).setBlocagePoserGuide(true);
				}
			
		}
		
		
	}
}
