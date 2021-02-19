package application;

public class StrongBrew extends Brew{

	public StrongBrew(CoffeePot coffeePot) {
		super(coffeePot);
	}
	
	public void brew() {
		coffeePot.setMessage("Brewing Strong Cofee. Ready in 10 seconds!\n");
		//Instructions for Brewing Strong Strength Coffee Here
	}
	
}
