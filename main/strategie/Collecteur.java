package main.strategie;
import java.util.*;

import main.strategie.Strategie;

import main.principal.*;
import main.carte.*;

/**
 * <b>Collecteur est la classe représentant la stratégie de type Collecteur.</b>
 */
public class Collecteur implements Strategie{
	
	protected int carteChoisie;

	/**
	 * Définit le déroulement de la stratégie :
	 *  - Je défausse toutes les cartes Deus Ex que j'ai.
	 *  - S'il y a des croyants récupérables, je pose les guides pour les récuperer. 
	 *  - Sinon, je pose mes croyants sur la table.
	 *  - Si je suis celui qui a le plus de croyant , et que j'ai une carte apocalypse, je l'utilise.
	 *  - Sinon j'utilise une carte Deus Ex au hasard, pour m'en débarasser.
     *  - Si mes points d'action sont bas, je passe mon tour.
		
	 */
	
	public void lol(){
		System.out.println("lol");
	}
	public int choisirCarte(ArrayList<Joueur> joueur, int j, ArrayList<Carte> collectionCarte, ArrayList<Carte> table){
		this.carteChoisie=99;
		
		
		for ( int k=0; k <joueur.get(j).getMain().size();k++ ){ 
			if ( joueur.get(j).getMain().get(k).getIdentifiantCarte() >=58 && joueur.get(j).getMain().get(k).getIdentifiantCarte()<=75){
				System.out.println("Le joueur " +joueur.get(j).getNom()+ " a défaussé la carte : " +joueur.get(j).getMain().get(k).getIdentifiantCarte());
				joueur.get(j).defausserCarte(k, collectionCarte);
				
			}
		}

		if (this.carteChoisie==99){
		for ( int k=0; k<table.size();k++){ 
			for ( int a=0; a<joueur.get(j).getMain().size();a++){
				if ( joueur.get(j).getMain().get(a).getIdentifiantCarte() >=38 && joueur.get(j).getMain().get(a).getIdentifiantCarte() <=57 ){
					if (joueur.get(j).getMain().get(a).getNatureCarte2() == table.get(k).getNatureCarte1() || joueur.get(j).getMain().get(a).getNatureCarte3() == table.get(k).getNatureCarte1()){
						if (joueur.get(j).getPtsAction(joueur.get(j).getMain().get(a).getOrigineCarte()) !=0){ 
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
						
						
					}
					else if (joueur.get(j).getMain().get(a).getNatureCarte2() == table.get(k).getNatureCarte2() || joueur.get(j).getMain().get(a).getNatureCarte3() == table.get(k).getNatureCarte2()){
						if (joueur.get(j).getPtsAction(joueur.get(j).getMain().get(a).getOrigineCarte()) !=0){ 
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
						}
					else if (joueur.get(j).getMain().get(a).getNatureCarte2() == table.get(k).getNatureCarte3() || joueur.get(j).getMain().get(a).getNatureCarte3() == table.get(k).getNatureCarte3()){
						if (joueur.get(j).getPtsAction(joueur.get(j).getMain().get(a).getOrigineCarte()) !=0){ 
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
				
			}
		}
		}
		
		
		if (this.carteChoisie ==99){
		for ( int k=0; k<joueur.get(j).getMain().size();k++){
			if ( joueur.get(j).getMain().get(k).getIdentifiantCarte() >= 76 && joueur.get(j).getMain().get(k).getIdentifiantCarte() <=80){
				int max = joueur.get(j).getNombreCroyantTotal();
				for (int a=0; a<joueur.size(); a++){
					if ( max < joueur.get(a).getNombreCroyantTotal()){
						max = joueur.get(a).getNombreCroyantTotal();
					}
				}
				
				if ( max == joueur.get(j).getNombreCroyantTotal()){ 
					if ( joueur.get(j).getMain().get(k).getOrigineCarte()==0){
					joueur.get(j).setPoserCarte(true);
					this.carteChoisie = k;
					}
					else if ( joueur.get(j).getPtsAction(joueur.get(j).getMain().get(k).getOrigineCarte()) !=0){
					joueur.get(j).setPointAction(joueur.get(j).getMain().get(k).getOrigineCarte(), -1);
					joueur.get(j).setPoserCarte(true);
					this.carteChoisie = k;
					}
					else if ( joueur.get(j).getPtsAction(joueur.get(j).getMain().get(k).getOrigineCarte()) ==3){
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
			else{
			}
			
		}
		}
		
		if (this.carteChoisie==99){
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
		

		if (this.carteChoisie == 99 && joueur.get(j).getUtiliserDivinite()==false){
			
			double nombreAleatoire = Math.round(Math.random()*5);
			if ( nombreAleatoire>=0 && nombreAleatoire<=(1/5)){
				joueur.get(j).setUtiliserDivinite(0);
			this.carteChoisie=100;
			}
		}

		if (this.carteChoisie==99){
			joueur.get(j).setPasserTour(0); 
		}	
		
		
		return this.carteChoisie;
}
	
}
