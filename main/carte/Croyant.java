package main.carte;

public class Croyant extends Carte {

	
	protected int croyantDisponible;
	
	
	public Croyant(){
		super();
		croyantDisponible =0;
		
	}

	public Croyant(String string, int i, int j, int k, int l, int m, int n, String image) {
		super( string, i , j , k , l , m , image);
		croyantDisponible =n;
		
		// TODO Auto-generated constructor stub
	}
	
	public int getCroyantDisponible(){
		return croyantDisponible;
	}
	
}
