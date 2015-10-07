package container;

import java.util.LinkedList;

import behaviours.Behaviour;

public abstract class Container {
	protected LinkedList<Behaviour> behaviours = new LinkedList<Behaviour>();
	
	protected void register(final Behaviour behaviour) {
		behaviours.add(behaviour);
	}
	
	protected void remove(final Behaviour behaviour) {
		behaviours.remove(behaviour);
	}
	
	protected LinkedList<Behaviour> getBehaviours() {
		return behaviours;
	}
}
