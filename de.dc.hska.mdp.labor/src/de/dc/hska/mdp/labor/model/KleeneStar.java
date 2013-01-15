package de.dc.hska.mdp.labor.model;

public class KleeneStar extends Node {

	private Node r;

	public Node getR() {
		return r;
	}

	public void setR(Node r) {
		this.r = r;
	}

	public KleeneStar(Node r) {
		this.r = r;
		setType(Type.STAR);
	}
	
	@Override
	public String toString() {
		return r.toString();
	}

	@Override
	public boolean isEmpty() {
		return true;
	}
}
