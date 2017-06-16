package main.carte;

import java.util.ArrayList;

import main.principal.Controller;
import main.principal.Effet;
import main.principal.Joueur;

public class Llenvella implements Effet{

	private Controller cont;
	private int joueurChoisi;
	private int min;
	private int k;
	
	@Override
	public void utiliserEffet(ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte, int j,
			ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection, ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
		// TODO Auto-generated method stub
	/*
		System.out.println("Effet Llenvella/Killinstred utilisé");
		System.out.println("Effet: Toutes les Divinités doivent poser une carte Apocalypse si elles en possèdent une");
		// Oblie un joueur à jouer une carte apocalypse , s'il en possède une
		cont = Controller.getInstance();
		for (int k=0;k<listejoueur.size();k++){
			if (listejoueur.get(k).getDivinite() != tourJoueur.get(k).getDivinite()){
				
				for (int i=0; i<listejoueur.get(k).getMain().size();i++){
					if (listejoueur.get(k).getMain().get(i).getIdentifiantCarte()>=76 && listejoueur.get(k).getMain().get(i).getIdentifiantCarte()<=80){
					if (listejoueur.get(k) == listejoueur.get(0)){
						cont.getMain().get(i).setDoitEtrePose(true);
					}
					else{
						listejoueur.get(k).getMain().get(i).setDoitEtrePose(true);
					}
					listejoueur.get(j).forcerAction(k,listejoueur.get(k).isDoitPoserApocalypse(), listejoueur,0,table,collection,tourJoueur);
					break;
				}
			}
			}
		
		}
		*/
		
	}

}
