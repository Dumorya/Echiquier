package com.tactfactory.monprojet.entities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
 
public class Echiquier {
 
	private Boolean jeu;
    private Piece[][] echiquier = new Piece[8][8];
    Scanner user_input = new Scanner(System.in);
    private static int departLigne, departColonne, arriveeLigne, arriveColonne;
    private static Boolean TourDuJoueur;
    // Définit sur true si movement est invalide. Demande de nouveau l'utilisateur dans move ()
    // méthode.
    private static Boolean MouvementIncorrect = false;
    // Contient une chaîne avec l'entrée de l'utilisateur pour les instructions déplacement
    String mouvement;
    Cote coteBlanc;
    Cote coteNoir;
 
    /**
     * initialisation de la grille
     */
    public Echiquier() {
        jeu = true;
        
        // Affecte aléatoirement qui commence en premier (noir ou blanc)
        Random rand = new Random();
        TourDuJoueur = rand.nextBoolean();
        
        this.coteBlanc = new Cote(true);
        this.coteNoir = new Cote(false);
        echiquier = this.coteBlanc.setEchiquier(echiquier);
        echiquier = this.coteNoir.setEchiquier(echiquier);
    }
 
    /**
     * 
     * @return
     */
    public Boolean getJeu() {
        return this.jeu;
    }
 
    /**
     * 
     */
    public void grille() {
         
    	// si le joueur est blanc
    	//if(TourDuJoueur){
    		
    		System.out.println("\tA\tB\tC\tD\tE\tF\tG\tH");
            System.out.println("------------------------------------------------------------------");
            for (int ligne = 0 ; ligne < echiquier.length ; ligne++) {
                System.out.print(8 - ligne + "|\t");
                
                for (int colonne = 0 ; colonne < echiquier[ligne].length ; colonne++) {
                    if (echiquier[ligne][colonne] != null) {
                        echiquier[ligne][colonne].dessiner();
                        System.out.print("\t");
                    } else {
                        System.out.print("\t"); 
                    }
                }
                System.out.println();
            }
            System.out.println("------------------------------------------------------------------");
            
    	/*} else{
    		
            System.out.println("------------------------------------------------------------------");
            for (int ligne = 0 ; ligne < echiquier.length ; ligne++) {
                System.out.println();
                for (int colonne = 0 ; colonne < echiquier[ligne].length ; colonne++) {
                    if (echiquier[ligne][colonne] != null) {
                        echiquier[ligne][colonne].dessiner();
                        System.out.print("\t");
                    }
                    else {
                        System.out.print("\t");
                             
                    }
                }
                System.out.print(8 - ligne + "|\t");
            }
            System.out.println();
            System.out.println("------------------------------------------------------------------");
            System.out.println("A\tB\tC\tD\tE\tF\tG\tH");
    	}*/
    }
 
    /**
     * 
     * @param Echec
     * @return
     */
    private boolean mouvementValide(boolean Echec) {
 
        // On verifie que le chemin ne sort pas de l'échiquier
        if (departLigne < 0 || departLigne > 7 || departColonne < 0 || departColonne > 7 || arriveeLigne < 0 || arriveeLigne > 7 || arriveeLigne < 0 || arriveColonne > 7) {
            System.out.println("Le mouvement est en dehors de l'echiquier");
            return false;
        }
 
        // On vérifie que l'origine n'est pas null
        if (echiquier[departLigne][departColonne] == null) {
            System.err.println("L'origine est vide");
            return false;
        }
 
        // On verifie que c'est bien le tour du joueur pour qu'il joue
        if ((echiquier[departLigne][departColonne].estBlanc && !TourDuJoueur) || (!echiquier[departLigne][departColonne].estBlanc && TourDuJoueur)) {
            if(Echec == false) {
                System.err.println("Ce n'est pas votre tour");
            }
            return false;
        }
 
        // On verifie que les déplacements spécifiques de la pièce sont bien respectés
        if (!echiquier[departLigne][departColonne].deplacementValide(departLigne, departColonne, arriveeLigne,arriveColonne)) {
            if(Echec == false) {
                System.err.println("Cette pièce ne bouge pas comme ça");
            }
            return false;
        }
 
        // cette déclaration arrête la déclaration pour vérifier si le blanc atterit
        // blanc de l'execution estBlanc() sur un espace null
        if (echiquier[arriveeLigne][arriveColonne] == null) {          
            //Chemin pas possible si une piece veut sauter une autre piece SAUF POUR LE CAVALIER
            if(!(echiquier[departLigne][departColonne] instanceof Cavalier)) {
                int deplaceX = 0;
                int deplaceY = 0;
                
                if(departLigne < arriveeLigne) {
                	deplaceX = 1;
                } else if (departLigne > arriveeLigne) {
                	deplaceX = -1;
                }
                
                if(departColonne < arriveColonne) {
                	deplaceY = 1;
                } else if (departColonne > arriveColonne) {
                	deplaceY = -1;
                }
 
                int i = departLigne; 
                int j = departColonne;
                
                while(i != arriveeLigne || j != arriveColonne) {
                	
                    if(i != arriveeLigne) {
                    	i += deplaceX;
                	}
                    
                    if(j != arriveColonne) {
                		j += deplaceY;
                	}
 
                    if(echiquier[i][j] != null) {
                        System.err.println("Cette piece ne peut pas sauter un pion");
                        return false;
                    }
                }
            }
            return true;
        }
         
        if(echiquier[departLigne][departColonne] instanceof Pion && (arriveeLigne == arriveColonne) && this.echiquier[arriveeLigne][arriveColonne] == null ) {
            System.out.println("Ne peut pas se deplacer en diagonale");
            return false;
        }
 
        // On verifie que un pion Blanc ne veut pas se poser sur un autre pion Blanc
        if (echiquier[departLigne][departColonne].estBlanc && echiquier[arriveeLigne][arriveColonne].estBlanc) {
            System.err.println("Les blancs ne peuvent pas atterrir sur le blanc");
            return false;
        }
 
        // On verifie que un pion Noir ne veut pas se poser sur un autre pion Noir
        if (!echiquier[departLigne][departColonne].estBlanc && !echiquier[arriveeLigne][arriveColonne].estBlanc) {
            System.err.println("Le noir ne peut pas atterrir sur le noir");
            return false;
        }
         
        return true;
    }
 
    /**
     * 
     * @return
     */
    public boolean echec() {
        //Piece ROI;
        ArrayList<Position> positions = new ArrayList<Position>();
        boolean joueur_adverse = TourDuJoueur;
        boolean joueur_courant = !TourDuJoueur;
        
        //On recherche la position du ROI
        for(int ligne = 0 ; ligne < 8 ; ligne++) {
            for(int colonne = 0; colonne < 8; colonne++) {
                if(this.echiquier[ligne][colonne] != null  && this.echiquier[ligne][colonne].estBlanc == TourDuJoueur && this.echiquier[ligne][colonne] instanceof Roi){
                    arriveeLigne = ligne;
                    arriveColonne = colonne;  
                }
            }
        }
        
        for(int ligne = 0 ; ligne < 8 ; ligne++) {
            for(int colonne = 0 ; colonne < 8 ; colonne++) {
                    if(this.echiquier[ligne][colonne] != null && this.echiquier[ligne][colonne].estBlanc == !TourDuJoueur)
                    {
                        departLigne = ligne;
                        departColonne = colonne;
                         
                        if(mouvementValide(true)){
                        	positions.add(new Position(departLigne, departColonne, arriveeLigne, arriveColonne));
                            System.out.println(departLigne + "" + departColonne);
                        }
                    }      
            }
        }
        
        if(positions.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
 
 
    /**
     * 
     */
    public void deplacer() {
    	
        if (MouvementIncorrect) {
            System.err.println("Le mouvement n'est pas valide. Veuillez r�essayer :");
            MouvementIncorrect = false;
        } else if (TourDuJoueur) {
            System.out.println( "\nLe joueur BLANC doit jouer\n");
        } else {
            System.out.println("\nLe joueur NOIR doit jouer\n");
        }
 
        mouvement = user_input.nextLine();
 
        // convertir en minuscules
        String lowerCase = mouvement.toLowerCase();
        // analyse la cha�ne de déplacement en composants
        String[] components = lowerCase.split(" ");
 
        // si vous supposez que le déplacement est "e1 e5" alors
        // composants [0] .chartAt (0) = 'e'
        // composants [0] .charAt (1) = '1'
 
        // utilisez des chars dans les composants pour définir les coordonnées du tableau
        // deplace l'origine et deplace la destination
 
        departLigne = 7 - (components[0].charAt(1) - '1');
        departColonne = components[0].charAt(0) - 'a';
        arriveeLigne = 7 - (components[1].charAt(1) - '1');
        arriveColonne = components[1].charAt(0) - 'a';
 
        if (mouvementValide(false)) {
            // mettre une pi�ce dans la destination
            echiquier[arriveeLigne][arriveColonne] = echiquier[departLigne][departColonne];
            // vide l'origine du mouvement
            echiquier[departLigne][departColonne] = null;
            if(echec() == true)
            {System.out.println("\n ECHEC !\n");}
            TourDuJoueur = !TourDuJoueur;
        } else {
            MouvementIncorrect = true;
            mouvementValide(false);
            if(echec() == true){
            	System.out.println("\n ECHEC !\n");
            }
        }
    }
 
}
