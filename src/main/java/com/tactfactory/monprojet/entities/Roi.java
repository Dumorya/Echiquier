package com.tactfactory.monprojet.entities;

public class Roi extends Piece {
	 
	/**
	 * 
	 * @param estBlanc
	 */
    public Roi(boolean estBlanc) {
        super(estBlanc);
         
    }
 
    /**
     *  
     */
    public void dessiner() {
         System.out.print("1");
    }
 
    /**
     *  
     */
    public boolean deplacementValide(int departLigne, int departColonne, int arriveeligne,int arriveColonne) {
        return Math.abs(arriveeligne - departLigne) <= 1|| Math.abs(arriveColonne - departColonne) <= 1;
    }
}