package ch.hslu.sw05.aggregateState;

public class Main {

	public static void main(final String[] args) {

		Nitrogen nitrogen1 = new Nitrogen();
		System.out.println(nitrogen1.getState(55f));
		System.out.println(nitrogen1.toString());
		
		
		Mercury mercury1 = new Mercury();
		System.out.println(mercury1.getState(55f));
		System.out.println(mercury1.toString());
	}
}
