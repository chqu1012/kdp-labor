package de.dc.hska.mdp.labor.model;

public class Letter extends Node {

	public Letter(char letter) {
		this.letter = letter;
		setType(Type.LETTER);
		isEmpty=false;
	}
	
	public boolean contains(char w) {
		if (letter==w)
			return isEmpty=true;
		else
			return isEmpty=false;
	}
	
	@Override
	public String toString() {
		return letter+"";
	}

	@Override
	public boolean isEmpty() {
		return isEmpty;
	}
}
