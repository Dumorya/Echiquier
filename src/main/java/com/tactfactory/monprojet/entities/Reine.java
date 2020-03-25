package com.tactfactory.monprojet.entities;

public class Reine extends Piece {
	 
    public Reine(boolean estBlanc) {
        super(estBlanc);
         
        }
 
    public void dessiner() {
        System.out.print("2");
    }
 
    private static Boolean cheminDiagonal(int departLigne, int departColonne, int arriveeligne,int arriveColonne) {
        return ((Math.abs(departLigne - arriveeligne) == Math.abs(departColonne - arriveColonne)));
    }
 
    private static Boolean chemin(int departLigne, int departColonne, int arriveeligne,int arriveColonne) {
        return !((departLigne != arriveeligne) && (departColonne != arriveColonne));
    }
 
 
    public boolean deplacementValide(int departLigne, int departColonne, int arriveeligne,int arriveColonne) {
        return (cheminDiagonal(departLigne, departColonne, arriveeligne, arriveColonne))
                || chemin(departLigne, departColonne, arriveeligne, arriveColonne);
    }
}