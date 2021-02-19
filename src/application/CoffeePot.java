package application;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class CoffeePot {
	private State state;
	private boolean hasWater;
	private boolean hasGrounds;
	private boolean powerOn;
	private Brew brew;
	private boolean strongBrew;
	private boolean isBrewing;

	Queue<String> messages = new LinkedList<>();
	
	State onState;
	State offState;
	State brewState;
	State warmState;
	State errorState;

	public CoffeePot (boolean hasWater, boolean hasGrounds) {
		onState = new OnState(this);
		offState = new OffState(this);
		brewState = new BrewState(this);
		warmState = new WarmState(this);
		errorState = new ErrorState(this);

		setStrongBrew(false);
		this.state =  offState;
		this.hasWater = hasWater;
		this.hasGrounds = hasGrounds;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		if (!this.state.getClass().equals(state.getClass())) {
			this.state = state;
			this.state.begin();
		}
	}

	public boolean getHasWater() {
		return hasWater;
	}

	public void setHasWater(boolean hasWater) {
		this.hasWater = hasWater;
	}

	public boolean getHasGrounds() {
		return hasGrounds;
	}

	public void setHasGrounds(boolean hasGrounds) {
		this.hasGrounds = hasGrounds;
	}

	public boolean isPowerOn() {
		return powerOn;
	}

	public void setPowerOn(boolean powerOn) {
		this.powerOn = powerOn;
	}

	public Brew getBrew() {
		return this.brew;
	}

	public void setBrew(Brew brew) {
		this.brew = brew;
	}

	public String getMessage() {
		return messages.poll();
	}

	public void setMessage (String message) {
		messages.add(message);
	}

	public Iterator<String> messagesIterator() {
		return messages.iterator();
	}

	public boolean isStrongBrew() {
		return strongBrew;
	}

	public void setStrongBrew(boolean strongBrew) {
		this.strongBrew = strongBrew;
		if (strongBrew) 
			this.brew = new StrongBrew(this);			
		else
			this.brew = new RegularBrew(this);
	}

	public boolean isBrewing() {
		return isBrewing;
	}

	public void setBrewing(boolean isBrewing) {
		this.isBrewing = isBrewing;
	}
	
}
