package com.tactfactory.monprojet.entities;

public class Cavalier extends Piece {
	 
    public Cavalier(boolean estBlanc) {
        super(estBlanc);
            }
 
     
    public void dessiner() {
    	System.out.print("4");
    }
     
    private static Boolean chemin(int departLigne, int departColonne,int arriveeligne, int arriveColonne){
        return ((Math.abs(departLigne - arriveeligne) == 2 && Math.abs(departColonne- arriveColonne) == 1)
                || (Math.abs(departLigne - arriveeligne) == 1 && Math.abs(departColonne- arriveColonne) == 2));
    }
 
     
    public boolean deplacementValide(int departLigne, int departColonne, int arriveeligne, int arriveColonne) {
        return chemin(departLigne, departColonne, arriveeligne, arriveColonne);
    }
 
 
}