package de.dc.hska.mdp.labor.model;

public class EmptyWord extends Node {

	public EmptyWord() {
		setType(Type.EMPTY_WORD);
	}
	
	@Override
	public String toString() {
		return "emptyWord";
	}

	@Override
	public boolean isEmpty() {
		return isEmpty=true;
	}
}
