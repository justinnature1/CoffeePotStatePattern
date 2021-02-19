package application;

public abstract class Brew {
	CoffeePot coffeePot;
	
	public Brew (CoffeePot coffeePot) {
		this.coffeePot = coffeePot;
	}
	
	abstract void brew();
}
