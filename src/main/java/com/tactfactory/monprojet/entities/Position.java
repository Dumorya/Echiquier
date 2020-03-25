package com.tactfactory.monprojet.entities;

public class Position {
    private int departLigne;
    private int departColonne;
    private int arriveeligne;
    private int arriveeColonne;
 
    /**
     * 
     * @param departLigne
     * @param departColonne
     * @param arriveeligne
     * @param arriveeColonne
     */
    public Position(int departLigne, int departColonne, int arriveeligne, int arriveeColonne) {
        this.departLigne = departLigne;
        this.departColonne = departColonne;
        this.arriveeligne = arriveeligne;
        this.arriveeColonne = arriveeColonne;
    }
 
    /**
     * 
     * @return
     */
    public int getdepartLigne() {
        return departLigne;
    }
 
    /**
     * 
     * @return
     */
    public int getdepartColonne() {
        return departColonne;
    }
     
    /**
     * 
     * @return
     */
    public int getarriveeligne() {
        return arriveeligne;
    }
 
    /**
     * 
     * @return
     */
    public int getarriveeColonne() {
        return arriveeColonne;
    }
 
    /**
     * 
     * @param departLigne
     */
    public void setdepartLigne(int departLigne) {
        this.departLigne = departLigne;
    }
 
    /**
     * 
     * @param departColonne
     */
    public void setdepartColonne(int departColonne) {
        this.departColonne = departColonne;
    }
     
    /**
     * 
     * @param arriveeligne
     */
    public void setarriveeligne(int arriveeligne) {
        this.arriveeligne = arriveeligne;
    }
 
    /**
     * 
     * @param arriveeColonne
     */
    public void setarriveeColonne(int arriveeColonne) {
        this.arriveeColonne = arriveeColonne;
    }
 
    /**
     * 
     * @param position
     * @return
     */
    public boolean equals(Position position) {
        return position.getdepartLigne() == this.getdepartLigne()
                && position.getdepartColonne() == this.getdepartColonne()
                && position.getarriveeligne() == this.getarriveeligne()
                && position.getarriveeColonne() == this.getdepartColonne();
    }
}