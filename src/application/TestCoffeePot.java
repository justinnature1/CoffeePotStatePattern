package application;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class TestCoffeePot {

//Is this what you are expecting for a JUnit test on a design pattern?  Please let me know what you are looking for.	
	
	@Test
	void test() throws InterruptedException {
		CoffeePot coffeePot = new CoffeePot(false, false);
		assertTrue(coffeePot.getState().getClass().getName().equals("application.OffState"));
		coffeePot.getState().power();
		assertTrue(coffeePot.getState().getClass().getName().equals("application.OnState"));
		coffeePot.getState().startBrew();
		assertTrue(coffeePot.getState().getClass().getName().equals("application.ErrorState"));
		coffeePot.getState().addCoffee();
		coffeePot.getState().startBrew();
		assertTrue(coffeePot.getState().getClass().getName().equals("application.ErrorState"));
		coffeePot.getState().addWater();
		assertTrue(coffeePot.getBrew().getClass().getName().equals("application.RegularBrew"));
		coffeePot.getState().startBrew();
		Thread.sleep(20000);
		System.out.println(coffeePot.getState().getClass().getName());
		assertTrue(coffeePot.getState().getClass().getName().equals("application.WarmState"));
		coffeePot.getState().power();
		assertTrue(coffeePot.getState().getClass().getName().equals("application.OffState"));

	}

}
