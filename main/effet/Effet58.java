package main.effet;

import java.util.*;
import main.carte.*;
import main.principal.*;

/**
 * <b>Effet58 est la classe representant l'effet des cartes 58, 59.</b>
 * <p>Son effet : Détruit une carte Guide Spirituel dont la capacité spéciale n'a pas effet. Les croyants attachés reviennent au centre de la table.</p>
 */
public class Effet58 implements Effet{

	private Controller cont ;
	private int fois;
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
	public void utiliserEffet(ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte, int j,
			ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
		cont = Controller.getInstance();
		
	if (carte.getIdentifiantCarte() == 58){	
		if (tourjoueur.get(j) == listejoueur.get(0)){
			System.out.println(" Info : Choisissz la divinité qui perdra un guide spirituel d'origine nuit ou néant ");
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
			
			fois =1;
			for (int i=0; i<listejoueur.get(cont.getChoixCible()).getGuidePossede().size(); i++){
				if (listejoueur.get(cont.getChoixCible()).getGuidePossede().get(i).getOrigineCarte()==3 || listejoueur.get(cont.getChoixCible()).getGuidePossede().get(i).getOrigineCarte()==2 && fois==1){
					for (int k=0; k<listejoueur.get(cont.getChoixCible()).getGuidePossede().get(i).getCroyantPossede().size();k++){
						table.add(listejoueur.get(cont.getChoixCible()).getGuidePossede().get(i).getCroyantPossede().get(k));
						cont.setTable(table);
						listejoueur.get(cont.getChoixCible()).getGuidePossede().get(i).getCroyantPossede().remove(k);
						// On met à jour son nombre de croyant
						listejoueur.get(cont.getChoixCible()).getNombreCroyantTotal();
						fois++;
					}
				}
			}
			
		System.out.println("Effet : Le " +listejoueur.get(cont.getChoixCible()).getNom() + " perd un Guide Spirituel d'Origine Nuit ou Neant");
			
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
				
				fois =1;
				for (int i=0; i<listejoueur.get(joueurChoisi).getGuidePossede().size(); i++){
					if (listejoueur.get(joueurChoisi).getGuidePossede().get(i).getOrigineCarte()==3 || listejoueur.get(joueurChoisi).getGuidePossede().get(i).getOrigineCarte()==2 && fois==1){
						for (int k=0; k<listejoueur.get(joueurChoisi).getGuidePossede().get(i).getCroyantPossede().size();k++){
							table.add(listejoueur.get(joueurChoisi).getGuidePossede().get(i).getCroyantPossede().get(k));
							cont.setTable(table);	
							listejoueur.get(joueurChoisi).getGuidePossede().get(i).getCroyantPossede().remove(k);
							// On met à jour son nombre de croyant
							listejoueur.get(joueurChoisi).getNombreCroyantTotal();
							if (listejoueur.get(joueurChoisi) == listejoueur.get(0)){
								for (int z=0;z<listejoueur.size();z++){
									cont.setNombrePriere(z+listejoueur.get(0).getDecalage(), listejoueur.get(z).getNombreCroyantTotal());
								 
							}
							}
							fois++;
						}
					}
				}
				
				System.out.println("Effet : Le " +listejoueur.get(joueurChoisi).getNom() + " perd un Guide Spirituel d'Origine Nuit ou Neant s'il en possède");
		}
	}
	
	
	
	
	
	
	
	
	else if (carte.getIdentifiantCarte() == 59){
if (tourjoueur.get(j) == listejoueur.get(0)){ // Si c'est l'humain qui joue
			
	if (tourjoueur.get(j) == listejoueur.get(0)){ // Si c'est l'humain qui joue
		System.out.println("Info : Choisissz la divinité qui perdra un guide spirituel d'origine Jour ou Neant ");
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
		
		fois =1;
		for (int i=0; i<listejoueur.get(cont.getChoixCible()).getGuidePossede().size(); i++){
			if (listejoueur.get(cont.getChoixCible()).getGuidePossede().get(i).getOrigineCarte()==1 || listejoueur.get(cont.getChoixCible()).getGuidePossede().get(i).getOrigineCarte()==2 && fois==1){
				for (int k=0; k<listejoueur.get(cont.getChoixCible()).getGuidePossede().get(i).getCroyantPossede().size();k++){
					table.add(listejoueur.get(cont.getChoixCible()).getGuidePossede().get(i).getCroyantPossede().get(k));
					cont.setTable(table);
					listejoueur.get(cont.getChoixCible()).getGuidePossede().get(i).getCroyantPossede().remove(k);
					// On met à jour son nombre de croyant
					listejoueur.get(cont.getChoixCible()).getNombreCroyantTotal();
					fois++;
				}
			}
		}
		System.out.println("Effet : Le " +listejoueur.get(cont.getChoixCible()).getNom() + " perd un Guide Spirituel d'Origine Jour ou Neant");
	
	
	
		}
}
		else if (tourjoueur.get(j) != listejoueur.get(0)){ // Si c'est la machine qui joue
			
			 min = tourjoueur.get(j).getNombreCroyantTotal();
				joueurChoisi = cible;	
				for (int a=0; a<listejoueur.size();a++){
						if (min> listejoueur.get(a).getNombreCroyantTotal() && (listejoueur.get(a) != tourjoueur.get(j) )){
							min = listejoueur.get(a).getNombreCroyantTotal();
							joueurChoisi=a ;
					}
				}
				
				fois =1;
				for (int i=0; i<listejoueur.get(joueurChoisi).getGuidePossede().size(); i++){
					if (listejoueur.get(joueurChoisi).getGuidePossede().get(i).getOrigineCarte()==1 || listejoueur.get(joueurChoisi).getGuidePossede().get(i).getOrigineCarte()==2 && fois==1){
						for (int k=0; k<listejoueur.get(joueurChoisi).getGuidePossede().get(i).getCroyantPossede().size();k++){
							table.add(listejoueur.get(joueurChoisi).getGuidePossede().get(i).getCroyantPossede().get(k));
							cont.setTable(table);	
							listejoueur.get(joueurChoisi).getGuidePossede().get(i).getCroyantPossede().remove(k);
							// On met à jour son nombre de croyant
							listejoueur.get(joueurChoisi).getNombreCroyantTotal();
							
								for (int z=0;z<listejoueur.size();z++){
									cont.setNombrePriere(z+listejoueur.get(0).getDecalage(),listejoueur.get(z).getNombreCroyantTotal());
								 
							}
							
							fois++;
						}
					}
				}
				System.out.println("Effet : Le " +listejoueur.get(joueurChoisi).getNom() + " perd un Guide Spirituel d'Origine Jour ou Neant");
		}
	}
	
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection,
			ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
		// TODO Auto-generated method stub
		
	}
	
}
