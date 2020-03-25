package com.tactfactory.monprojet.entities;

public class Fou extends Piece {
	
	/**
	 * 
	 * @param estBlanc
	 */
    public Fou(boolean estBlanc) {
        super(estBlanc);
    }
 

    /**
     * 
     */
    public void dessiner() {
        System.out.print("3");
    }
 
    /**
     * 
     * @param departLigne
     * @param departColonne
     * @param arriveeligne
     * @param arriveColonne
     * @return
     */
    private static Boolean chemin(int departLigne, int departColonne, int arriveeligne,int arriveColonne) {
        return ((Math.abs(departLigne - arriveeligne) == Math.abs(departColonne
                -  arriveColonne)));
    }
 
    /**
     *  
     */
    public boolean deplacementValide(int departLigne, int departColonne, int arriveeligne,int arriveColonne) {
        return chemin(departLigne, departColonne, arriveeligne, arriveColonne);
    }
 
    /**
     *  
     * @return
     */
    public int ValeurRelative() {
        return 3;
    }
 
}