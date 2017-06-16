package main.principal;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.carte.Divinite;
import main.principal.Effet;
import main.strategie.Strategie;
import windowbuilder.vue.FenetrePrincipale;
import windowbuilder.vue.FenetreSecondaire;
import main.carte.*;

import main.effet.*;
import main.strategie.*;


/**
 * <b>Partie est la classe représentant le déroulement du jeu Divinae.</b>
 * <p>Cette classe utilise des objects de type :
 * <ul>
 * <li>Carte</li>
 * <li>Joueur</li>
 * <li>Effet</li>
 * <li>Stategie</li>
 * </ul>
 * </p>
 *
 */
public class Partie{
	
	int nombre,nombre2, nombreJoueur;
	protected Divinite carteDivinite;
	protected Apocalypse carteApocalypse;
	protected DeusEx carteDeusEx;
	protected Croyant carteCroyant;
	protected Guide carteGuide;
	protected Joueur player;
	protected ArrayList<Carte> collectionCarte;
	protected ArrayList<Carte> collectionCarteDivinite;
	protected ArrayList<Joueur> listeJoueur;
	protected ArrayList<Joueur> tourJoueur;
	protected ArrayList<Carte> cartePlateau;
	
	
	/**
	 * Indique si la partie est terminée ou pas.
	 */
	private boolean partieTermine = false;
	
	/**
	 * Oblige à sacrifier une carte
	 */
	protected boolean doitSacrifierCarte = false;
	
	/**
	 * Oblige à sacrifier un Guide
	 */
	protected boolean doitSacrifierGuide = false; 
	
	/**
	 * Oblige à poser une carte Apocalypse
	 */
	protected boolean doitPoserApocalypse = false; 
	
	/**
	 * Empeche de sacrafier une carte Guide
	 */
	protected boolean stopSacrificeGuide = false; 
	
	/**
	 * Empeche de poser une carte Apocalypse
	 */
	protected boolean stopApocalypse = false;
	
	/**
	 * Autorise ou pas les points d'ations
	 */
	protected boolean interdiePointAction = false; 
	
	/**
	 * Informe si un effet divinité à déjà été utilisé ou pas
	 */
	protected boolean effetDivinite = false; 
	
	protected boolean choixJoueur = false;
	
	protected Controller cont;
	
	/**
	 * Constructeur Partie
	 */
	public Partie(){
		
	}
	
	/**
	 * Retourne le deck de cartes
	 * @return Le deck de cartes sous forme d'Array List
	 */
	public ArrayList<Carte> getCollectionCarte(){
		return collectionCarte;
	}
	
	/**
	 * Crée le deck de carte
	 * <p>
	 * Chaque carte est créée individuellement, avec ses attributs et son effet, puis est introduit dans le deck
	 * </p>
	 */
	public void creerDeck(){
		
		// On crée une liste de carte, qui sera la pioche des cartes actions
		collectionCarte = new ArrayList<Carte>();
		// On crée une liste de carte, qui sera la pioche des cartes divinités
		collectionCarteDivinite = new ArrayList<Carte>();
	
		carteDivinite = new Divinite();
		carteApocalypse = new Apocalypse();
		carteDeusEx = new DeusEx();
		carteCroyant = new Croyant();
		carteGuide = new Guide();
		
		carteCroyant = new Croyant("Moines",1,1,4,1,5,1,"/windowbuilder/ressources/carte1.png"); //
		Effet effet1 = new Effet1();
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Moines",2,1,2,5,4,2,"/windowbuilder/ressources/carte2.png"); //
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Moines",3,1,2,4,3,2,"/windowbuilder/ressources/carte3.png"); //
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Moines",4,1,3,1,4,2,"/windowbuilder/ressources/carte4.png"); //
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Moines",5,1,2,1,4,2,"/windowbuilder/ressources/carte5.png"); //
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Travailleurs",6,1,2,5,3,2,"/windowbuilder/ressources/carte6.png"); //
		Effet effet2 = new Effet2();
		carteCroyant.setEffet(effet2);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Travailleurs",7,1,3,1,5,2,"/windowbuilder/ressources/carte7.png"); //
		carteCroyant.setEffet(effet2);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Travailleurs",8,1,2,5,4,2,"/windowbuilder/ressources/carte8.png"); //
		Effet effet3 = new Effet3();
		carteCroyant.setEffet(effet3);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Ermite",9,1,2,5,4,1,"/windowbuilder/ressources/carte9.png"); //
		Effet effet4 = new Effet4();
		carteCroyant.setEffet(effet4);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Ermite",10,1,3,1,4,1,"/windowbuilder/ressources/carte10.png"); //
		carteCroyant.setEffet(effet4);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Integriste",11,1,2,1,5,1,"/windowbuilder/ressources/carte11.png");
		carteCroyant.setEffet(effet4);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Guerriers Saints",12,1,3,1,5,4,"/windowbuilder/ressources/carte12.png");
		Effet effet5 = new Effet5();
		carteCroyant.setEffet(effet5);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Diplomates",13,1,2,5,3,4,"/windowbuilder/ressources/carte13.png");
		Effet effet6 = new Effet6();
		carteCroyant.setEffet(effet6);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Demons",14,3,4,1,5,2,"/windowbuilder/ressources/carte14.png");
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Demons",15,3,2,5,4,2,"/windowbuilder/ressources/carte15.png");
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Demons",16,3,2,4,3,2,"/windowbuilder/ressources/carte16.png");
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Demons",17,3,3,1,4,2,"/windowbuilder/ressources/carte17.png");
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Demons",18,3,2,1,4,2,"/windowbuilder/ressources/carte18.png");
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Alchimistes",19,3,2,1,3,2,"/windowbuilder/ressources/carte19.png");
		carteCroyant.setEffet(effet2);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Alchimistes",20,3,2,1,4,2,"/windowbuilder/ressources/carte20.png");
		carteCroyant.setEffet(effet2);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Alchimistes",21,3,2,1,3,2,"/windowbuilder/ressources/carte21.png");
		carteCroyant.setEffet(effet3);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Vampire",22,3,3,1,5,1,"/windowbuilder/ressources/carte22.png"); // 
		carteCroyant.setEffet(effet4);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Vampire",23,3,2,5,4,1,"/windowbuilder/ressources/carte23.png"); //
		carteCroyant.setEffet(effet4);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Lycanthropes",24,3,2,1,5,4,"/windowbuilder/ressources/carte24.png"); // 
		Effet effet7 = new Effet7();
		carteCroyant.setEffet(effet7);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Pillards",25,3,3,1,4,4,"/windowbuilder/ressources/carte25.png"); //
		Effet effet11 = new Effet11();
		carteCroyant.setEffet(effet11);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Illusionnistes",26,3,2,5,3,4,"/windowbuilder/ressources/carte26.png"); //
		Effet effet8 = new Effet8();
		carteCroyant.setEffet(effet8);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Esprits",27,2,4,1,5,2,"/windowbuilder/ressources/carte27.png"); //
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Esprits",28,2,2,5,4,2,"/windowbuilder/ressources/carte28.png"); //
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Esprits",29,2,2,4,3,2,"/windowbuilder/ressources/carte29.png"); //
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Esprits",30,2,3,1,4,2,"/windowbuilder/ressources/carte30.png"); //
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Esprits",31,2,2,1,4,2,"/windowbuilder/ressources/carte31.png"); //
		carteCroyant.setEffet(effet1);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Alienes",32,2,2,5,3,2,"/windowbuilder/ressources/carte32.png"); //
		carteCroyant.setEffet(effet2);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Alienes",33,2,3,1,5,2,"/windowbuilder/ressources/carte33.png"); //
		carteCroyant.setEffet(effet2);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Alienes",34,2,2,5,4,2,"/windowbuilder/ressources/carte34.png"); //
		carteCroyant.setEffet(effet3);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Revenant",35,2,4,1,5,1,"/windowbuilder/ressources/carte35.png"); //
		carteCroyant.setEffet(effet6);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Revolutionnaires",36,2,2,5,3,2,"/windowbuilder/ressources/carte36.png"); //
		Effet effet9 = new Effet9();
		carteCroyant.setEffet(effet9);
		collectionCarte.add(carteCroyant);
		
		carteCroyant = new Croyant("Nihillistes",37,2,2,4,3,4,"/windowbuilder/ressources/carte37.png"); //
		Effet effet10 = new Effet10();
		carteCroyant.setEffet(effet10);
		collectionCarte.add(carteCroyant);
		
		carteGuide = new Guide("Martyr",38,1,0,5,1,2,"/windowbuilder/ressources/carte38.png"); //
		Effet apocalypse = new EffetApocalypse();
		carteGuide.setEffet(apocalypse);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Martyr",39,3,0,3,5,2,"/windowbuilder/ressources/carte39.png"); //
		carteGuide.setEffet(apocalypse);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Martyr",40,2,0,2,1,2,"/windowbuilder/ressources/carte40.png"); //
		carteGuide.setEffet(apocalypse);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Clerc",41,1,0,2,5,2,"/windowbuilder/ressources/carte41.png"); //
		Effet effet12 = new Effet12();
		carteGuide.setEffet(effet12);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Clerc",42,3,0,3,1,2,"/windowbuilder/ressources/carte42.png"); //
		carteGuide.setEffet(effet12);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Clerc",43,2,0,4,1,2,"/windowbuilder/ressources/carte43.png"); //
		carteGuide.setEffet(effet12);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Clerc",44,1,0,2,1,2,"/windowbuilder/ressources/carte44.png"); //
		carteGuide.setEffet(effet12);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Clerc",45,3,0,3,4,2,"/windowbuilder/ressources/carte45.png"); //
		carteGuide.setEffet(effet12);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Clerc",46,2,0,4,3,2,"/windowbuilder/ressources/carte46.png"); //
		carteGuide.setEffet(effet12);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Clerc",47,1,0,2,4,2,"/windowbuilder/ressources/carte47.png"); //
		carteGuide.setEffet(effet12);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Clerc",48,3,0,5,1,2,"/windowbuilder/ressources/carte48.png"); //
		carteGuide.setEffet(effet12);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Shaman",49,3,0,3,1,3,"/windowbuilder/ressources/carte49.png"); //
		Effet effet13 = new Effet13();
		carteGuide.setEffet(effet13);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Anarchiste",50,2,0,2,5,3,"/windowbuilder/ressources/carte50.png");//
		Effet effet14 = new Effet14();
		carteGuide.setEffet(effet14);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Paladin",51,1,0,4,5,3,"/windowbuilder/ressources/carte51.png"); //
		Effet effet15 = new Effet15();
		carteGuide.setEffet(effet15);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Ascete",52,3,0,3,5,1,"/windowbuilder/ressources/carte52.png");//
		Effet effet52= new Effet52();
		carteGuide.setEffet(effet52);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Devin",53,2,0,4,1,1,"/windowbuilder/ressources/carte53.png"); //
		Effet effet17 = new Effet17();
		carteGuide.setEffet(effet17);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Exorciste",54,1,0,2,4,1,"/windowbuilder/ressources/carte54.png"); //
		Effet effet18 = new Effet18();
		carteGuide.setEffet(effet18);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Sorcier",55,3,0,3,4,3,"/windowbuilder/ressources/carte55.png"); // 
		Effet effet19 = new Effet19();
		carteGuide.setEffet(effet19);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Tyran",56,2,0,2,3,3,"/windowbuilder/ressources/carte56.png"); //
		Effet effet20 = new Effet20();
		carteGuide.setEffet(effet20);
		collectionCarte.add(carteGuide);
		
		carteGuide = new Guide("Messie",57,1,0,4,5,3,"/windowbuilder/ressources/carte57.png"); //
		Effet effet57 = new Effet57();
		carteGuide.setEffet(effet57);
		collectionCarte.add(carteGuide);
		
		carteDeusEx = new DeusEx("Colere Divine",58,1,0,0,0,"/windowbuilder/ressources/carte58.png"); //
		Effet effet58 = new Effet58();
		carteDeusEx.setEffet(effet58);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Colere Divinie",59,3,0,0,0,"/windowbuilder/ressources/carte59.png");//
		carteDeusEx.setEffet(effet58);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Stase",60,1,0,0,0,"/windowbuilder/ressources/carte60.png"); //
		Effet effet60 = new Effet60();
		carteDeusEx.setEffet(effet60);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Ordre Celeste",61,1,0,0,0,"/windowbuilder/ressources/carte61.png");//
		Effet effet61 = new Effet61();
		carteDeusEx.setEffet(effet61);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Fourberie",62,3,0,0,0,"/windowbuilder/ressources/carte62.png"); //
		Effet effet62 = new Effet62();
		carteDeusEx.setEffet(effet62);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Diversion",63,3,0,0,0,"/windowbuilder/ressources/carte63.png"); //
		Effet effet63 = new Effet63();
		carteDeusEx.setEffet(effet63);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Concentration",64,2,0,0,0,"/windowbuilder/ressources/carte64.png"); //
		carteDeusEx.setEffet(effet61);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Trou Noir",65,2,0,0,0,"/windowbuilder/ressources/carte65.png"); //
		Effet effet22 = new Effet22();
		carteDeusEx.setEffet(effet22);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Phoenix",66,2,0,0,0,"/windowbuilder/ressources/carte66.png"); //
		Effet effet66 = new Effet66();
		carteDeusEx.setEffet(effet66);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Influence Jour",67,0,0,0,0,"/windowbuilder/ressources/carte67.png");//
		Effet effet24 = new Effet24();
		carteDeusEx.setEffet(effet24);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Influence Nuit",68,0,0,0,0,"/windowbuilder/ressources/carte68.png");//
		carteDeusEx.setEffet(effet24);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Influence Neant",69,0,0,0,0,"/windowbuilder/ressources/carte69.png");//
		carteDeusEx.setEffet(effet24);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Influence Nulle",70,0,0,0,0,"/windowbuilder/ressources/carte70.png");//
		carteDeusEx.setEffet(effet24);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx= new DeusEx("Influence Nulle",71,0,0,0,0,"/windowbuilder/ressources/carte71.png");//
		carteDeusEx.setEffet(effet24);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Transe",72,0,0,0,0,"/windowbuilder/ressources/carte72.png");//
		carteDeusEx.setEffet(effet24);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Miroir",73,0,0,0,0,"/windowbuilder/ressources/carte73.png");////////
		Effet effet73 = new Effet73();
		carteDeusEx.setEffet(effet73);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Bouleversement",74,0,0,0,0,"/windowbuilder/ressources/carte74.png"); //
		Effet effet74 = new Effet74();
		carteDeusEx.setEffet(effet74);
		collectionCarte.add(carteDeusEx);
		
		carteDeusEx = new DeusEx("Inquisition",75,0,0,0,0,"/windowbuilder/ressources/carte75.png");//
		Effet effet75 = new Effet75();
		carteDeusEx.setEffet(effet75);
		collectionCarte.add(carteDeusEx);
		
		carteApocalypse = new Apocalypse("Apocalypse",76,1,0,0,0,"/windowbuilder/ressources/carte76.png"); //
		carteApocalypse.setEffet(apocalypse);
		collectionCarte.add(carteApocalypse);
		
		carteApocalypse = new Apocalypse("Apocalypse",77,3,0,0,0,"/windowbuilder/ressources/carte77.png"); //
		carteApocalypse.setEffet(apocalypse);
		collectionCarte.add(carteApocalypse);
		
		carteApocalypse = new Apocalypse("Apocalypse",78,2,0,0,0,"/windowbuilder/ressources/carte78.png"); // 
		carteApocalypse.setEffet(apocalypse);
		collectionCarte.add(carteApocalypse);
		
		carteApocalypse = new Apocalypse("Apocalypse",79,0,0,0,0,"/windowbuilder/ressources/carte79.png"); //
		carteApocalypse.setEffet(apocalypse);
		collectionCarte.add(carteApocalypse);
		
		carteApocalypse = new Apocalypse("Apocalypse",80,0,0,0,0,"/windowbuilder/ressources/carte80.png"); //
		carteApocalypse.setEffet(apocalypse);
		collectionCarte.add(carteApocalypse);
		
		carteDivinite = new Divinite ("Brenvalen",81,1,1,5,4,"/windowbuilder/ressources/divinite1.png");
		Effet effet = new Brenvalen();
		carteDivinite.setEffet(effet);
		collectionCarteDivinite.add(carteDivinite);
		
		carteDivinite = new Divinite("Drinded",82,1,1,5,3,"/windowbuilder/ressources/divinite2.png");
		Effet drinded = new Drinded();
		carteDivinite.setEffet(drinded);
		collectionCarteDivinite.add(carteDivinite);
		
		carteDivinite = new Divinite("Yarstur",83,1,2,3,4,"/windowbuilder/ressources/divinite3.png");
		Effet yarstur = new Yarstur();
		carteDivinite.setEffet(yarstur);
		collectionCarteDivinite.add(carteDivinite);
		
		carteDivinite = new Divinite("Killinstred",84,3,1,4,2,"/windowbuilder/ressources/divinite4.png");
		Effet llenvella = new Llenvella();
		carteDivinite.setEffet(llenvella);
		collectionCarteDivinite.add(carteDivinite);
		
		carteDivinite = new Divinite("Llenvella",85,3,1,4,2,"/windowbuilder/ressources/divinite5.png");
		carteDivinite.setEffet(llenvella);
		collectionCarteDivinite.add(carteDivinite);
		
		carteDivinite = new Divinite("Pui-Tara",86,3,1,4,3,"/windowbuilder/ressources/divinite6.png");
		carteDivinite.setEffet(yarstur);
		collectionCarteDivinite.add(carteDivinite);
		
		carteDivinite = new Divinite("Gnvenghelen",87,4,5,4,3,"/windowbuilder/ressources/divinite7.png");
		Effet gnvenghelen = new Gnvenghelen();
		carteDivinite.setEffet(gnvenghelen);
		collectionCarteDivinite.add(carteDivinite);
		
		carteDivinite = new Divinite("Shingva",88,4,5,4,2,"/windowbuilder/ressources/divinite8.png");
		Effet shingva = new Shingva();
		carteDivinite.setEffet(shingva);
		collectionCarteDivinite.add(carteDivinite);
		
		carteDivinite = new Divinite("Gorpa",89,5,5,3,2,"/windowbuilder/ressources/divinite9.png");
		Effet gorpa = new Gorpa();
		carteDivinite.setEffet(gorpa);
		collectionCarteDivinite.add(carteDivinite);
		
		carteDivinite = new Divinite("Romtec",90,5,1,5,2,"/windowbuilder/ressources/divinite10.png");
		Effet romtec = new Romtec();
		carteDivinite.setEffet(romtec);
		collectionCarteDivinite.add(carteDivinite);
		
	}

	/**
	 * Gère le deroulement de la partie
	 */
	public void demarrerPartie(){
		
		Controller cont = Controller.getInstance();
		FenetrePrincipale a = new FenetrePrincipale(0);
		FenetreSecondaire b = new FenetreSecondaire(0);
		
		cont.addObserver(a);
		
		
		while(cont.getNombreJoueur()==-1){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		int rep = cont.getNombreJoueur();
		System.out.println("Initialisation de la partie\n\n");
		this.creerDeck();
		this.melangerDeck();
		this.creerListeJoueur(rep);
		
		
		cont.setListeJoueur(listeJoueur);
		this.distribuerDivinite();
		
		cont.setDivinite(this.listeJoueur.get(0).Divinite);
		
		cartePlateau = new ArrayList<Carte>();
		// GUI : On affiche ça dans la chatbox	
		//System.out.println("Vous etes le joueur " +this.listeJoueur.get(0).getString());

		/***************************************************************************************************
		************************************ PARTIE COMMENCE ICI *******************************************
		****************************************************************************************************/
		int nbreTour=1;
		 listeJoueur.get(0).setPartieTerminee(false);
		 cont.setDoitPoserApocalypse(false);
		 for (int i=0;i<listeJoueur.size();i++){
			 listeJoueur.get(i).setDecalage(0);
		 }
		 
		 while ( listeJoueur.get(0).isPartieTerminee() == false && listeJoueur.size()>=2){
		
		choixJoueur = false;	
		
		this.distribuerCarte();
		cont.setMain(this.listeJoueur.get(0).main);
		
		for (int i=0; i<this.listeJoueur.get(0).main.size();i++){
			this.listeJoueur.get(0).main.get(i).setSelectionnee(false);
			cont.getMain().get(i).setSelectionnee(false);
			cont.getMain().get(i).setImage(this.listeJoueur.get(0).main.get(i).getImage());
		}
			
		this.tourJoueur.get(0).lancerDe(this.listeJoueur);
		
		for (int t=0; t<listeJoueur.size();t++){
			listeJoueur.get(t).setStopPointAction(false);
		}
		cont.setResultatDe(-1);

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};
		
									cont.setModeDefausser(true);
	
		System.out.println("\n Defausser des cartes ?");

		while(cont.isDefausser()!=true){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		int nbre = cont.getNbreDefaussage();
		int i=0;
		int c = 0, temp=7;
		
		while (i < nbre){
			for (int j=0; j<listeJoueur.get(0).main.size();j++){
				if (cont.getChoix(j)==1){
					int crte = j;
						if (crte > temp){
							c++;
							cont.setChoix(j,-1);
							this.listeJoueur.get(0).defausserCarte(crte-c, this.getCollectionCarte());	
							temp = crte;
						}
						else{
							cont.setChoix(j,-1);
							this.listeJoueur.get(0).defausserCarte(crte-c, this.getCollectionCarte());
							temp = crte;
						}
					this.distribuerCarte();
				}
			
			}
			i++;
		}
		

		cont.setCarteMain(this.listeJoueur.get(0).main);
		cont.setInfluence((int)tourJoueur.get(0).getResultatDes());
		cont.setPtsActionJour(this.listeJoueur.get(0).nombrePointAction[1]);
		cont.setPtsActionNuit(this.listeJoueur.get(0).nombrePointAction[3]);
		cont.setPtsActionNeant(this.listeJoueur.get(0).nombrePointAction[2]);
		
										cont.setModeDefausser(false);
										cont.setModePoserCarte(true);

		System.out.println("\n\n/// Tour : " +nbreTour+ " ///");
		System.out.println("/// Infos: "+this.tourJoueur.get(0).getNom()+ " lance le dé ///\n");

		cont.setCroyantPossede(this.listeJoueur.get(0).croyantPossede);
		cont.setGuidePossede(this.listeJoueur.get(0).guidePossede);
			
	for (int j=0; j<tourJoueur.size();j++){
		if (this.tourJoueur.get(j)== this.listeJoueur.get(0)){
			System.out.print("\n\n A votre tour !\n\n");

			while ( choixJoueur == false){
					
				while (cont.isChoixJoueur()!=true){
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if (cont.isPasserTour()==true){	
					cont.setTexte("Vous passez votre tour");
					choixJoueur = true;
					cont.setChoixJoueur(false);
				}
				
				if (cont.isPoserCarte()==true){
	
						int k = cont.getCarteChoisie();
				
						if ((this.listeJoueur.get(0).main.get(k).getIdentifiantCarte()>=1 && this.listeJoueur.get(0).main.get(k).getIdentifiantCarte()<=37)){ 
							if (this.listeJoueur.get(0).nombrePointAction[this.listeJoueur.get(0).main.get(k).getOrigineCarte()] !=0){ 
								this.listeJoueur.get(0).setPointAction(this.listeJoueur.get(0).main.get(k).getOrigineCarte(),-1);
								this.listeJoueur.get(0).poserCarte(k, this.cartePlateau, this.getCollectionCarte(), this.listeJoueur, this.tourJoueur,j,0);
								cont.setAnimationCarte(cartePlateau.size());
								choixJoueur = true;
								
								cont.setChoixJoueur(false);
								cont.setPtsActionJour(this.listeJoueur.get(0).nombrePointAction[1]);
								cont.setPtsActionNuit(this.listeJoueur.get(0).nombrePointAction[3]);
								cont.setPtsActionNeant(this.listeJoueur.get(0).nombrePointAction[2]);
								for (int z=0;z<listeJoueur.size();z++){
										cont.setNombrePriere(z+listeJoueur.get(0).getDecalage(), this.listeJoueur.get(z).getNombreCroyantTotal());
									 
								}
							}
							else if(this.listeJoueur.get(0).main.get(k).getOrigineCarte() ==2){
								if(this.listeJoueur.get(0).nombrePointAction[1]>=2){
									this.listeJoueur.get(0).setPointAction(1, -2);
									this.listeJoueur.get(0).poserCarte(k,this.cartePlateau, this.getCollectionCarte(), this.listeJoueur,this.tourJoueur,j,0);
									cont.setAnimationCarte(cartePlateau.size());
									
									choixJoueur = true;
									
									cont.setChoixJoueur(false);
									cont.setPtsActionJour(this.listeJoueur.get(0).nombrePointAction[1]);
									cont.setPtsActionNuit(this.listeJoueur.get(0).nombrePointAction[3]);
									cont.setPtsActionNeant(this.listeJoueur.get(0).nombrePointAction[2]);
									for (int z=0;z<listeJoueur.size();z++){
										cont.setNombrePriere(z+listeJoueur.get(0).getDecalage(), this.listeJoueur.get(z).getNombreCroyantTotal());
									 
								}
								}
								else if ( this.listeJoueur.get(0).nombrePointAction[3]>=2){
									this.listeJoueur.get(0).setPointAction(3, -2);
									this.listeJoueur.get(0).poserCarte(k, this.cartePlateau, this.getCollectionCarte(), this.listeJoueur, this.tourJoueur,j,0); 
									cont.setAnimationCarte(cartePlateau.size());
									choixJoueur = true;
									
									cont.setChoixJoueur(false);
									cont.setPtsActionJour(this.listeJoueur.get(0).nombrePointAction[1]);
									cont.setPtsActionNuit(this.listeJoueur.get(0).nombrePointAction[3]);
									cont.setPtsActionNeant(this.listeJoueur.get(0).nombrePointAction[2]);
									for (int z=0;z<listeJoueur.size();z++){
										cont.setNombrePriere(z+listeJoueur.get(0).getDecalage(), this.listeJoueur.get(z).getNombreCroyantTotal());
									 
								}
								}
								else{
									cont.setTexte("Vous n'avez pas assez de point d'actions");
									cont.setPoserCarte(false);
									cont.setChoixJoueur(false);
									cont.setPasserTour(true);
								}
							}
							else{
								cont.setTexte("Vous n'avez pas assez de point d'action");
								cont.setPoserCarte(false);
								cont.setChoixJoueur(false);
								cont.setPasserTour(true);
							}
						}
						else if ((this.listeJoueur.get(0).main.get(k).getIdentifiantCarte()>=38 && this.listeJoueur.get(0).main.get(k).getIdentifiantCarte()<=57)){
							if (this.listeJoueur.get(0).nombrePointAction[this.listeJoueur.get(0).main.get(k).getOrigineCarte()] !=0){ 
								this.listeJoueur.get(0).setPointAction(this.listeJoueur.get(0).main.get(k).getOrigineCarte(),-1);
								this.listeJoueur.get(0).poserCarte(k, this.cartePlateau, this.getCollectionCarte(), this.listeJoueur,this.tourJoueur,j,0);
								cont.setGuidePossede(this.listeJoueur.get(0).guidePossede);
								cont.setCroyantPossede(this.listeJoueur.get(0).croyantPossede);
								choixJoueur = true;

								cont.setChoixJoueur(false);
								cont.setPtsActionJour(this.listeJoueur.get(0).nombrePointAction[1]);
								cont.setPtsActionNuit(this.listeJoueur.get(0).nombrePointAction[3]);
								cont.setPtsActionNeant(this.listeJoueur.get(0).nombrePointAction[2]);
								for (int z=0;z<listeJoueur.size();z++){
									cont.setNombrePriere(z+listeJoueur.get(0).getDecalage(), this.listeJoueur.get(z).getNombreCroyantTotal());
								 
							}
						}
							else if(this.listeJoueur.get(0).main.get(k).getOrigineCarte() ==2){ 
								if(this.listeJoueur.get(0).nombrePointAction[1]>=2){
									this.listeJoueur.get(0).setPointAction(1, -2); 
									this.listeJoueur.get(0).poserCarte(k,this.cartePlateau, this.getCollectionCarte(),this.listeJoueur,this.tourJoueur,j,0);
									cont.setGuidePossede(this.listeJoueur.get(0).guidePossede);
									cont.setCroyantPossede(this.listeJoueur.get(0).croyantPossede);
									choixJoueur = true;
									
									cont.setChoixJoueur(false);
									cont.setPtsActionJour(this.listeJoueur.get(0).nombrePointAction[1]);
									cont.setPtsActionNuit(this.listeJoueur.get(0).nombrePointAction[3]);
									cont.setPtsActionNeant(this.listeJoueur.get(0).nombrePointAction[2]);
									for (int z=0;z<listeJoueur.size();z++){
										cont.setNombrePriere(z+listeJoueur.get(0).getDecalage(), this.listeJoueur.get(z).getNombreCroyantTotal());	 
								}
								}
								else if ( this.listeJoueur.get(0).nombrePointAction[3]>=2){ // On regarde si on a assez de point d'action Nuit
									this.listeJoueur.get(0).setPointAction(3, -2); // Si c'est le cas, on en retire 2
									this.listeJoueur.get(0).poserCarte(k, this.cartePlateau, this.getCollectionCarte(),this.listeJoueur,this.tourJoueur,j,0); // On pose la carte
									cont.setGuidePossede(this.listeJoueur.get(0).guidePossede);
									cont.setCroyantPossede(this.listeJoueur.get(0).croyantPossede);
									choixJoueur = true;
									
									cont.setChoixJoueur(false);
									cont.setPtsActionJour(this.listeJoueur.get(0).nombrePointAction[1]);
									cont.setPtsActionNuit(this.listeJoueur.get(0).nombrePointAction[3]);
									cont.setPtsActionNeant(this.listeJoueur.get(0).nombrePointAction[2]);
									for (int z=0;z<listeJoueur.size();z++){
										cont.setNombrePriere(z+listeJoueur.get(0).getDecalage(), this.listeJoueur.get(z).getNombreCroyantTotal());	 
								}
								}
								else{
									cont.setTexte("Vous n'avez pas assez de points d'action");
									cont.setPoserCarte(false);
									cont.setChoixJoueur(false);
									cont.setPasserTour(true);
								}
							}
							else{
								cont.setTexte("Vous n'avez pas assez de points d'action");
								cont.setPoserCarte(false);
								cont.setChoixJoueur(false);
								cont.setPasserTour(true);
							}
						}
						else if((this.listeJoueur.get(0).main.get(k).getIdentifiantCarte()>=58 && this.listeJoueur.get(0).main.get(k).getIdentifiantCarte()<=75)){ 
							if (this.listeJoueur.get(0).main.get(k).getOrigineCarte() ==0){
								this.listeJoueur.get(0).poserCarte(k, this.cartePlateau, this.getCollectionCarte(),this.listeJoueur,this.tourJoueur,j,0);
								choixJoueur = true;
								
								cont.setChoixJoueur(false);
								cont.setCarteMain(this.listeJoueur.get(0).main);
								cont.setPtsActionJour(this.listeJoueur.get(0).nombrePointAction[1]);
								cont.setPtsActionNuit(this.listeJoueur.get(0).nombrePointAction[3]);
								cont.setPtsActionNeant(this.listeJoueur.get(0).nombrePointAction[2]);
								for (int z=0;z<listeJoueur.size();z++){
									cont.setNombrePriere(z+listeJoueur.get(0).getDecalage(), this.listeJoueur.get(z).getNombreCroyantTotal());	 
								}
							}
							else if (this.listeJoueur.get(0).nombrePointAction[this.listeJoueur.get(0).main.get(k).getOrigineCarte()] !=0){ 
								this.listeJoueur.get(0).setPointAction(this.listeJoueur.get(0).main.get(k).getOrigineCarte(),-1);
								this.listeJoueur.get(0).poserCarte(k, this.cartePlateau, this.getCollectionCarte(), this.listeJoueur,this.tourJoueur,j,0);
								choixJoueur = true;
								
								cont.setChoixJoueur(false);
								cont.setPtsActionJour(this.listeJoueur.get(0).nombrePointAction[1]);
								cont.setPtsActionNuit(this.listeJoueur.get(0).nombrePointAction[3]);
								cont.setPtsActionNeant(this.listeJoueur.get(0).nombrePointAction[2]);
								for (int z=0;z<listeJoueur.size();z++){
									cont.setNombrePriere(z+listeJoueur.get(0).getDecalage(), this.listeJoueur.get(z).getNombreCroyantTotal());	 
								}
							}
							else if(this.listeJoueur.get(0).main.get(k).getOrigineCarte() ==2){ 
								if(this.listeJoueur.get(0).nombrePointAction[1]>=2){ 
									this.listeJoueur.get(0).setPointAction(1, -2); 
									this.listeJoueur.get(0).poserCarte(k,this.cartePlateau, this.getCollectionCarte(),this.listeJoueur,this.tourJoueur,j,0); 
									choixJoueur = true;
									
									cont.setChoixJoueur(false);
									cont.setPtsActionJour(this.listeJoueur.get(0).nombrePointAction[1]);
									cont.setPtsActionNuit(this.listeJoueur.get(0).nombrePointAction[3]);
									cont.setPtsActionNeant(this.listeJoueur.get(0).nombrePointAction[2]);
									for (int z=0;z<listeJoueur.size();z++){
										cont.setNombrePriere(z+listeJoueur.get(0).getDecalage(), this.listeJoueur.get(z).getNombreCroyantTotal());	 
									}
								}
								else if ( this.listeJoueur.get(0).nombrePointAction[3]>=2){ 
									this.listeJoueur.get(0).setPointAction(3, -2); 
									this.listeJoueur.get(0).poserCarte(k, this.cartePlateau, this.getCollectionCarte(),this.listeJoueur,this.tourJoueur,j,0); 
									choixJoueur = true;
									
									cont.setChoixJoueur(false);
									cont.setPtsActionJour(this.listeJoueur.get(0).nombrePointAction[1]);
									cont.setPtsActionNuit(this.listeJoueur.get(0).nombrePointAction[3]);
									cont.setPtsActionNeant(this.listeJoueur.get(0).nombrePointAction[2]);
									for (int z=0;z<listeJoueur.size();z++){
										cont.setNombrePriere(z+listeJoueur.get(0).getDecalage(), this.listeJoueur.get(z).getNombreCroyantTotal());
									}
								}
								else{
									cont.setPoserCarte(false);
									cont.setChoixJoueur(false);
									cont.setPasserTour(true);
								}
							}
							else{
								cont.setPoserCarte(false);
								cont.setChoixJoueur(false);
								cont.setPasserTour(true);
							}
						}
						else if ((this.listeJoueur.get(0).main.get(k).getIdentifiantCarte()>=76 && this.listeJoueur.get(0).main.get(k).getIdentifiantCarte()<=80)){ 
							if (this.listeJoueur.get(0).main.get(k).getOrigineCarte()==0){
								this.listeJoueur.get(0).poserCarte(k,this.cartePlateau, this.collectionCarte, this.listeJoueur, this.tourJoueur,j,0);
								choixJoueur = true;
								
								cont.setChoixJoueur(false);
								cont.setPtsActionJour(this.listeJoueur.get(0).nombrePointAction[1]);
								cont.setPtsActionNuit(this.listeJoueur.get(0).nombrePointAction[3]);
								cont.setPtsActionNeant(this.listeJoueur.get(0).nombrePointAction[2]);
								for (int z=0;z<listeJoueur.size();z++){
									cont.setNombrePriere(z+listeJoueur.get(0).getDecalage(), this.listeJoueur.get(z).getNombreCroyantTotal()); 
								}
							}
							else if(this.listeJoueur.get(0).main.get(k).getOrigineCarte() ==2){
								if(this.listeJoueur.get(0).nombrePointAction[1]>=2){ 
									this.listeJoueur.get(0).setPointAction(1, -2);
									this.listeJoueur.get(0).poserCarte(k,this.cartePlateau, this.getCollectionCarte(),this.listeJoueur,this.tourJoueur,j,0); 
									choixJoueur = true;
									
									cont.setChoixJoueur(false);
									cont.setPtsActionJour(this.listeJoueur.get(0).nombrePointAction[1]);
									cont.setPtsActionNuit(this.listeJoueur.get(0).nombrePointAction[3]);
									cont.setPtsActionNeant(this.listeJoueur.get(0).nombrePointAction[2]);
									for (int z=0;z<listeJoueur.size();z++){
										cont.setNombrePriere(z+listeJoueur.get(0).getDecalage(), this.listeJoueur.get(z).getNombreCroyantTotal());
									}
								}
								else if ( this.listeJoueur.get(0).nombrePointAction[3]>=2){ 
									this.listeJoueur.get(0).setPointAction(3, -2); 
									this.listeJoueur.get(0).poserCarte(k, this.cartePlateau, this.getCollectionCarte(),this.listeJoueur,this.tourJoueur,j,0);
									choixJoueur = true;
									
									cont.setChoixJoueur(false);
									cont.setPtsActionJour(this.listeJoueur.get(0).nombrePointAction[1]);
									cont.setPtsActionNuit(this.listeJoueur.get(0).nombrePointAction[3]);
									cont.setPtsActionNeant(this.listeJoueur.get(0).nombrePointAction[2]);
									for (int z=0;z<listeJoueur.size();z++){
										cont.setNombrePriere(z+listeJoueur.get(0).getDecalage(), this.listeJoueur.get(z).getNombreCroyantTotal()); 
									}
								}
								else{
									cont.setPoserCarte(false);
									cont.setChoixJoueur(false);
									cont.setPasserTour(true);
								}
							}
						}
						else{
							cont.setPoserCarte(false);
							cont.setChoixJoueur(false);
							cont.setPasserTour(true);
						}
					}
			if (cont.isSacrifierCarte()==true){	
						if ( (cont.getReponse1()!= -1) && (cont.getReponse2()!= -1)){ 
							if ( listeJoueur.get(0).isBlocageSacrificeCroyantTour()==false){	
							listeJoueur.get(0).setSacrifierCroyant(true);
							this.listeJoueur.get(0).setSacrifierGuide(true);
							this.listeJoueur.get(0).sacrifierCarte(this.collectionCarte, cont.getReponse2(), cont.getReponse1(),j,this.listeJoueur,0,this.cartePlateau, this.tourJoueur);
							choixJoueur = true;
							
							cont.setChoixJoueur(false);
							cont.setPtsActionJour(this.listeJoueur.get(0).nombrePointAction[1]);
							cont.setPtsActionNuit(this.listeJoueur.get(0).nombrePointAction[3]);
							cont.setPtsActionNeant(this.listeJoueur.get(0).nombrePointAction[2]);
							for (int z=0;z<listeJoueur.size();z++){
								cont.setNombrePriere(z+listeJoueur.get(0).getDecalage(), this.listeJoueur.get(z).getNombreCroyantTotal()); 
							}	
						}
						else{
							cont.setTexte("Info: Vous ne pouvez pas sacrifier un Croyant ce tour");
							}
						}
						else if( cont.getReponse1()!=-1 && cont.getReponse2()==-1){ 
							listeJoueur.get(0).setSacrifierGuide(true);
							this.listeJoueur.get(0).sacrifierCarte(this.collectionCarte,0, cont.getReponse1(),j,this.listeJoueur,0,this.cartePlateau,this.tourJoueur);
							choixJoueur = true;
							
							cont.setChoixJoueur(false);
							cont.setPtsActionJour(this.listeJoueur.get(0).nombrePointAction[1]);
							cont.setPtsActionNuit(this.listeJoueur.get(0).nombrePointAction[3]);
							cont.setPtsActionNeant(this.listeJoueur.get(0).nombrePointAction[2]);
							for (int z=0;z<listeJoueur.size();z++){
								cont.setNombrePriere(z+listeJoueur.get(0).getDecalage(), this.listeJoueur.get(z).getNombreCroyantTotal()); 
							}
						}
					}
					
				if (cont.isUtiliserDivinite()==true){
						choixJoueur=true;
						cont.setChoixJoueur(false);
						this.listeJoueur.get(0).effetDivinite = true; 
						cont.setEffetDivinite(true); 
						this.listeJoueur.get(0).Divinite.getEffet().utiliserEffetDivinite(this.listeJoueur,j,this.collectionCarte,cartePlateau, 0,tourJoueur);
						
						cont.setPtsActionJour(this.listeJoueur.get(0).nombrePointAction[1]);
						cont.setPtsActionNuit(this.listeJoueur.get(0).nombrePointAction[3]);
						cont.setPtsActionNeant(this.listeJoueur.get(0).nombrePointAction[2]);
						for (int z=0;z<listeJoueur.size();z++){
							cont.setNombrePriere(z+listeJoueur.get(0).getDecalage(), this.listeJoueur.get(z).getNombreCroyantTotal()); 
						}
				}
		} 
			
	} 
	else{
	
				cont.setTexte("Le joueur " +tourJoueur.get(j).getNom()+ " va jouer");
				int choix = this.tourJoueur.get(j).strategie.choisirCarte(this.tourJoueur, j,this.collectionCarte, this.cartePlateau);
				this.tourJoueur.get(j).poserCarteIA(choix, this.cartePlateau,this.listeJoueur, this.collectionCarte, this.tourJoueur, j,0);
				
				cont.setPtsActionJour(this.listeJoueur.get(0).nombrePointAction[1]);
				cont.setPtsActionNuit(this.listeJoueur.get(0).nombrePointAction[3]);
				cont.setPtsActionNeant(this.listeJoueur.get(0).nombrePointAction[2]);
				for (int z=0;z<listeJoueur.size();z++){
					cont.setNombrePriere(z+listeJoueur.get(0).getDecalage(), this.listeJoueur.get(z).getNombreCroyantTotal());
				 }
				cont.setListePlateau(cartePlateau);
				
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		cont.setListePlateau(cartePlateau);
			
	}
		
	
		for (int k=0;k<listeJoueur.size();k++){
			listeJoueur.get(k).setBlocageSacrificeCroyantTour(false);
			
		}
	
		this.tourJoueur.add(this.tourJoueur.get(0));
		this.tourJoueur.remove(0);
		nbreTour++;
		
		cont.setPoserCarte(false);
		cont.setSacrifierCarte(false);
		cont.setPasserTour(true);
		cont.setUtiliserDivinite(false);
		cont.setDefausser(false);
		
		cont.setCarteChoisie(-1);
		cont.setChoixCible(-1);
		cont.setReponse1(-1);
		cont.setReponse2(-1);
		
		for(int compt=0;compt<listeJoueur.get(0).getMain().size();compt++){
			cont.setChoix(compt, -1);
		}
	}
		
		if (listeJoueur.size()==1){
			System.out.println("Félicitations, vous avez gagné !");
		}
		else if( listeJoueur.get(0).isPartieTerminee()==true){
			System.out.println("Vous avez perdu");
		}
		
	}
	/**
	 * Melange les decks de cartes Action et Divinités
	 */
	public void melangerDeck(){
	Collections.shuffle(collectionCarte); 
	Collections.shuffle(collectionCarteDivinite); 
	}
	
	/**
	 * Méthode pour créer la liste des joueurs
	 * @param nombreJoueur
	 */
	public void creerListeJoueur( int nombreJoueur){
		listeJoueur = new ArrayList<Joueur>();
		tourJoueur = new ArrayList<Joueur>();
		
		Strategie collecteur = new Collecteur();
		Strategie chaos = new Chaos();
		
		for (int i=0; i<nombreJoueur; i++)
		{
		player = new Joueur(); 
		if ( i!=0){
			double nb = Math.round(Math.random()*2);
			if ( nb>=0 && nb<1 ){
				player.setStrategie(collecteur);
			}
			else{
				player.setStrategie(chaos);
			}

		}
			
		player.setNom(i); 
		listeJoueur.add(player); 
		tourJoueur.add(player); 
		}
	}


	/**
	 * Attribue à chaque joueur une carte Divinité
	 * <p>
	 * Après attribution, la carte est retirée du deck Divinité
	 * </p>
	 */
	public void distribuerDivinite(){
		 for (int i=0; i<listeJoueur.size();i++){
			 listeJoueur.get(i).setDivinite(collectionCarteDivinite.get(0)); 
			 collectionCarteDivinite.remove(0); 
		}	
	}
	
	/**
	 * Distribue à chaque joueur 7 cartes Action.
	 * <p>Chaque carte distribuée est retirée du deck est placée dans la main du joueur correspondant.
	 * </p>
	 */
	public void distribuerCarte(){
		for (int i=0; i<listeJoueur.size(); i++){ 
			int nombre = listeJoueur.get(i).getMain().size();
			while(nombre < 7){ 
				listeJoueur.get(i).getMain().add(this.collectionCarte.get(0)); 
				collectionCarte.remove(0);
				nombre++;	
			}
		}
	}
	
	/**
	 * Retourne le deck de cartes.
	 * @return collectionCarte
	 */
	public ArrayList<Carte> getcollectionCarte(){
		return this.collectionCarte;
	}

	/**
	 * Retourne la liste de joueur.
	 * @return listeJoueur
	 */
	public ArrayList<Joueur> getListeJoueur(){
		return this.listeJoueur;
	}
	

	/**
	 * Retourne la liste de joueur selon l'ordre de jeu.
	 * @return tourJoueur
	 */
	public ArrayList<Joueur> getTourJoueur(){
		return this.tourJoueur;
	}
	
	}
