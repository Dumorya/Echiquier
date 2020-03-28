package com.tactfactory.monprojet.demo;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

import com.tactfactory.monprojet.entities.Cavalier;
import com.tactfactory.monprojet.entities.Fou;
import com.tactfactory.monprojet.entities.Piece;
import com.tactfactory.monprojet.entities.Pion;
import com.tactfactory.monprojet.entities.Position;
import com.tactfactory.monprojet.entities.Reine;
import com.tactfactory.monprojet.entities.Roi;
import com.tactfactory.monprojet.entities.Tour;

public class EchiquierTest {
	
	private Boolean jeu = false;
    private Piece[][] echiquier = new Piece[8][8];
    private int departLigne, departColonne, arriveeLigne, arriveColonne;
    private Boolean TourDuJoueur = false;
    private Boolean MouvementIncorrect = false;
    
    public void getJeu() {
    	assertNotNull(jeu);
    }
    
    @Test
	public void grille() {
    	assertNotNull(TourDuJoueur);
    	assertNotNull(echiquier);
    }
    
    @Test
    public void initialisationDeLaGrille() {
    	
    	assertNotNull(TourDuJoueur);
    	assertNotNull(echiquier);
    	
    	assertNotNull(new Tour(false));
    	assertNotNull(new Cavalier(false));
    	assertNotNull(new Fou(false));
    	assertNotNull(new Reine(false));
    	assertNotNull(new Roi(false));
    	assertNotNull(new Pion(false));
    	
    	assertNotNull(new Tour(true));
    	assertNotNull(new Cavalier(true));
    	assertNotNull(new Fou(true));
    	assertNotNull(new Reine(true));
    	assertNotNull(new Roi(true));
    	assertNotNull(new Pion(true));
    	
    }
    
    @Test
    public void mouvementValide() {
    	 
    	assertNotNull(departLigne);
    	assertNotNull(departColonne);
    	assertNotNull(arriveeLigne);
    	assertNotNull(arriveColonne);
    	assertNotNull(echiquier[departLigne][departColonne]);
    	assertNotNull(TourDuJoueur);
    	assertNotNull(new Cavalier(false));
    	assertNotNull(new Cavalier(true));
    	
    }
    
    @Test
    public void echec() {
        //Piece ROI;
    	assertNotNull(new ArrayList<Position>());
    	assertNotNull(TourDuJoueur);
    	assertNotNull(new Roi(false));
    }
    
    @Test
    public void deplacer() {
    	assertNotNull(MouvementIncorrect);
    	assertNotNull(TourDuJoueur);
    }
}
