
package main.principal;

import java.util.ArrayList;
import main.carte.*;
import main.principal.Joueur;
import java.util.Scanner;

import main.strategie.Strategie;

/**
 * <b>Joueur est la classe repr�sentant un joueur de la partie.</b>
 * <p>Un joueur est caract�ris� par :
 * <ul>
 * <li>Son nom</li>
 * <li>Sa divinit�</li>
 * <li>Son nombre de Croyants</li>
 * <li>Les Guides qu'il poss�de sur le plateau</li>
 * <li>Les Croyants qu'il poss�de sur le plateau</li>
 * <li>Les cartes Action dans sa main</li>
 * </ul>
 *</p>
 */
public class Joueur {
	/**
	 * Le nom du joueur.
	 */
	protected String nom;
	/**
	 * Nombre de Croyants total que ce joueur poss�de.
	 */
	protected int nombreCroyantTotal;
	/**
	 * Nombre de Guides que ce joueur poss�de.
	 */
	protected int nombreGuide;
	
	protected int carteChoisie, joueurCible;
	
	/**
	 * Le nombre de points d'action du joueur selon l'origine des points.
	 * <p>1 : jour , 2 : n�ant , 3 : nuit</p>
	 */
	protected int[] nombrePointAction = new int [4];
	/**
	 * Collection de carte que ce joueur poss�de dans sa main.
	 */
	protected ArrayList<Carte> main; 
	/**
	 * Liste des Guides du joueur sur le plateau
	 */
	protected ArrayList<Carte> guidePossede;
	/**
	 * Liste des Croyants du joueur sur le plateau
	 */
	protected ArrayList<Carte> croyantPossede;
	/**
	 * La Divinit� du joueur.
	 */
	protected Carte Divinite;
	/**
	 * L'origine du d� lorsque ce joueur lance le d�.
	 */
	private double resultatDes;
	/**
	 *  Les cartes choisies lors d'un d�faussage
	 */
	protected int choixDefaussage [] ={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	
	/**
	 * Indique si ce joueur peut ou non poser une carte Apocalypse.
	 * <p>Cet �tat dure un tour, il est r�tabli � false � la fin du tour.</p>
	 */
	private boolean stopApocalypse = false;
	/**
	 * Indique si ce joueur peut ou non poser une carte Guide Spirituel.
	 * <p>Cet �tat dure un tour, il est r�tabli � false � la fin du tour.</p>
	 */
	private boolean stopSacrificeGuide = false;
	/**
	 * Indique si ce joueur peut ou non poser une carte Croyant.
	 * <p>Cet �tat dure un tour, il est r�tabli � false � la fin du tour.</p>
	 */
	private boolean stopSacrificeCroyant = false;
	/**
	 * Indique si ce joueur peut ou non gagner des points Action.
	 * <p>Cet �tat dure un tour, il est r�tabli � false � la fin du tour.</p>
	 */
	private boolean stopPointAction = false; 
	
	/**
	 * Indique si ce joueur est oblig� de sacrifier un de ses Croyants.
	 */ 
	private boolean doitSacrifierCroyant = false;
	/**
	 * Indique si ce joueur est oblig� de sacrifier un de ses Guides.
	 */
	private boolean doitSacrifierGuide = false;
	/**
	 * Indique si ce joueur est oblig� de poser un de ses cartes Apocalypses.
	 */
	private boolean doitPoserApocalypse = false;
	/**
	 * Indique si ce joueur sera bloqu� au moment o� il veut poser une carte Apocalypse.
	 */
	private boolean blocageApocalypse = false;
	/**
	 * Indique si ce joueur sera bloqu� au moment o� il veut sacrifier un de ses Guides.
	 */
	protected boolean blocageSacrificeGuide = false;
	/**
	 * Indique si ce joueur sera bloqu� au moment o� il veut poser une carte Guide Spirituel.
	 */
	private boolean blocagePoserGuide = false;
	/**
	 * Indique si ce joueur sera bloqu� au moment o� il veut sacrifier un de ses Croyants.
	 */
	private boolean blocageSacrificeCroyantTour = false;
	/**
	 * Indique si ce joueur sera victime de son effet qu'il veut jouer.
	 */
	private boolean effetMiroir = false;
	
	/**
	 * Indique que ce joueur veut poser une carte.
	 */
	private boolean poserCarte = false ;
	/**
	 * Indique que ce joueur veut sacrifier un Croyant.
	 */
	private boolean sacrifierCroyant = false;
	/**
	 * Indique que ce joueur veut sacrifier un Guide.
	 */
	private boolean sacrifierGuide = false;
	/**
	 * Indique que ce joueur veut utiliser sa Divinit�.
	 */
	protected boolean utiliserDivinite = false;
	/**
	 * Indique que ce joueur veut passer son tour.
	 */
	protected boolean passerTour = false;
	/**
	 * Indique que ce joueur veut utiliser l'effet de sa Divinit�.
	 */
	protected boolean effetDivinite = false;
	/**
	 * Indique que le joueur a termin� sa partie.
	 */
	protected boolean partieTerminee =false;
	
	private int decalage = 0; // Sert � attribuer les bon points aux bonnes personnes
	private int pointDecalage =0;
	
	protected Controller cont;

	/**
	 * Instance d'une strat�gie de comportement.
	 */
	protected Strategie strategie;
	private int rep1;
	private int rep2;
	
	
	/**
	 * Constructeur Joueur.
	 */
	public Joueur(){
		nom = "Joueur";
		nombreCroyantTotal = 0; 
		nombreGuide = 0;
		nombrePointAction[1]=0;
		nombrePointAction[2]=0;
		nombrePointAction[3]=0;
		main = new ArrayList<Carte>();
		guidePossede = new ArrayList<Carte>();
		croyantPossede = new ArrayList<Carte>();
	}

	/**
	 * Constructeur Joueur
	 * @param strategie
	 * 			Le comportement que le joueur IA va adopter.
	 */
	public Joueur( Strategie strategie){
		this.strategie = strategie;
	}

	/**
	 * Red�finit le comportement de ce joueur.
	 * @param strategie
	 * 			Le comportement que le joueur IA va adopter.
	 */
	public void setStrategie( Strategie strategie){
		this.strategie = strategie;
	}
	
	/**
	 * D�fausse une carte poss�d�e par ce joueur.
	 * <p>La carte est retir�e de sa main et est ajout�e au deck.
	 * </p>
	 * @param indice
	 * 			La position de la carte � d�fausser dans la main du joueur
	 * @param deck
	 * 		Le deck de cartes
	 */
	public void defausserCarte( int indice , ArrayList<Carte> deck){
		deck.add(this.getMain().get(indice));  
		this.getMain().remove(indice);
	}
	
	/**
	 * Lance le d� de Cosmogonie
	 * <p>Attribue aux joueurs des points d'action en fonction du r�sultat du lanc� de d�.
	 * </p>
	 * @param listejoueur
	 * 			La liste des joueurs de la partie
	 */
	public void lancerDe( ArrayList <Joueur> listejoueur){ 
		double resultatDe = Math.round(Math.random()*3);
		this.setResultatDes(resultatDe);
		for (int i=0; i<listejoueur.size(); i++){
		if (listejoueur.get(i).stopPointAction==false){
			if ( resultatDe >= 0 && resultatDe <1){ 
				//cont.setResultatDe(1);	
					if ( listejoueur.get(i).getDivinite().getOrigineCarte() == 1){  
						listejoueur.get(i).setPointAction(1,2); 
					
					}
					if ( listejoueur.get(i).getDivinite().getOrigineCarte() == 4){
						listejoueur.get(i).setPointAction(1,1);
					}	
				}	
			else if ( resultatDe >=1 && resultatDe <2){ 
				//cont.setResultatDe(2);
					if (listejoueur.get(i).getDivinite().getOrigineCarte() == 3){
						listejoueur.get(i).setPointAction(3,2);
					}
					if (listejoueur.get(i).getDivinite().getOrigineCarte() == 5){
						listejoueur.get(i).setPointAction(3,1);
					}
			}
			else {
		
				if ( listejoueur.get(i).getDivinite().getOrigineCarte()==4 || listejoueur.get(i).getDivinite().getOrigineCarte()==5){
				listejoueur.get(i).setPointAction(2,1);
				}
			}
			
			listejoueur.get(i).setResultatDes(resultatDe);
			}
		
		else{
			System.out.println("Effet : Le joueur " +i+ " ne peut pas recevoir de points d'action ce tour");
			listejoueur.get(i).stopPointAction=false;
		}
	}
		
	}
	/**
	 * Permet au joueur (IA) de poser une carte.
	 * 
	 * @param id
	 * 			L'ID de la carte choisie.
	 * @param table
	 * 			Collection de cartes situ�es au centre de la table de jeu.
	 * @param listejoueur
	 * 			La liste des joueurs de la partie.
	 * @param collection
	 * 			Le deck de cartes.
	 * @param tourJoueur
	 * 			La liste des joueurs selon l'ordre de jeu.
	 * @param j
	 * 			La joueur qui pose la carte
	 * @param cible
	 * 			Le joueur contre qui l'effet de la carte sera jou�.
	 */
	public void poserCarteIA(int id , ArrayList<Carte> table, ArrayList<Joueur> listejoueur, ArrayList<Carte> collection, ArrayList<Joueur> tourJoueur, int j, int cible){

		if (isPoserCarte() ==true){
			if ((this.main.get(id).getIdentifiantCarte() >=1) && (this.main.get(id).getIdentifiantCarte()<=37)){
			table.add(this.main.get(id));
			System.out.println("Le joueur " +this.getNom()+ " a pos� un croyant " +this.main.get(id).getIdentifiantCarte());
			this.main.remove(id);
			}
			else if ((this.main.get(id).getIdentifiantCarte()>=38) && (this.main.get(id).getIdentifiantCarte()<=57)){
			this.guidePossede.add(this.main.get(id));
			int i =0;
			while ((i< (((Guide)this.guidePossede.get(this.guidePossede.size()-1)).getCroyantRecuperable())) && (i<table.size())){
				if ((table.get(i).getNatureCarte1() == this.main.get(id).getNatureCarte2()) || (table.get(i).getNatureCarte1() == this.main.get(id).getNatureCarte3())){
						this.guidePossede.get(this.guidePossede.size()-1).croyantPossede.add(table.get(i));
						int nbreCroyant;
						nbreCroyant = ((Guide)this.guidePossede.get(this.guidePossede.size()-1)).getNombreCroyant();
						nbreCroyant = nbreCroyant + ((Croyant)table.get(i)).getCroyantDisponible();
						((Guide)this.guidePossede.get(this.guidePossede.size()-1)).setNombreCroyant(nbreCroyant);
						table.remove(i);
						i++;
						
				}
				else if ((table.get(i).getNatureCarte2() == this.main.get(id).getNatureCarte2()) || (table.get(i).getNatureCarte2() == this.main.get(id).getNatureCarte3())){
					this.guidePossede.get(this.guidePossede.size()-1).croyantPossede.add(table.get(i)); 
					int nbreCroyant;
					nbreCroyant = ((Guide)this.guidePossede.get(this.guidePossede.size()-1)).getNombreCroyant();
					nbreCroyant = nbreCroyant + ((Croyant)table.get(i)).getCroyantDisponible();
					((Guide)this.guidePossede.get(this.guidePossede.size()-1)).setNombreCroyant(nbreCroyant);
					table.remove(i);
					i++;
					
				}
				else if ((table.get(i).getNatureCarte3() == this.main.get(id).getNatureCarte2()) || (table.get(i).getNatureCarte3() == this.main.get(id).getNatureCarte3())){
					this.guidePossede.get(this.guidePossede.size()-1).croyantPossede.add(table.get(i)); 
					int nbreCroyant;
					nbreCroyant = ((Guide)this.guidePossede.get(this.guidePossede.size()-1)).getNombreCroyant();
					nbreCroyant = nbreCroyant + ((Croyant)table.get(i)).getCroyantDisponible();
					((Guide)this.guidePossede.get(this.guidePossede.size()-1)).setNombreCroyant(nbreCroyant);
					table.remove(i);
					i++;
					
				}	
				else{
					i++;
				}
		}
			System.out.println("Le joueur " +this.getNom()+ " a pos� un guide "+this.main.get(id).getIdentifiantCarte());
			this.defausserCarte(id, collection);
	}
		else if ((this.main.get(id).getIdentifiantCarte()>=58) && (this.main.get(id).getIdentifiantCarte()<=75)){
			System.out.println("Le joueur "+this.getNom()+ " a pos� un Deus ex " +this.main.get(id).getIdentifiantCarte());

			if ( this.main.get(id).isEffetAnnule()!=true){
			this.main.get(id).getEffet().utiliserEffet(listejoueur,0, table, this.main.get(id), j, collection, tourJoueur);
			}
			else{
				System.out.println("Effet : L'effet de cette carte a �t� annul�");
				this.main.get(id).setEffetAnnule(false);
			}
			this.defausserCarte(id, collection);
		}
		else{ 
			if (this.blocageApocalypse==true){
				System.out.println("Carte Apocalypse annul�e");
				this.defausserCarte(id, collection);
			for (int i=0; i<listejoueur.size();i++){
				listejoueur.get(i).blocageApocalypse=false;
				}
			}
			else if (this.blocageApocalypse==false){
				this.main.get(id).getEffet().utiliserEffet(listejoueur,0, table, this.main.get(id), j, collection, tourJoueur);
			System.out.println("Le joueur "+this.getNom()+ " a pos� une carte apocalypse " +this.main.get(id).getIdentifiantCarte());
			this.defausserCarte(id, collection);
			}
			
		}
		
		
		this.setPoserCarte(false);
	}
		
	if ( this.isSacrifierCroyant()==true || this.isSacrifierGuide() == true){ 
			int min = this.nombreCroyantTotal-2;
				for (int a=0; a<listejoueur.size();a++){
					if (min> listejoueur.get(a).nombreCroyantTotal){
						min = listejoueur.get(a).nombreCroyantTotal;
						this.joueurCible =a ;
				}
					
			}
		if (this.isSacrifierCroyant()==true){ 
			for (int b=0; b<this.guidePossede.size();b++){
				if(this.guidePossede.get(b).croyantPossede.size() > 1){
					this.sacrifierCarte(collection, carteChoisie, carteChoisie, j, listejoueur, cible, table, tourJoueur);
					System.out.println("Le joueur " +this.getNom()+ " a sacrifi� un Croyant" +this.main.get(id).getIdentifiantCarte());
					break;
				
				}
			}
		this.setSacrifierCroyant(false);	
		}
		
		if (this.isSacrifierGuide() == true){
			this.sacrifierCarte(collection,carteChoisie,carteChoisie,j,listejoueur,cible, table,tourJoueur);
			System.out.println("Le joueur " +this.getNom()+ " a sacrifi� un Guide " +this.main.get(id).getIdentifiantCarte());
			this.setSacrifierGuide(false);
			}
		}
	
	if (this.utiliserDivinite == true && id==100){
		this.getDivinite().getEffet().utiliserEffetDivinite(listejoueur, j, collection, table, cible, tourJoueur);
		System.out.println("Le joueur " +this.getNom()+ " a utilis� effet Divinit�");
	}
	
	if (this.passerTour == true && id==99){
		System.out.println("Le joueur " +this.getNom()+ " a pass� son tour");
		this.passerTour = false;
	}
	
}

	/**
	 * Permet au joueur de poser une carte.
	 * 
	 * @param id
	 * 			L'ID de la carte choisie.
	 * @param table
	 * 			Collection de cartes situ�es au centre de la table de jeu.
	 * @param listejoueur
	 * 			La liste des joueurs de la partie.
	 * @param collection
	 * 			Le deck de cartes.
	 * @param tourJoueur
	 * 			La liste des joueurs selon l'ordre de jeu.
	 * @param j
	 * 			La joueur qui pose la carte
	 * @param cible
	 * 			Le joueur contre qui l'effet de la carte sera jou�.
	 */
	public void poserCarte( int id, ArrayList<Carte> table , ArrayList<Carte> collection, ArrayList<Joueur> listejoueur, ArrayList<Joueur> tourjoueur , int j, int cible){
		if (( this.main.get(id).getIdentifiantCarte() >=1) && (this.main.get(id).getIdentifiantCarte() <=37)){
			table.add(this.main.get(id));
			this.main.remove(id);	
		}
		else if (( this.main.get(id).getIdentifiantCarte() >=38) && (this.main.get(id).getIdentifiantCarte() <=57)){
			this.guidePossede.add(this.main.get(id));
			int i =0;
			
			while ((i < (((Guide)this.guidePossede.get(this.guidePossede.size()-1)).getCroyantRecuperable())) && (i<table.size())){
				if ((table.get(i).getNatureCarte1() == this.main.get(id).getNatureCarte2()) || (table.get(i).getNatureCarte1() == this.main.get(id).getNatureCarte3())){
					this.guidePossede.get(this.guidePossede.size()-1).croyantPossede.add(table.get(i)); 
					int nbreCroyant;
					nbreCroyant = ((Guide)this.guidePossede.get(this.guidePossede.size()-1)).getNombreCroyant();
					nbreCroyant = nbreCroyant + ((Croyant)table.get(i)).getCroyantDisponible();
					((Guide)this.guidePossede.get(this.guidePossede.size()-1)).setNombreCroyant(nbreCroyant);
					table.remove(i);
					i++;

				}
				else if ((table.get(i).getNatureCarte2() == this.main.get(id).getNatureCarte2()) || (table.get(i).getNatureCarte2() == this.main.get(id).getNatureCarte3())){
					this.guidePossede.get(this.guidePossede.size()-1).croyantPossede.add(table.get(i)); 
					int nbreCroyant;
					nbreCroyant = ((Guide)this.guidePossede.get(this.guidePossede.size()-1)).getNombreCroyant();
					nbreCroyant = nbreCroyant + ((Croyant)table.get(i)).getCroyantDisponible();
					((Guide)this.guidePossede.get(this.guidePossede.size()-1)).setNombreCroyant(nbreCroyant);
					table.remove(i);
					i++;
				}
				else if ((table.get(i).getNatureCarte3() == this.main.get(id).getNatureCarte2()) || (table.get(i).getNatureCarte3() == this.main.get(id).getNatureCarte3())){
					this.guidePossede.get(this.guidePossede.size()-1).croyantPossede.add(table.get(i)); 
					int nbreCroyant;
					nbreCroyant = ((Guide)this.guidePossede.get(this.guidePossede.size()-1)).getNombreCroyant();
					nbreCroyant = nbreCroyant + ((Croyant)table.get(i)).getCroyantDisponible();
					((Guide)this.guidePossede.get(this.guidePossede.size()-1)).setNombreCroyant(nbreCroyant);
					table.remove(i);
					i++;
				}
				else{
					System.out.println("Il n'y a pas de croyants compatibles");
					i++;
				}
					
			}
			this.defausserCarte(id, collection);
		}
		else if ((this.main.get(id).getIdentifiantCarte() >=58) && (this.main.get(id).getIdentifiantCarte()<=75)){ 
		if (this.main.get(id).isEffetAnnule()!=true){	
			this.main.get(id).getEffet().utiliserEffet(listejoueur,0, table, this.main.get(id),0, collection, tourjoueur);
			
		}
		else{
			System.out.println("Effet: L'effet de cette carte a �t� annul�e");
			this.main.get(id).setEffetAnnule(false);
		}
			this.defausserCarte(id, collection); 
		}
		else if ((this.main.get(id).getIdentifiantCarte() >=76) && (this.main.get(id).getIdentifiantCarte()<=80)){ 
			if (this.blocageApocalypse==true){ 
				System.out.println("Vous tentez d'utiliser Apocalypse, mais c'est impossible");
				this.defausserCarte(id, collection);
			for (int i=0; i<listejoueur.size();i++){	
				listejoueur.get(i).blocageApocalypse=false;
			}
			}
			else if (this.blocageApocalypse==false){
				// On a regard� l'origine de la carte dans la m�thode d�marrerPartie
				this.main.get(id).getEffet().utiliserEffet(listejoueur,0,table,this.main.get(id),0,collection,tourjoueur);
				System.out.println("Vous utlisez Apocalypse");
				collection.add(this.main.get(id));
				this.main.remove(id);
				for (int i=0;i<listejoueur.size();i++){
					listejoueur.get(i).blocageApocalypse=false;
				}
				
			}
		}
	
	}
	
	/**
	 * Retourne l'indication blocageApocalypse
	 * @return blocageApocalypse
	 */
	public boolean isBlocageApocalypse() {
		return blocageApocalypse;
	}

	/**
	 * Met � jour l'indication blocageApocalypse
	 * @param blocageApocalypse
	 * 			Indique si ce joueur sera bloqu� au moment o� il veut poser une carte Apocalypse.
	 */
	public void setBlocageApocalypse(boolean blocageApocalypse) {
		this.blocageApocalypse = blocageApocalypse;
	}
	
	/**
	 * Permet au joueur de sacrifier une carte.
	 * @param collection
	 * 			Deck de cartes.
	 * @param reponse2
	 * 			Choix du Croyant.
	 * @param reponse1
	 * 			Choix du Guide.
	 * @param j
	 * 			Le joueur qui sacrifie la carte.
	 * @param listeJoueur
	 * 			La liste des joueurs de la partie.
	 * @param cible
	 * 			Le joueur contre qui l'effet de la carte sera jou�.
	 * @param table
	 * 			Collection des cartes situ�es au centre de la table de jeu.
	 * @param tourjoueur
	 * 			La liste des joueurs selon l'ordre de jeu.
	 */
	public void sacrifierCarte( ArrayList<Carte> collection, int reponse2, int reponse1, int j, ArrayList<Joueur> listeJoueur, int cible, ArrayList<Carte> table, ArrayList<Joueur> tourjoueur ){
		if ( this.isSacrifierGuide() == true){ 
			
			if (this.getStopSacrificeGuide() ==false){
			for (int i=0; i<this.guidePossede.get(reponse1).croyantPossede.size();i++){
				table.add(this.guidePossede.get(reponse1).croyantPossede.get(i));
				this.guidePossede.get(reponse1).croyantPossede.remove(i);
				}
			this.getNombreCroyantTotal();
		if ( this.guidePossede.get(reponse1).isEffetAnnule()!=true){	 
			this.guidePossede.get(reponse1).getEffet().utiliserEffet(listeJoueur,cible,table,this.guidePossede.get(reponse1),0,collection,tourjoueur );
		}
		else{
			System.out.println("Effet: L'effet de cette carte a �t� annul�");
			this.guidePossede.get(reponse1).setEffetAnnule(false);
		}
			collection.add(this.guidePossede.get(reponse1));
			this.guidePossede.remove(reponse1);
			
			this.setSacrifierGuide(false);
			}
		}
		else{ 
			if (this.isStopSacrificeCroyant()==false){
			
		if (this.guidePossede.get(reponse1).croyantPossede.get(reponse2).isEffetAnnule()!=true){	
			this.guidePossede.get(reponse1).croyantPossede.get(reponse2).getEffet().utiliserEffet(listeJoueur,cible,table,this.guidePossede.get(reponse1).croyantPossede.get(reponse2),0,collection,tourjoueur);
		}
		else{
			System.out.println("Effet: L'effet de la carte a �t� annul�");
			this.guidePossede.get(reponse1).croyantPossede.get(reponse2).setEffetAnnule(false);
		}
			collection.add(this.guidePossede.get(reponse1).croyantPossede.get(reponse2));
			this.guidePossede.get(reponse1).croyantPossede.remove(reponse2);
			
			this.getNombreCroyantTotal();
			this.setSacrifierCroyant(false);
			}
		}

	}
	
	/**
	 * Met � jour le nom de ce joueur.
	 * @param i
	 * 			Indice du joueur
	 * @return Le nom du joueur
	 */
	public String setNom(int i){
		return nom = nom + String.valueOf(i);
	}
	
	/**
	 * Retourne le nom de ce joueur
	 * @return nom
	 */
	public String getNom(){
		return nom;
	}

	/**
	 * Met � jour la Divinit� de ce joueur.
	 * @param pDivinite
	 * 			Divinit� du joueur
	 */
	public void  setDivinite( Carte pDivinite){
		Divinite = pDivinite;
	}
	
	/**
	 * Met � jour le nombre de points Action de ce joueur, selon l'origine des points.
	 * @param indice
	 * 			L'origine des points Action
	 * @param valeur
	 * 			Nombre de points
	 */
	public void setPointAction( int indice , int valeur){
		this.nombrePointAction[indice] = this.nombrePointAction[indice] +valeur;
	}
	
	/**
	 * Retourne le nombre de Croyant total de ce joueur.
	 * @return nombreCroyantTotal
	 */
	public int getNombreCroyantTotal(){
		 nombreCroyantTotal =0;
		for (int i=0; i< this.guidePossede.size();i++){
			for (int j=0; j<this.guidePossede.get(i).croyantPossede.size();j++){
				nombreCroyantTotal = nombreCroyantTotal + ((Croyant)this.guidePossede.get(i).croyantPossede.get(j)).getCroyantDisponible();
			}
		}
		return nombreCroyantTotal;
	}
	
	/**
	 * Retourne le nombre de Guide de ce joueur.
	 * @return nombreGuide
	 */
	public int getNombreGuide(){
		nombreGuide = this.guidePossede.size();
		return nombreGuide;
	}
	
	/**
	 * Retourne la Divinit� de ce joueur.
	 * @return Divinit�
	 */
	public Carte getDivinite(){
		return Divinite;
	}
	
	/**
	 * Retourne le nombre de points Action d'origine i de ce joueur.
	 * @param i
	 * 			Origine des points Action
	 * @return nombrePointAction[i]
	 */
	public int getPtsAction(int i){
		return nombrePointAction[i];
	}
	/**
	 * Retourne l'indication utiliserDivinit� de ce joueur.
	 * @return utiliserDivinit�
	 */
	public boolean getUtiliserDivinite(){
		return utiliserDivinite;
	}
	
	/**
	 * Met � jour l'indication utiliserDivinit� de ce joueur.
	 * @param i
	 * 			D�termine la valeur de utiliserDivinit�
	 */
	public void setUtiliserDivinite(int i){
		if (i==0){
			this.utiliserDivinite=true;
		}
		else{
			this.utiliserDivinite=false;
	
		}
	}
	/**
	 * Retourne l'indication passerTour de ce joueur.
	 * @return passerTour
	 */
	public boolean getPasserTour(){
		return this.passerTour;
	}
	/**
	 * Met � jour l'indication passerTour de ce joueur.
	 * @param i
	 * 			D�termine la valeur de passerTour
	 */
	public void setPasserTour(int i){
		if (i==0){
			this.passerTour=true;
		}
		else{
			this.utiliserDivinite=false;
		}
	}

	/**
	 * Retourne le r�sultat du lanc� du d� de ce joueur.
	 * @return resultatDes
	 */
	public Double getResultatDe(){
		return getResultatDes();
	}
	
	/**
	 * Retourne le nombre de Guides poss�d�s par ce joueur sur le plateau.
	 * @return guidePossede
	 */
	public ArrayList<Carte> getGuidePossede(){
		return guidePossede;
	}

	/**
	 * Retourne le nombre de Croyants poss�d�s par ce joueur sur le plateau.
	 * @return croyantPossede
	 */
	public ArrayList<Carte> getCroyantPossede(){
		return croyantPossede;
	}
	/**
	 * Retourne la main du joueur.
	 * @return main
	 */
	public ArrayList<Carte> getMain(){
		return main;
	}
	
	/**
	 * Retourne le nom.
	 * @return nom
	 */
	public String getString(){
		return "" +this.nom ;}

	/**
	 * Retourne les informations de la Divinit� de ce joueur.
	 * @return Nom, Origine et Dogmes de la Divinit�
	 */
	public String getInfosDivinite(){
		return "\n\n Nom: " +this.getDivinite().getNom()+ " \n Origine: "+this.getDivinite().getOrigineCarte()+ " \n Dogme1: "+ this.getDivinite().getNatureCarte1()+ "\n Dogme2: "+this.getDivinite().getNatureCarte2()+ "\n Dogme3: " +this.getDivinite().getNatureCarte3()+ "\n";
	}
	/**
	 * Force un autre joueur � effectuer une action.
	 * @param cible
	 * 			Le joueur forc� � effectuer une action.
	 * @param action
	 * 			Type d'action � effectuer.
	 * @param listeJoueur
	 * 			La liste des joueurs de la partie.
	 * @param cibleEffet
	 * 			Le joueur contre qui l'effet de la carte sacrifi�e sera jou�.
	 * @param table
	 * 			Collection des cartes situ�es au centre de la table de jeu.
	 * @param collection
	 * 			Le deck de cartes.
	 * @param tourJoueur
	 * 			La liste des joueurs selon l'ordre de jeu.
	 */
	public void forcerAction(int cible, boolean action, ArrayList<Joueur> listeJoueur, int cibleEffet , ArrayList<Carte> table, ArrayList<Carte> collection, ArrayList<Joueur> tourJoueur){ // On rentre la boolean de l'action qu'on veut forcer
	
		if ( cible ==0){ 
			if (action == (listeJoueur.get(0).doitPoserApocalypse==true)){
				listeJoueur.get(0).setDoitPoserApocalypse(true);
				cont.setDoitPoserApocalypse(true);
				cont.setModePoserCarte(true);
				
				while(cont.isDoitPoserApocalypse()==true){
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
	
			int rep = cont.getCarteChoisie();

			listeJoueur.get(0).getMain().get(rep).getEffet().utiliserEffet(listeJoueur, 0, table,listeJoueur.get(0).getMain().get(rep), cible, collection, tourJoueur);
			collection.add(listeJoueur.get(0).getMain().get(rep));
			listeJoueur.get(0).getMain().remove(rep);
			}
			else if ( action == (listeJoueur.get(0).doitSacrifierCroyant==true)){
				listeJoueur.get(0).setDoitSacrifierCroyant(true);
				cont.setDoitSacrifierCroyant(true);
				
				while(cont.isDoitSacrifierCroyant()==true){
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				listeJoueur.get(0).guidePossede.get(cont.getReponse1()).getCroyantPossede().get(cont.getReponse2()).getEffet().utiliserEffet(listeJoueur, 0, table, listeJoueur.get(0).guidePossede.get(cont.getReponse1()).croyantPossede.get(cont.getReponse2()), cible, collection, tourJoueur);
				collection.add(listeJoueur.get(0).guidePossede.get(cont.getReponse1()).croyantPossede.get(cont.getReponse2()));
				listeJoueur.get(0).guidePossede.get(cont.getReponse1()).croyantPossede.remove(cont.getReponse2());
			}
			
			else if (action == (listeJoueur.get(0).doitSacrifierGuide==true)){
				listeJoueur.get(0).setDoitSacrifierGuide(true);
				cont.setDoitSacrifierGuide(true);
	
				while (cont.isDoitSacrifierGuide()==true){
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				
				listeJoueur.get(0).guidePossede.get(cont.getReponse1()).getEffet().utiliserEffet(listeJoueur, 0, table, listeJoueur.get(0).guidePossede.get(cont.getReponse1()),cible, collection, tourJoueur);
				for (int i=0; i < listeJoueur.get(0).guidePossede.get(cont.getReponse1()).croyantPossede.size();i++){
					table.add(listeJoueur.get(0).guidePossede.get(cont.getReponse1()).croyantPossede.get(i));
					listeJoueur.get(cible).guidePossede.get(cont.getReponse1()).croyantPossede.remove(i);
				}
				
			}
			
		}
		
		
		else if (cible !=0){ 
			if (action == (listeJoueur.get(cible).doitPoserApocalypse==true)){
				for (int i=0; i<listeJoueur.get(cible).main.size();i++){
					if (listeJoueur.get(cible).main.get(i).isSelectionnee()==true){
						carteChoisie = i;
					}
				}
				
				listeJoueur.get(cible).main.get(carteChoisie).getEffet().utiliserEffet(listeJoueur, 0, table,listeJoueur.get(cible).getMain().get(carteChoisie),cible, collection, tourJoueur);
				collection.add(listeJoueur.get(cible).getMain().get(carteChoisie));
				listeJoueur.get(cible).getMain().remove(carteChoisie);
				
			}
			else if (action == (listeJoueur.get(cible).doitSacrifierCroyant==true)){
				for (int i=0;i<listeJoueur.get(cible).guidePossede.size();i++){
					for (int k=0;k<listeJoueur.get(cible).guidePossede.get(i).croyantPossede.size();k++){
						if(listeJoueur.get(cible).getGuidePossede().get(i).croyantPossede.get(k).isSelectionnee()==true){
							rep1 = i;
							rep2 = k;
						}
					}
				}
				
				collection.add(listeJoueur.get(cible).guidePossede.get(rep1).getCroyantPossede().get(rep2));
				listeJoueur.get(cible).guidePossede.get(rep1).croyantPossede.remove(rep2);
				
			}
			else if (action == (listeJoueur.get(cible).doitSacrifierGuide==true)){
			
				for(int i=0; i< listeJoueur.get(cible).guidePossede.size();i++){
					if( listeJoueur.get(cible).getGuidePossede().get(i).isSelectionnee()==true){
						carteChoisie = i;	
					}
				}
				
				listeJoueur.get(cible).guidePossede.get(carteChoisie).getEffet().utiliserEffet(listeJoueur,0, table,listeJoueur.get(cible).guidePossede.get(carteChoisie), cible, collection, tourJoueur);
				for (int i=0; i< listeJoueur.get(cible).guidePossede.get(carteChoisie).croyantPossede.size();i++){
					collection.add(listeJoueur.get(cible).guidePossede.get(carteChoisie).croyantPossede.get(i));
					listeJoueur.get(cible).guidePossede.get(carteChoisie).croyantPossede.remove(i);
				}
			}
			
		}
	}

	/**
	 * Retourne l'indication stopApocalypse.
	 * @return stopApocalypse
	 */
	public boolean getStopApocalypse() {
		return stopApocalypse;
	}
	/**
	 * Met � jour l'indication stopApocalypse.
	 * @param stopApocalypse
	 * 			Indique si ce joueur peut ou non poser une carte Apocalypse.
	 */
	public void setStopApocalypse(boolean stopApocalypse) {
		this.stopApocalypse = stopApocalypse;
	}
	/**
	 * Retourne l'indication stopSacrificeGuide.
	 * @return stopSacrificeGuide
	 */
	public boolean getStopSacrificeGuide() {
		return isStopSacrificeGuide();
	}
	/**
	 * Met � jour l'indication stopSacrificeGuide.
	 * @param stopSacrificeGuide
	 * 			Indique si ce joueur peut ou non poser une carte Guide Spirituel.
	 */
	public void setStopSacrificeGuide(boolean stopSacrificeGuide) {
		this.stopSacrificeGuide = stopSacrificeGuide;
	}
	/**
	 * Retourne l'indication blocageSacrificeGuide.
	 * @return blocageSacrificeGuide
	 */
	public boolean getBlocageSacrificeGuide() {
		return blocageSacrificeGuide;
	}
	/**
	 * Met � jour l'indication blocageSacrificeGuide.
	 * @param blocageSacrificeGuide
	 * 			Indique si ce joueur sera bloqu� au moment o� il veut sacrifier un de ses Guides.
	 */
	public void setBlocageSacrificeGuide(boolean blocageSacrificeGuide) {
		this.blocageSacrificeGuide = blocageSacrificeGuide;
	}
	/**
	 * Retourne l'indication stopSacrificeGuide.
	 * @return stopSacrificeGuide
	 */
	public boolean isStopSacrificeGuide() {
		return stopSacrificeGuide;
	}
	/**
	 * Retourne l'indication stopSacrificeCroyant.
	 * @return stopSacrificeCroyant
	 */
	public boolean isStopSacrificeCroyant() {
		return stopSacrificeCroyant;
	}
	/**
	 * Met � jour l'indication stopSacrificeCroyant.
	 * @param stopSacrificeCroyant
	 * 			Indique si ce joueur peut ou non poser une carte Croyant.
	 */
	public void setStopSacrificeCroyant(boolean stopSacrificeCroyant) {
		this.stopSacrificeCroyant = stopSacrificeCroyant;
	}
	/**
	 * Retourne l'indication stopPointAction.
	 * @return stopPointAction
	 */
	public boolean isStopPointAction() {
		return stopPointAction;
	}
	/**
	 * Met � jour l'indication stopPointAction.
	 * @param stopPointAction
	 * 			Indique si ce joueur peut ou non gagner des points Action.
	 */
	public void setStopPointAction(boolean stopPointAction) {
		this.stopPointAction = stopPointAction;
	}
	/**
	 * Retourne l'indication doitSacrifierCroyant.
	 * @return doitSacrifierCroyant
	 */
	public boolean isDoitSacrifierCroyant() {
		return doitSacrifierCroyant;
	}
	/**
	 * Met � jour l'indication doitSacrifierCroyant
	 * @param doitSacrifierCroyant
	 * 			Indique si ce joueur est oblig� de sacrifier un de ses Croyants.
	 */
	public void setDoitSacrifierCroyant(boolean doitSacrifierCroyant) {
		this.doitSacrifierCroyant = doitSacrifierCroyant;
	}
	/**
	 * Retourne l'indication doitSacrifierGuide.
	 * @return doitSacrifierGuide
	 */
	public boolean isDoitSacrifierGuide() {
		return doitSacrifierGuide;
	}
	/**
	 * Met � jour l'indication doitSacrifierGuide.
	 * @param doitSacrifierGuide
	 * 			Indique si ce joueur est oblig� de sacrifier un de ses Guides.
	 */
	public void setDoitSacrifierGuide(boolean doitSacrifierGuide) {
		this.doitSacrifierGuide = doitSacrifierGuide;
	}
	/**
	 * Retourne l'indication poserCarte.
	 * @return poserCarte
	 */
	public boolean isPoserCarte() {
		return poserCarte;
	}
	/**
	 * Met � jour l'indication poserCarte.
	 * @param poserCarte
	 * 			Indique que ce joueur veut poser une Carte
	 */
	public void setPoserCarte(boolean poserCarte) {
		this.poserCarte = poserCarte;
	}
	/**
	 * Retourne l'indication sacrifierGuide.
	 * @return sacrifierGuide
	 */
	public boolean isSacrifierGuide() {
		return sacrifierGuide;
	}
	/**
	 * Met � jour l'indication sacrifierGuide.
	 * @param sacrifierGuide
	 * 			Indique que ce joueur veut sacrifier un de ses Guides
	 */
	public void setSacrifierGuide(boolean sacrifierGuide) {
		this.sacrifierGuide = sacrifierGuide;
	}
	/**
	 * Retourne l'indication sacrifierCroyant.
	 * @return sacrifierCroyant
	 */
	public boolean isSacrifierCroyant() {
		return sacrifierCroyant;
	}
	/**
	 * Met � jour l'indication sacrifierCroyant.
	 * @param sacrifierCroyant
	 * 			Indique que ce joueur veut sacrifier un de ses Croyants
	 */
	public void setSacrifierCroyant(boolean sacrifierCroyant) {
		this.sacrifierCroyant = sacrifierCroyant;
	}
	/**
	 * Retourne l'indication blocagePoserGuide.
	 * @return blocagePoserGudie
	 */
	public boolean isBlocagePoserGuide() {
		return blocagePoserGuide;
	}
	/**
	 * Met � jour l'indication blocagePoserGuide.
	 * @param blocagePoserGuide
	 * 			Indique si ce joueur sera bloqu� au moment o� il veut poser un de ses Guides.
	 */
	public void setBlocagePoserGuide(boolean blocagePoserGuide) {
		this.blocagePoserGuide = blocagePoserGuide;
	}
	/**
	 * Retourne l'indication doitPoserApocalypse.
	 * @return doitPoserApocalypse
	 */
	public boolean isDoitPoserApocalypse() {
		return doitPoserApocalypse;
	}
	/**
	 * Met � jour l'indication doitPoserApocalypse.
	 * @param doitPoserApocalypse
	 * 			Indique si ce joueur est oblig� de poser un de ses cartes Apocalypses.
	 */
	public void setDoitPoserApocalypse(boolean doitPoserApocalypse) {
		this.doitPoserApocalypse = doitPoserApocalypse;
	}
	/**
	 * Retourne l'indication blocageSacrificeCroyantTour.
	 * @return blocageSacrificeCroyantTour
	 */
	public boolean isBlocageSacrificeCroyantTour() {
		return blocageSacrificeCroyantTour;
	}
	/**
	 * Met � jour l'indication blocageSacrificeCroyantTour.
	 * @param blocageSacriceCroyantTour
	 * 			Indique si ce joueur sera bloqu� au moment o� il veut sacrifier un de ses Croyants.
	 */
	public void setBlocageSacrificeCroyantTour(boolean blocageSacrificeCroyantTour) {
		this.blocageSacrificeCroyantTour = blocageSacrificeCroyantTour;
	}
	/**
	 * Retourne l'indication partieTerminee
	 * @return partieTerminee
	 */
	public boolean isPartieTerminee() {
		return partieTerminee;
	}
	/**
	 * Met � jour l'indication partieTerminee
	 * @param partieTerminee
	 * 			Indique que le joueur a termin� sa partie.
	 */
	public void setPartieTerminee(boolean partieTerminee) {
		this.partieTerminee = partieTerminee;
	}
	/**
	 * Retourne l'indication effetMiroir.
	 * @return effetMiroir
	 */
	public boolean isEffetMiroir() {
		return effetMiroir;
	}
	/**
	 * Met � jour l'indication effetMiroir.
	 * @param effetMiroir
	 * 			Indique si ce joueur sera victime de son effet qu'il veut jouer.
	 */
	public void setEffetMiroir(boolean effetMiroir) {
		this.effetMiroir = effetMiroir;
	}

	public int getDecalage() {
		return decalage;
	}

	public void setDecalage(int decalage) {
		this.decalage = this.decalage + decalage;
	}

	public double getResultatDes() {
		return resultatDes;
	}

	public void setResultatDes(double resultatDes) {
		this.resultatDes = resultatDes;
	}

	public int getPointDecalage() {
		return pointDecalage;
	}

	public void setPointDecalage(int pointDecalage) {
		this.pointDecalage = pointDecalage;
	}
	
}
