package com.tactfactory.monprojet.demo;

import java.util.Scanner;

import com.tactfactory.monprojet.entities.Echiquier;
  
public class DemoApplication {
     
     
     
    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        Echiquier echiquier = new Echiquier();
        System.out.println("Voulez vous demarrer une nouvelle partie ? (OUI)\n Charger une partie existante ?(CHARGER)");
        String rep = user_input.nextLine();
         
        if(rep.equals("OUI")){
            while (echiquier.getJeu()) {
                echiquier.grille();
                echiquier.deplacer();
 
            }
        }
 
 
    }
         
}