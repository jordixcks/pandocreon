package main.carte;
import main.principal.*;
import main.effet.*;

public class Carte extends Joueur{
	protected int identifiantCarte;
	protected int origineCarte;
	protected int natureCarte1, natureCarte2, natureCarte3;
	protected String nom;
	protected boolean carteProtege = false; // Empêche la carte d'être détruire
	protected boolean CapaciteSpe = true; // Autorise ou pas la carte à avoir une capacité spéciale
	protected boolean Selectionnee = false; // Indique si une carte est selectionnée ou pas
	protected String image;
	
	protected boolean doitEtrePose = false;
	protected boolean estProtege = false;
	private boolean effetAnnule = false;
	
	// 0:aucun, 1:nature , 2: chaos , 3: symboles , 4: mystique, 5: humain
	// 0: aucune, 1: jour , 2: néant, 3: nuit 4: aube 5: crépuscule 
	


	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	// Constructeur par défaut
	public Carte(){
		identifiantCarte=0;
		origineCarte=0;
		natureCarte1=0;
		natureCarte2=0;
		natureCarte3=0;
		nom="";
		CapaciteSpe = true;
		
		
		
		
	}

	// Constructeur de la classe Carte
	public Carte(String pnom, int pid, int porigine, int pdogme1 , int pdogme2, int pdogme3, String pimage){
		this.nom = pnom;
		this.identifiantCarte = pid;
		this.origineCarte = porigine;
		this.natureCarte1 = pdogme1;
		this.natureCarte2 = pdogme2;
		this.natureCarte3 = pdogme3;
		this.image = pimage;
	}
	
	// Instance de comportement
	private Effet effet;
	
	// Constructeur avec paramètres
	public Carte (Effet effet){
		this.setEffet(effet);
	}
	
	// Redifinit le comportement
	public void setEffet( Effet effet){
		this.effet = effet;
	}
	
	public String getInfosCarte(){
		return "Nom: " +this.nom+ " \n Origine: "+this.origineCarte+ " \n Dogme1: " +this.natureCarte1+ "\n Dogme2: "+this.natureCarte2+"\n Dogme3: "+this.natureCarte3;
	}
	
	
	//Creation d'un getter pour récuperer l'identifiant
	public int getIdentifiantCarte() {
		return identifiantCarte;
	}

	// Création d'un setter pour changer l'identifiant
	public void setIdentifiantCarte(int id){
			identifiantCarte = id;
	}
	
	public int getNatureCarte1(){ 
		return natureCarte1;
	}
	public int getNatureCarte2(){ 
		return natureCarte2;
	}
	public int getNatureCarte3(){ 
		return natureCarte3;
	}
	// Création d'un setter pour changer les infos de la carte
	public void setNatureCarte1( int valeur){
			natureCarte1=valeur;
	}
	
	public void setNatureCarte2( int valeur){
		natureCarte2=valeur;
}
	
	public void setNatureCarte3( int valeur){
		natureCarte3=valeur;
}
	
	public int getOrigineCarte(){
		return origineCarte;
	}
	
	public String getNomCarte(){
		return nom;
	}
	
	public void setOrigineCarte (int id){
			origineCarte=id;
	}

	public Effet getEffet() {
		return effet;
	}

	public boolean isSelectionnee() {
		return Selectionnee;
	}

	public void setSelectionnee(boolean selectionnee) {
		Selectionnee = selectionnee;
	}

	public boolean isDoitEtrePose() {
		return doitEtrePose;
	}

	public void setDoitEtrePose(boolean doitEtrePose) {
		this.doitEtrePose = doitEtrePose;
	}

	public boolean isEstProtege() {
		return estProtege;
	}

	public void setEstProtege(boolean estProtege) {
		this.estProtege = estProtege;
	}

	public boolean isEffetAnnule() {
		return effetAnnule;
	}

	public void setEffetAnnule(boolean effetAnnule) {
		this.effetAnnule = effetAnnule;
	}
	
	
}
