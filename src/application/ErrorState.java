package application;

public class ErrorState extends State{

	public ErrorState(CoffeePot coffeePot) {
		super(coffeePot);
	}

	void power() {
		coffeePot.setState(coffeePot.offState);
	}

	void startBrew() {
		this.begin();
	}

	void brewComplete() {
		//Do Nothing
	}

	void begin() {
		if (!coffeePot.getHasGrounds()) {
			coffeePot.setMessage("No Coffee Grounds: Add Coffee Before Brewing.\n");
		} else if (!coffeePot.getHasWater())
			coffeePot.setMessage("No Water: Add Water Before Brewing.\n");
		else
			coffeePot.setState(coffeePot.brewState);
	}
	
}
