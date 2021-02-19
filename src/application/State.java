package application;

public abstract class State {
	CoffeePot coffeePot;

	public State (CoffeePot coffeePot){
		this.coffeePot = coffeePot;
	}

	abstract void power();
	abstract void startBrew();
	abstract void brewComplete(); 
	abstract void begin();

	private void setBrew(boolean isStrBrew) {
		coffeePot.setStrongBrew(isStrBrew);
	}

	void setRegularBrew() {
		this.setBrew(false);
	}

	void setStrongBrew() {
		this.setBrew(true);
	}

	void addCoffee() {
		if (!coffeePot.getHasGrounds()) {
			coffeePot.setHasGrounds(true);	
			coffeePot.setMessage("Coffee Grounds Added");
		} else {
			coffeePot.setMessage("Coffee Pot Alreday Has Coffee Grounds.");
		}
	}

	void addWater() {
		if (!coffeePot.getHasWater()) {
			coffeePot.setHasWater(true);	
			coffeePot.setMessage("Water Added");
		} else {
			coffeePot.setMessage("Coffee Pot Alreday Has Water.");
		}	
	}

}
