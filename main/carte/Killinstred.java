package main.carte;

import java.util.ArrayList;

import main.carte.Divinite;
import main.principal.*;

public class Killinstred implements Effet{ 
	
	// Peut obliger un joueur � poser une carte apocalypse s'il en poss�de une
	//p.forcerAction(cible, p.listeJoueur.get(cible).doitPoserApocalypse);


	@Override
	public void utiliserEffet(ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte, int j,
			ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection, ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
		//listejoueur.get(j).forcerAction(cible, listejoueur.get(cible).doitPoserApocalypse, listejoueur);
		System.out.println("Effet Killinstred utilis�");
	
}
	}
	
