
public class Bataille {
	//String[] listeCouleur={"carreau","coeur","pique","trefle"};
	//int[] listeChiffre={1,2,3,4,5,6,7,8,9,10};
	
	public static void main(String[] args){
		Joueur player1 = new Joueur("Paul");
		Joueur player2 = new Joueur("Jean");
		int nbrDeCartes=10;
		// On choisit de commencer avec un paquet de 10 cartes pour simuler rapidement
		//initialise des cartes aleatoirement
		player1.initialisePaquetRandom(nbrDeCartes); 
		player2.initialisePaquetRandom(nbrDeCartes); 
		//player1.affichePaquet();
		player1.melangerPaquet(); //remélange le paquet du joueur
		player2.melangerPaquet();
		//player1.affichePaquet();
		jouerPartie(player1, player2);
		
	}
	
	
	public static void jouerPartie(Joueur player1, Joueur player2){
		System.out.println("La partie commence");
		while(!player1.paquetVide() || !player2.paquetVide()){
			
			Carte carteP1 = player1.retireCarte();
			Carte carteP2 = player2.retireCarte();
			
			System.out.println(player1.getNom()+" tire "+ carteP1.toString());
			System.out.println(player2.getNom()+" tire "+ carteP2.toString());
			
			if(carteP1.comparer(carteP1, carteP2)){
				augmenterPoints(player1);
			}
			else{
				
				if(carteP1.isEgalite(carteP2)){
					System.out.println("Egalité, personne ne gagne le point");
				}
				else{
					augmenterPoints(player2);
				}
			}
					
		}
		System.out.println("La partie se termine");
		afficheWinnerLooser(player1,player2);
	}
	
	public static void augmenterPoints(Joueur joueur){
		joueur.augmenterPoints();
		System.out.println("Le joueur "+joueur.getNom()+" gagne le duel, son score monte à "+joueur.getPoints());
	}
	
	public static void afficheWinnerLooser(Joueur player1, Joueur player2) {
		if(player1.getPoints()>player2.getPoints()){
			System.out.println("Le joueur "+player1.getNom()+" ("+player1.getPoints()+" points) est le gagnant de la partie !!!");
			System.out.println("Le joueur "+player2.getNom()+" ("+player2.getPoints()+" points) est le perdant de la partie ...");
		}
		if(player1.getPoints()<player2.getPoints()){
			System.out.println("Le joueur "+player2.getNom()+" ("+player2.getPoints()+" points) est le Gagnant de la partie !!!");
			System.out.println("Le joueur "+player1.getNom()+" ("+player1.getPoints()+" points) est le Perdant de la partie ...");
		}
		if(player1.getPoints()==player2.getPoints()){
			System.out.println("Les joueurs "+player1.getNom()+" et "+player2.getNom()+ " ont fini la partie à Egalité");
		}
	}
	
}

