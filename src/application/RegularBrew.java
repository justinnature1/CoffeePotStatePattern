package application;

public class RegularBrew extends Brew{

	public RegularBrew(CoffeePot coffeePot) {
		super(coffeePot);
	}
	
	@Override
	public void brew() {
		coffeePot.setMessage("Brewing Regular Cofee. Ready in 10 seconds!\n");
		//Instructions for Brewing Regular Strength Coffee Here
	}

}
