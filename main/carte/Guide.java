package main.carte;
import java.util.*;

public class Guide extends Carte{
	
	protected ArrayList<Carte> guidePossede;
	protected ArrayList<Carte> croyantPossede;
	protected int croyantRecuperable , nombreCroyant;
	
	public Guide(){
		super();
		croyantRecuperable = 0;
		nombreCroyant =0; // Nombre de croyant qui suivent un guide
		
		
	}

	public Guide(String string, int i, int j, int k, int l, int m, int n, String image) {
		super ( string , i , j , k, l,m, image);
		croyantRecuperable = n;
		nombreCroyant=0 ;
	}
	
	public int getCroyantRecuperable(){
		return croyantRecuperable;
	}
	
	public int getNombreCroyant(){
		return nombreCroyant;
	}
	
	public int setNombreCroyant(int pnbre){
		 return nombreCroyant = pnbre;
	}
}
