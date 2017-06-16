package main.principal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EventListener;

import main.carte.*;
import windowbuilder.vue.FenetrePrincipale;
import windowbuilder.vue.FenetreSecondaire;

import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.event.EventListenerList;

public class Controller extends Observable{

	// Communication inter-interface
	
	// Echange entre interface et le jeu
	private int nombreJoueur=-1;
	private ArrayList<Carte> main;
	private Carte divinite;
	private boolean selectionnee = false;
	private boolean defausser = false;
	private boolean modeDefausser;
	private boolean modePoserCarte;
	private boolean poserCarte = false;
	private boolean sacrifierCarte = false;
	private int carteChoisie=-1;
	private boolean passerTour = true;
	private boolean utiliserDivinite = false;
	private boolean choixJoueur = false;
	private int choix [] ={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	private int choixCibleMultiple[] = { -1,-1,-1,-1,-1,-1};
	private int nbreDefaussage = 0;
	private boolean effetDivinite = false;
	private String image;
	private Carte [][] carteSuivie;
	private int ptsJour=0;
	private int ptsNuit=0;
	private int ptsNeant=0;
	private int[] nombrePriere= {0,0,0,0,0,0};
	private int resultatDe=-1;
	private int choixCible=-1;
	private boolean choisirCible = false;
	private boolean choisirCibleMultiple = false;
	private boolean choisirCibleBenef = false;
	private boolean choisirCibleGC = false;
	private boolean choixInfluence = false;
	
	private boolean animationCarte =false;
	
	private boolean doitPoserApocalypse = false;
	private boolean doitSacrifierGuide = false; // Doit sacrifier un guide dogme nature/symbole
	private boolean blocageSacrificeCroyantTour = false;
	private boolean doitSacrifierCroyant = false;
	
	private ArrayList<Carte> guidePossede;
	private ArrayList<Carte> croyantPossede;
	private ArrayList<Carte> table;
	
	private int action=-1;
	private ArrayList<Joueur> listeJoueur;
	private int reponse1=-1;
	private int reponse2=-1;
	private static String texte;
	private Thread a;
	private FenetreSecondaire triche;
	private FenetrePrincipale fenetrePrincipale;
	
	private static Controller instance;
	private Controller(){
		
	}
	

	
	public static Controller getInstance(){
		if (instance == null){
			instance = new Controller();
		}
		return instance;
	}
	
	public void setTexte(String s){
		this.setChanged();
		this.notifyObservers();
		
		triche.getTxt().setText(triche.getTxt().getText()+ "\n" +s);
	}

	
	
	public int getNombreJoueur() {
		return nombreJoueur;
	}
	public void setNombreJoueur(int nombreJoueur) {
		this.nombreJoueur = nombreJoueur;
	}
	public ArrayList<Carte> getMain() {
		return main;
	}
	public void setMain(ArrayList<Carte> main) {
		this.main = main;
	}
	public int getCarteChoisie() {
		return carteChoisie;
	}
	public void setCarteChoisie(int carteChoisie) {
		this.carteChoisie = carteChoisie;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public ArrayList<Joueur> getListeJoueur() {
		return listeJoueur;
	}
	public void setListeJoueur(ArrayList<Joueur> listeJoueur) {
		this.listeJoueur = listeJoueur;
	}

	public int getReponse1() {
		return reponse1;
	}
	public void setReponse1(int reponse1) {
		this.reponse1 = reponse1;
	}
	public int getReponse2() {
		return reponse2;
	}
	public void setReponse2(int reponse2) {
		this.reponse2 = reponse2;
	}

	public Thread getA() {
		return a;
	}
	public void setA(Thread a) {
		this.a = a;
	}

	public boolean isSelectionnee() {
		return selectionnee;
	}

	public void setSelectionnee(boolean selectionnee) {
		this.selectionnee = selectionnee;
	}

	public boolean isModeDefausser() {
		return modeDefausser;
	}

	public void setModeDefausser(boolean modeDefausser) {
		this.modeDefausser = modeDefausser;
	}

	public int[] getTabChoix(){
		return choix;
	}
	public int getChoix(int i) {
		return choix[i];
	}

	public void setChoix(int i, int j ) {
		this.choix[i]= j;
	}

	public int getNbreDefaussage() {
		return nbreDefaussage;
	}

	public void setNbreDefaussage(int nbreDefaussage) {
		this.nbreDefaussage = nbreDefaussage;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Carte getDivinite() {
		return divinite;
	}

	public void setDivinite(Carte divinite) {
		this.divinite = divinite;
	}

	public boolean isDefausser() {
		return defausser;
	}

	public void setDefausser(boolean defausser) {
		this.defausser = defausser;
	}

	public boolean isPoserCarte() {
		return poserCarte;
	}

	public void setPoserCarte(boolean poserCarte) {
		this.poserCarte = poserCarte;
	}

	public boolean isSacrifierCarte() {
		return sacrifierCarte;
	}

	public void setSacrifierCarte(boolean sacrifierCarte) {
		this.sacrifierCarte = sacrifierCarte;
	}

	public boolean isPasserTour() {
		return passerTour;
	}

	public void setPasserTour(boolean passerTour) {
		this.passerTour = passerTour;
	}

	public boolean isUtiliserDivinite() {
		return utiliserDivinite;
	}

	public void setUtiliserDivinite(boolean utiliserDivinite) {
		this.utiliserDivinite = utiliserDivinite;
	}

	public boolean isChoixJoueur() {
		return choixJoueur;
	}

	public void setChoixJoueur(boolean choixJoueur) {
		this.choixJoueur = choixJoueur;
	}

	public boolean isEffetDivinite() {
		return effetDivinite;
	}

	public void setEffetDivinite(boolean effetDivinite) {
		this.effetDivinite = effetDivinite;
	}

	public Carte getCarteSuivie( int guide, int croyant) {
		return this.carteSuivie[guide][croyant];
	}



	public void setCarteSuivie(int guide, int croyant, Carte carte) {
		this.carteSuivie[guide][croyant]=carte;
	}

	public Carte[][] getTabCarteSuivie(){
		return carteSuivie;
	}
	public int getLength(){
		return carteSuivie[0].length;
	}



	public ArrayList<Carte> getCroyantPossede() {
		return croyantPossede;
	}



	public void setCroyantPossede(ArrayList<Carte> croyantPossede) {
		this.croyantPossede = croyantPossede;
	}



	public ArrayList<Carte> getGuidePossede() {
		return guidePossede;
	}



	public void setGuidePossede(ArrayList<Carte> guidePossede) {
		this.guidePossede = guidePossede;
	}



	public int getPtsJour() {
		return ptsJour;
	}



	public void setPtsJour(int ptsJour) {
		this.ptsJour = ptsJour;
	}



	public int getPtsNeant() {
		return ptsNeant;
	}



	public void setPtsNeant(int ptsNeant) {
		this.ptsNeant = ptsNeant;
	}



	public int getPtsNuit() {
		return ptsNuit;
	}



	public void setPtsNuit(int ptsNuit) {
		this.ptsNuit = ptsNuit;
	}



	public int[] getNombrePriere() {
		return nombrePriere;
	}


	public int getResultatDe() {
		return resultatDe;
	}



	public void setResultatDe(int resultatDe) {
		this.resultatDe = resultatDe;
	}



	public ArrayList<Carte> getTable() {
		return table;
	}



	public void setTable(ArrayList<Carte> table) {
		this.table = table;
	}



	public int getChoixCible() {
		return choixCible;
	}



	public void setChoixCible(int choixCible) {
		this.choixCible = choixCible;
	}



	public boolean isChoisirCible() {
		return choisirCible;
	}



	public void setChoisirCible(boolean choisirCible) {
		this.choisirCible = choisirCible;
	}



	public boolean isDoitPoserApocalypse() {
		return doitPoserApocalypse;
	}



	public void setDoitPoserApocalypse(boolean doitPoserApocalypse) {
		this.doitPoserApocalypse = doitPoserApocalypse;
	}


	public boolean isDoitSacrifierGuide() {
		return doitSacrifierGuide;
	}



	public void setDoitSacrifierGuide(boolean doitSacrifierGuide) {
		this.doitSacrifierGuide = doitSacrifierGuide;
	}



	public void setFenetre(FenetreSecondaire triche) {
		this.triche = triche;
		
	}
	
	public FenetreSecondaire getFenetre(){
		return triche;
	}



	public boolean isBlocageSacrificeCroyantTour() {
		return blocageSacrificeCroyantTour;
	}



	public void setBlocageSacrificeCroyantTour(boolean blocageSacrificeCroyantTour) {
		this.blocageSacrificeCroyantTour = blocageSacrificeCroyantTour;
	}



	public boolean isChoisirCibleBenef() {
		return choisirCibleBenef;
	}



	public void setChoisirCibleBenef(boolean choisirCibleBenef) {
		this.choisirCibleBenef = choisirCibleBenef;
	}



	public int[] getChoixCibleMultiple() {
		return choixCibleMultiple;
	}



	public void setChoixCibleMultiple(int indice, int valeur) {
		this.choixCibleMultiple[indice] = valeur;
	}



	public boolean isChoisirCibleMultiple() {
		return choisirCibleMultiple;
	}



	public void setChoisirCibleMultiple(boolean choisirCibleMultiple) {
		this.choisirCibleMultiple = choisirCibleMultiple;
	}



	public boolean isChoisirCibleGC() {
		return choisirCibleGC;
	}



	public void setChoisirCibleGC(boolean choisirCibleGC) {
		this.choisirCibleGC = choisirCibleGC;
	}



	public boolean isChoixInfluence() {
		return choixInfluence;
	}



	public void setChoixInfluence(boolean choixInfluence) {
		this.choixInfluence = choixInfluence;
	}



	public FenetrePrincipale getFenetrePrincipale() {
		return fenetrePrincipale;
	}



	public void setFenetrePrincipale(FenetrePrincipale fenetrePrincipale) {
		this.fenetrePrincipale = fenetrePrincipale;
	}

	public void setPtsActionJour(int s){
		fenetrePrincipale.getPtsActionJour().setText(Integer.toString(s));
	}
	
	public void setPtsActionNuit(int s){
		fenetrePrincipale.getPtsActionNuit().setText(Integer.toString(s));
	}
	
	public void setPtsActionNeant(int s){
		fenetrePrincipale.getPtsActionNeant().setText(Integer.toString(s));
	}
	
	public void setNombrePriere(int joueur, int s){
		fenetrePrincipale.getGuide().get(joueur).setText(Integer.toString(s));
	}
	
	
	public void setCarteMain(ArrayList<Carte> carte){
		for (int i=0; i<fenetrePrincipale.getCarteMain().size();i++){
			if (i>=0 && i<carte.size()){
				fenetrePrincipale.getCarteMain().get(i).setIcon(new ImageIcon(FenetrePrincipale.class.getResource(carte.get(i).getImage())));
				fenetrePrincipale.getCarteMain().get(i).setVisible(true);
			}
			else{
				fenetrePrincipale.getCarteMain().get(i).setVisible(false);
			}
		}
	}
	
	
	public void setListePlateau(ArrayList<Carte> carte){
		
		for (int i=0;i<fenetrePrincipale.getCartePlateau().size();i++){
			if ( (i>=0 && i<carte.size())){
				fenetrePrincipale.getCartePlateau().get(i).setIcon(new ImageIcon(FenetrePrincipale.class.getResource(carte.get(i).getImage())));
				fenetrePrincipale.getCartePlateau().get(i).setVisible(true);
			}
			else{
				fenetrePrincipale.getCartePlateau().get(i).setVisible(false);
			}
		}
	}
		
	public void setInfluence(int s ){

		if (s>=0 && s<1){
			fenetrePrincipale.getInfluence().setIcon(new ImageIcon(FenetrePrincipale.class.getResource("/windowbuilder/ressources/jour1.png")));
		}
		else if(s>=1 && s<2){
			fenetrePrincipale.getInfluence().setIcon(new ImageIcon(FenetrePrincipale.class.getResource("/windowbuilder/ressources/nuit1.png")));
		}
		else if(s>=2 && s<3){
			fenetrePrincipale.getInfluence().setIcon(new ImageIcon(FenetrePrincipale.class.getResource("/windowbuilder/ressources/neant1.png")));
		}
	}



	public boolean isModePoserCarte() {
		return modePoserCarte;
	}



	public void setModePoserCarte(boolean modePoserCarte) {
		this.modePoserCarte = modePoserCarte;
	}



	public boolean isAnimationCarte() {
		return animationCarte;
	}



	public void setAnimationCarte( int nbreCartePlateau) {
		fenetrePrincipale.animationCarte(nbreCartePlateau-1);
	}



	public boolean isDoitSacrifierCroyant() {
		return doitSacrifierCroyant;
	}



	public void setDoitSacrifierCroyant(boolean doitSacrifierCroyant) {
		this.doitSacrifierCroyant = doitSacrifierCroyant;
	}


}
