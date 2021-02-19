package application;

public class BrewState extends State{

	public BrewState(CoffeePot coffeePot) {
		super(coffeePot);
	}

	public void power() {
		coffeePot.setMessage("Brewing Coffee: Please Wait to Power Off.\n");
	}

	public void startBrew() {
		coffeePot.setBrewing(true);
		long startTimeMillis = System.currentTimeMillis();
		long timeDiff = 0;
		coffeePot.getBrew().brew();
		while (coffeePot.isBrewing()) {
			timeDiff = System.currentTimeMillis() - startTimeMillis;
			if (timeDiff/1000 > 10)
				coffeePot.getState().brewComplete();
		}
	}

	public void brewComplete() {
		coffeePot.setHasGrounds(false);
		coffeePot.setHasWater(false);
		coffeePot.setBrewing(false);
		coffeePot.setState(coffeePot.warmState);
	}

	public void begin() {
		coffeePot.getState().startBrew();
	}

	@Override
	void setRegularBrew() {
		coffeePot.setMessage("Cannot Change Brew While Brewing!");		
	}

	@Override	
	void setStrongBrew() {
		coffeePot.setMessage("Cannot Change Brew While Brewing!");			
	}

	@Override
	void addCoffee() {
		coffeePot.setMessage("Cannot Add Coffee While Brewing!");		
	}

	@Override
	void addWater() {
		coffeePot.setMessage("Cannot Add Water While Brewing!");
	}



}


