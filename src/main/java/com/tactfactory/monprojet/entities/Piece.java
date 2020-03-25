package com.tactfactory.monprojet.entities;

public abstract class Piece {
 
    boolean estBlanc;
    
    /**
     * 
     * @param estBlanc
     */
    public Piece(boolean estBlanc) {
        this.estBlanc = estBlanc;
    }
    
    /**
     * 
     * @return
     */
    public boolean estBlanc() {
        return estBlanc;
    }
    
    public abstract void dessiner();
    public abstract boolean deplacementValide(int departLigne, int departColonne, int arriveeligne, int arriveColonne);
}
