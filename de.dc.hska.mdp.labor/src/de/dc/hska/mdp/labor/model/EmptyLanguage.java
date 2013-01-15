package de.dc.hska.mdp.labor.model;

public class EmptyLanguage extends Node {

	public EmptyLanguage() {
		setType(Type.EMPTY_LANGUAGE);
	}
	
	@Override
	public String toString() {
		return "emptyLangugae";
	}

	@Override
	public boolean isEmpty() {
		return false;
	}
}
