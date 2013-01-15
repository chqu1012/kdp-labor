package de.dc.hska.mdp.labor.model;


public abstract class Node {

	protected char letter;
	protected Type type;
	protected boolean isEmpty;
	protected boolean hasChildren;
	public boolean isHasChildren() {
		return hasChildren;
	}
	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public abstract boolean isEmpty();
}
