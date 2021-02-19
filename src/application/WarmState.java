package application;

public class WarmState extends State{

	public WarmState(CoffeePot coffeePot) {
		super(coffeePot);
	}

	void power() {
		coffeePot.setState(coffeePot.offState);
	}

	void startBrew() {
		if (coffeePot.getHasGrounds() && coffeePot.getHasWater()) {
			coffeePot.setState(coffeePot.brewState);
		} else
			coffeePot.setState(coffeePot.errorState);	
	}

	void brewComplete() {
		//Do Nothing		
	}

	void begin() {
		coffeePot.setMessage("Coffee is Ready! Coffee will be kept at a balmy 150 degrees.\n");
	}

}
