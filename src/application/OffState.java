package application;

public class OffState extends State {

	public OffState(CoffeePot coffeePot) {
		super(coffeePot);
	}

	void power() {
		coffeePot.setState(coffeePot.onState);
	}

	void startBrew() {
		//Do Nothing
	}

	void brewComplete() {
		//Do Nothing		
	}

	void begin() {
		coffeePot.setPowerOn(false);
		coffeePot.setMessage("Cofee Pot is Powering Off.\n");
	}

	@Override
	void setRegularBrew() {
		//Do Nothing
	}
	
	@Override
	void setStrongBrew() {
		//Do Nothing
	}
	
	@Override
	void addCoffee() {
		//Do Nothing
	}

	@Override
	void addWater() {
		//Do Nothing
	}
	
}
