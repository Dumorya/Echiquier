package com.tactfactory.monprojet.entities;

import java.util.ArrayList;
import java.util.Hashtable;

public abstract class PositionInitiale {
	Hashtable positions;
	int ligneTetes;
	int lignePions;
	
	@SuppressWarnings("unchecked")
	public PositionInitiale() {
		this.positions = new Hashtable();
		
		this.positions.put("reine", 3);
		
		this.positions.put("roi", 4);
		
		ArrayList<Integer> positions = new ArrayList<Integer>();
		positions.add(1);
		positions.add(6);
		this.positions.put("cavalier", positions);
		
		positions = new ArrayList<Integer>();
		positions.add(2);
		positions.add(5);
		this.positions.put("fou", positions);
		
		positions = new ArrayList<Integer>();
		positions.add(0);
		positions.add(7);
		this.positions.put("tour", positions);
		
		positions = new ArrayList<Integer>();
		positions.add(0);
		positions.add(1);
		positions.add(2);
		positions.add(3);
		positions.add(4);
		positions.add(5);
		positions.add(6);
		positions.add(7);
		this.positions.put("pion", positions);
	}

	public void setLigneTetes(int ligneTetes) {
		this.ligneTetes = ligneTetes;
	}

	public void setLignePions(int lignePions) {
		this.lignePions = lignePions;
	}

	public int getLigneTetes() {
		return ligneTetes;
	}

	public int getLignePions() {
		return lignePions;
	}

	public Integer getColonneReine() {
		return (Integer) this.positions.get("reine");
	}
	
	public Integer getColonneRoi() {
		return (Integer) this.positions.get("roi");
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Integer> getColonneCavalier() {
		return (ArrayList<Integer>) this.positions.get("cavalier");
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Integer> getColonneFou() {
		return (ArrayList<Integer>) this.positions.get("fou");
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Integer> getColonneTour() {
		return (ArrayList<Integer>) this.positions.get("tour");
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Integer> getColonnePion() {
		return (ArrayList<Integer>) this.positions.get("pion");
	}
}
