package com.tactfactory.monprojet.entities;

public class Pion extends Piece {
	 
    private Piece[][] echequier = new Piece[8][8];
    
    /**
     * 
     * @param estBlanc
     */
    public Pion(boolean estBlanc) {
        super(estBlanc);
    }
 
    /**
     * 
     */
    public void dessiner() {
        System.out.print("6");
    }
 
    /**
     * 
     */
    public boolean deplacementValide(int departLigne, int departColonne, int arriveeligne,int arriveColonne) {
             
        if (this.estBlanc) {
            return (((departColonne == arriveColonne) && departLigne == (arriveeligne + 1))
                    || ((departLigne == 6) && (departColonne == arriveColonne) && (departLigne == (arriveeligne + 2)))
                    || ((departLigne == (arriveeligne + 1))
                            && (Math.abs(departColonne - arriveColonne) == 1)));
             
        }
        else {
            return (((departColonne == arriveColonne) && departLigne == (arriveeligne - 1))
                    || ((departLigne == 1) && (departColonne == arriveColonne) && (departLigne == (arriveeligne - 2)))
                    || ((departLigne == (arriveeligne - 1))
                            && (Math.abs(departColonne - arriveColonne) == 1)));
        }
        
    }
}
