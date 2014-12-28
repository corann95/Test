import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Random;


public class Joueur {
	private int points;
	private ArrayList<Carte> arrayCartes;
	private String nom;
	
	public Joueur(String nom){
		this.points=0;
		this.nom=nom;
		this.arrayCartes= new ArrayList<Carte>();
		
	}
	
	public String getNom(){
		return this.nom;
	}
	public int getPoints(){
		return this.points;
	}
	public void augmenterPoints(){
		this.points++;
	}
	
	public void ajoutCarte(Carte c){		
		this.arrayCartes.add(c);
	}
	
	public Carte retireCarte(){ // retire le dernier élément de la liste car correspond au dessus du paquet
		int dernier= this.arrayCartes.size()-1;
		Carte CarteTiree = this.arrayCartes.get(dernier);
		this.arrayCartes.remove(dernier);
		return CarteTiree;
	}
	
	public void affichePaquet(){
		System.out.println("-------------");
		for(Carte elem: this.arrayCartes)
	       {
	       	 System.out.println (elem);   
	       }
		System.out.println("-------------");
	}
	
	public void melangerPaquet(){
		Collections.shuffle(this.arrayCartes);
	}
	
	public void initialisePaquetRandom(int nombreDeCartes){
		 ArrayList<Carte> cartesRandom = new ArrayList<Carte>();
		 
		 for (int i=1; i<=nombreDeCartes; i++){
			cartesRandom.add(createCarteRandom());
		 }
		 
		this.arrayCartes=cartesRandom;
	}
	
	public Carte createCarteRandom(){
		String[] listeCouleur={"carreau","coeur","pique","trefle"};
		int[] listeChiffre={1,2,3,4,5,6,7,8,9,10};
		
		// sélectionne au hasard un indice dans le tableau correspondant
		Random randomColor = new Random();
		int IdColor = randomColor.nextInt(listeCouleur.length);
		Random randomChiffre = new Random();
		int IdChiffre=randomChiffre.nextInt(listeChiffre.length);
		
		// selectionne la valeur correspondante à l'indice
		String couleurChoisi = listeCouleur[IdColor];
		int chiffreChoisi = listeChiffre[IdChiffre];
		
		Carte carteCreated= new Carte(couleurChoisi,chiffreChoisi);
		return carteCreated;
	}
	
	public boolean paquetVide(){
		if(this.arrayCartes.size() !=0)
		{
		  return false;
		}
		else
		{
		  return true;
		}
		
	}
	
}
