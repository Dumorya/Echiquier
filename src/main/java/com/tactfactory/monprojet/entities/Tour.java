package com.tactfactory.monprojet.entities;

public class Tour extends Piece {
	 
    public Tour(boolean estBlanc) {
        super(estBlanc);
    }
 
    public void dessiner() {
        System.out.print("5");  
    }
     
    private static Boolean chemin(int departLigne, int departColonne,int arriveeligne, int arriveColonne) {
        return !((departLigne != arriveeligne) && (departColonne != arriveColonne));
    }
 
    public boolean deplacementValide(int departLigne, int departColonne, int arriveeligne, int arriveColonne) {
        return chemin(departLigne, departColonne, arriveeligne, arriveColonne);
    }
}
