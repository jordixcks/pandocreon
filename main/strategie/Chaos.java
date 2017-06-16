package main.strategie;

import java.util.ArrayList;
import main.carte.*;
import main.principal.*;

import main.strategie.Strategie;

import java.util.*;

/**
 * <b>Chaos est la classe représentant la stratégie de type Chaos.</b>
 */
public class Chaos implements Strategie{

	protected int carteChoisie;
	
	/**
	 * Définit le déroulement de la stratégie :
	 *  - Si j'ai plus d'une carte apocalypse, j'en défausse n-1.
	 *  - S'il y a des croyants récupérable, je pose les guides pour les récuperer.
	 *  - Sinon je pose les croyants.
	 *  - Si je suis celui qui a le plus de croyant, et que j'ai une carte apocalypse, je l'utilise.
	 *  - Si je suis celui qui a le plus de croyants sans apocalypse, ou celui qui n'en a pas le moins, je regarde mes croyants et j'en sacrifie jusqu'à ce que mon nombre de croyants soit juste au dessus de l'avant dernier joueur.
	 *  - Si un guide n'a qu'un croyant, je le sacrifie, pour les effets, je sélectionne le joueur qui a le plus de croyants.
	 *  - Si je suis celui qui a le moins de croyant, j'utilise les cartes Deus Ex sur le joueur qui en a le moins avant moi.
	 *  - Si mes points d'action sont bas, je passe mon tour.
	 */
	public int choisirCarte(ArrayList<Joueur> joueur, int j, ArrayList<Carte> collectionCarte, ArrayList<Carte> table){
		this.carteChoisie=99;
		
		int i =0;
		for ( int k=0; k<joueur.get(j).getMain().size();k++){
			if (joueur.get(j).getMain().get(k).getIdentifiantCarte()>=76 && joueur.get(j).getMain().get(k).getIdentifiantCarte()<=80 ){
				i++;
			}
		}
		
			for ( int k=0; k<joueur.get(j).getMain().size();k++){
				if (joueur.get(j).getMain().get(k).getIdentifiantCarte()>=76 && joueur.get(j).getMain().get(k).getIdentifiantCarte()<=80 && i>1){
					System.out.println("Le joueur " +joueur.get(j).getNom()+ " a défaussé la carte : " +joueur.get(j).getMain().get(k).getIdentifiantCarte());
					joueur.get(j).defausserCarte(k,collectionCarte);
					i--;
					
				}
			}

			if (this.carteChoisie ==99){
			for ( int k=0; k<table.size();k++){ 
				for ( int a=0; a<joueur.get(j).getMain().size();a++){
					if ( joueur.get(j).getMain().get(a).getIdentifiantCarte() >=38 && joueur.get(j).getMain().get(a).getIdentifiantCarte() <=57 ){
						if (joueur.get(j).getMain().get(a).getNatureCarte2() == table.get(k).getNatureCarte1() || joueur.get(j).getMain().get(a).getNatureCarte3() == table.get(k).getNatureCarte1()){
							if (joueur.get(j).getPtsAction(joueur.get(j).getMain().get(a).getOrigineCarte()) !=0){ // On regarde si on a assez de points d'action de l'origine de la carte
								joueur.get(j).setPointAction(joueur.get(j).getMain().get(a).getOrigineCarte(), -1);
								joueur.get(j).setPoserCarte(true);
								this.carteChoisie = a;
								
							}
							else if (joueur.get(j).getMain().get(a).getOrigineCarte() ==2){
								if ( joueur.get(j).getPtsAction(1)>=2){
									joueur.get(j).setPointAction(1, -2);
									joueur.get(j).setPoserCarte(true);
									this.carteChoisie = a;
								}
								else if (joueur.get(j).getPtsAction(3)>=2){
									joueur.get(j).setPointAction(3, -2);
									joueur.get(j).setPoserCarte(true);
									this.carteChoisie = a;
								}
								else{
								}
							}
							else{
							}
							
							
						}
						else if (joueur.get(j).getMain().get(a).getNatureCarte2() == table.get(k).getNatureCarte2() || joueur.get(j).getMain().get(a).getNatureCarte3() == table.get(k).getNatureCarte2()){
							if (joueur.get(j).getPtsAction(joueur.get(j).getMain().get(a).getOrigineCarte()) !=0){ // On regarde si on a assez de points d'action de l'origine de la carte
								joueur.get(j).setPointAction(joueur.get(j).getMain().get(a).getOrigineCarte(), -1);
								joueur.get(j).setPoserCarte(true);
								this.carteChoisie = a;
								}
								else if (joueur.get(j).getMain().get(a).getOrigineCarte() ==2){
									if ( joueur.get(j).getPtsAction(1)>=2){
										joueur.get(j).setPointAction(1, -2);
										joueur.get(j).setPoserCarte(true);
										this.carteChoisie = a;
									}
									else if (joueur.get(j).getPtsAction(3)>=2){
										joueur.get(j).setPointAction(3, -2);
										joueur.get(j).setPoserCarte(true);
										this.carteChoisie = a;
									}
									else{
									}
								}
								else{
								}
							}
						else if (joueur.get(j).getMain().get(a).getNatureCarte2() == table.get(k).getNatureCarte3() || joueur.get(j).getMain().get(a).getNatureCarte3() == table.get(k).getNatureCarte3()){
							if (joueur.get(j).getPtsAction(joueur.get(j).getMain().get(a).getOrigineCarte()) !=0){ // On regarde si on a assez de points d'action de l'origine de la carte
								joueur.get(j).setPointAction(joueur.get(j).getMain().get(a).getOrigineCarte(), -1);
								joueur.get(j).setPoserCarte(true);
								this.carteChoisie = a;
								}
								else if (joueur.get(j).getMain().get(a).getOrigineCarte() ==2){
									if ( joueur.get(j).getPtsAction(1)>=2){
										joueur.get(j).setPointAction(1, -2);
										joueur.get(j).setPoserCarte(true);
										this.carteChoisie = a;
									}
									else if (joueur.get(j).getPtsAction(3)>=2){
										joueur.get(j).setPointAction(3, -2);
										joueur.get(j).setPoserCarte(true);
										this.carteChoisie = a;
									}
									else{
									}
								}
								else{
								}
							}
						else {
							}
						}
						
					}	
				}
			}
			
			if (this.carteChoisie==99){
			for (int k=0; k<joueur.get(j).getMain().size() ; k++){
				if ( joueur.get(j).getMain().get(k).getIdentifiantCarte() >=1 && joueur.get(j).getMain().get(k).getIdentifiantCarte() <=37){
					if (joueur.get(j).getPtsAction(joueur.get(j).getMain().get(k).getOrigineCarte()) != 0){ 
						joueur.get(j).setPointAction(joueur.get(j).getMain().get(k).getOrigineCarte(), -1);
						joueur.get(j).setPoserCarte(true);
						this.carteChoisie = k;
					}
					else if (joueur.get(j).getMain().get(k).getOrigineCarte() ==2){
						if ( joueur.get(j).getPtsAction(1)>=2){
							joueur.get(j).setPointAction(1, -2);
							joueur.get(j).setPoserCarte(true);
							this.carteChoisie = k;
						}
						else if (joueur.get(j).getPtsAction(3)>=2){
							joueur.get(j).setPointAction(3, -2);
							joueur.get(j).setPoserCarte(true);
							this.carteChoisie = k;
						}
						else{
						}
					}
					else{
					}
					
				}  
			}
		
			}

		if (this.carteChoisie==99){
			for (int k=0; k<joueur.get(j).getMain().size();k++){
			if ( joueur.get(j).getMain().get(k).getIdentifiantCarte() >=76 && joueur.get(j).getMain().get(k).getIdentifiantCarte() <=80 ){
				int min = joueur.get(j).getNombreCroyantTotal();
				for (int a=0; a<joueur.size();a++){
					if (min > joueur.get(a).getNombreCroyantTotal()){
						min = joueur.get(a).getNombreCroyantTotal();
					}
				}
				
				if ( min != joueur.get(j).getNombreCroyantTotal()){  
					if ( joueur.get(j).getMain().get(k).getOrigineCarte()==0){
						joueur.get(j).setPoserCarte(true);
						this.carteChoisie = k;
					}
					else if ( joueur.get(j).getPtsAction(joueur.get(j).getMain().get(k).getOrigineCarte()) !=0){
						joueur.get(j).setPointAction(joueur.get(j).getMain().get(k).getOrigineCarte(), -1);
						joueur.get(j).setPoserCarte(true);
						this.carteChoisie = k;
					}
					else if ( joueur.get(j).getPtsAction(joueur.get(j).getMain().get(k).getOrigineCarte()) ==2){
							if ( joueur.get(j).getPtsAction(1)>=2){
								joueur.get(j).setPointAction(1, -2);
								joueur.get(j).setPoserCarte(true);
								this.carteChoisie = k;
							}
							else if (joueur.get(j).getPtsAction(3)>=2){
								joueur.get(j).setPointAction(3, -2);
								joueur.get(j).setPoserCarte(true);
								this.carteChoisie = k;
							}
							else{
							    }
					}
					else{
					}
				
						}
			
					}
			}
		}
		
		if (this.carteChoisie ==99){
		if (joueur.get(j).getNombreCroyantTotal() != 0){
			int min = joueur.get(j).getNombreCroyantTotal()-2;
				for (int a=0; a<joueur.size(); a++){
					if (min > joueur.get(a).getNombreCroyantTotal()){
						min = joueur.get(a).getNombreCroyantTotal();
					}
				}
		
				if ( min != joueur.get(j).getNombreCroyantTotal()){ 
					for(int b=0; b<joueur.get(j).getGuidePossede().size();b++){
					if (joueur.get(j).getStopSacrificeGuide()==false){
						
						
						if (joueur.get(j).getGuidePossede().get(b).getCroyantPossede().size() == 1){
						joueur.get(j).setSacrifierGuide(true);
						this.carteChoisie = b;				
						}
						
					}
					else if (joueur.get(j).getGuidePossede().get(b).getCroyantPossede().size() >1){
						if (joueur.get(j).isStopSacrificeCroyant()==false || joueur.get(j).isBlocageSacrificeCroyantTour()==false){
						joueur.get(j).setSacrifierCroyant(true);
						this.carteChoisie = 0;
					}
					}
				}
			}
		
	}
		
		}

		if (this.carteChoisie ==99){
		int min = joueur.get(j).getNombreCroyantTotal();
		for (int a=0; a<joueur.size();a++){
			if (min > joueur.get(a).getNombreCroyantTotal()){
				min = joueur.get(a).getNombreCroyantTotal();
			}
		}
		
		if (min == joueur.get(j).getNombreCroyantTotal()){
			for ( int k=0 ; k<joueur.get(j).getMain().size();k++){
				if ( joueur.get(j).getMain().get(k).getIdentifiantCarte() >=58 && joueur.get(j).getMain().get(k).getIdentifiantCarte() <=75){
					if ( joueur.get(j).getMain().get(k).getOrigineCarte()==0){
						joueur.get(j).setPoserCarte(true);
						this.carteChoisie = k;
						}
						else if ( joueur.get(j).getPtsAction(joueur.get(j).getMain().get(k).getOrigineCarte()) !=0){
							joueur.get(j).setPointAction(joueur.get(j).getMain().get(k).getOrigineCarte(), -1);
						joueur.get(j).setPoserCarte(true);
						this.carteChoisie = k;
						}
						else if ( joueur.get(j).getPtsAction(joueur.get(j).getMain().get(k).getOrigineCarte()) ==2){
							if ( joueur.get(j).getPtsAction(1)>=2){
								joueur.get(j).setPointAction(1, -2);
								joueur.get(j).setPoserCarte(true);
								this.carteChoisie = k;
							}
							else if (joueur.get(j).getPtsAction(3)>=2){
								joueur.get(j).setPointAction(3, -2);
								joueur.get(j).setPoserCarte(true);
								this.carteChoisie = k;
							}
							else{
							}
						}
					}
				}
		}
		}
		
		if (this.carteChoisie ==99 && joueur.get(j).getUtiliserDivinite()==false){
			double nombreAleatoire = Math.round(Math.random()*5);
			if ( nombreAleatoire>=0 && nombreAleatoire<=(1/5)){
				joueur.get(j).setUtiliserDivinite(0);
			this.carteChoisie=100; 
			}

		}
		
		if (this.carteChoisie ==99){
			joueur.get(j).setPasserTour(0); 
			
		}
		
		return this.carteChoisie;
		}
}
