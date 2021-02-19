package application;

public class OnState extends State{

	public OnState(CoffeePot coffeePot) {
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
		coffeePot.setPowerOn(true);
		coffeePot.setMessage("On and Ready to Brew!\n");
	}

}
