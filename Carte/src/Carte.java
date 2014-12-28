
public class Carte {
	
	private String couleur;
	private int valeur;
	
	public Carte(String coul, int val){
		this.couleur=coul;
		this.valeur=val;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public boolean comparer(Carte c1, Carte c2){
		int v1=c1.getValeur();
		int v2=c2.getValeur();
		if(v1>v2){
		    return true;
		}
		return false;
	}
	
	public boolean isEgalite(Carte c2){
		if(this.getValeur()==c2.getValeur()){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String toString(){
		return this.couleur+" "+this.valeur;
	
	}
	
}
