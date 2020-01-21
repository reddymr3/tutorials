package io.lambdas;

public class HeyWorldGreeting implements Greeting {

	@Override
	public void perform() {
		System.out.println("Hey World!");
	}

}
