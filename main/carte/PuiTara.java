package main.carte;

import java.util.ArrayList;

import main.principal.Effet;
import main.principal.Joueur;

public class PuiTara implements Effet{

	@Override
	public void utiliserEffet(ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte, int j,
			ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j,ArrayList<Carte> collection, ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
		// TODO Auto-generated method stub
		System.out.println("Effet Pui-Tara utilisé");
		
	}

}
