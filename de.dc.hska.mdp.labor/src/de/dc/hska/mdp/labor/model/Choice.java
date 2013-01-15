package de.dc.hska.mdp.labor.model;

public class Choice extends Node {

	private Node r1;
	private Node r2;

	public Choice(Node r1, Node r2) {
		this.r1 = r1;
		this.r2 = r2;
		setType(Type.CHOICE);
		setHasChildren(true);
	}
	public Node getR1() {
		return r1;
	}
	public void setR1(Node r1) {
		this.r1 = r1;
	}
	public Node getR2() {
		return r2;
	}
	public void setR2(Node r2) {
		this.r2 = r2;
	}
	@Override
	public String toString() {
		return "("+r1+" + "+r2+")";
	}

	@Override
	public boolean isEmpty() {
		if(r1.isEmpty && r2.isEmpty)
			return true;
		return false;
	}
}
