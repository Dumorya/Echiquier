package com.tactfactory.monprojet.entities;

import java.util.ArrayList;

public class Cote {
	
	boolean estBlanc;
	PositionInitiale positionInitiale;
	
	public Cote(boolean estBlanc) {
		this.estBlanc = estBlanc;
		
		if(this.estBlanc) {
			this.positionInitiale = new PositionInitBlanc();
		} else {
			this.positionInitiale = new PositionInitNoir();
		}
	}
	
	
	public Piece[][] setEchiquier(Piece[][] echiquier) {
		
		//reine
		echiquier[this.positionInitiale.getLigneTetes()][this.positionInitiale.getColonneReine()] = new Reine(this.estBlanc);
		
		// roi
		echiquier[this.positionInitiale.getLigneTetes()][this.positionInitiale.getColonneRoi()] = new Roi(this.estBlanc);

		// cavaliers
		ArrayList<Integer> colonnesCavalier = this.positionInitiale.getColonneCavalier();
		for(Integer colonneCavalier : colonnesCavalier) {
			echiquier[this.positionInitiale.getLigneTetes()][colonneCavalier] = new Cavalier(this.estBlanc);
		}
		
		// Tours
		ArrayList<Integer> colonnesTour = this.positionInitiale.getColonneTour();
		for(Integer colonneTour : colonnesTour) {
			echiquier[this.positionInitiale.getLigneTetes()][colonneTour] = new Tour(this.estBlanc);
		}
		
		// fous
		ArrayList<Integer> colonnesFou = this.positionInitiale.getColonneFou();
		for(Integer colonneFou : colonnesFou) {
			echiquier[this.positionInitiale.getLigneTetes()][colonneFou] = new Fou(this.estBlanc);
		}
		
		// pions
		ArrayList<Integer> colonnesPion = this.positionInitiale.getColonnePion();
		for(Integer colonnePion : colonnesPion) {
			echiquier[this.positionInitiale.getLignePions()][colonnePion] = new Pion(this.estBlanc);
		}
		
		return echiquier;
	}
	
}
