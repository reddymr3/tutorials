package io.lambdas;

public class Greeter {

	public void greet() {
		System.out.println("Hey World!");
	}

	public void greet(Greeting greeting) {
		greeting.perform();
	}

	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		greeter.greet();

		HeyWorldGreeting heyWorldGreeting = new HeyWorldGreeting();
		greeter.greet(heyWorldGreeting);

		MyLambda myLambdaFuntion = () -> System.out.println("Hey World!");
		myLambdaFuntion.foo();

		Greeting greeting = new HeyWorldGreeting();
		Greeting greetingFunction = () -> System.out.println("Hey World!");

		greeting.perform();
		greetingFunction.perform();

		// Anonymous innner class - inline implementation of an interface
		Greeting innerClassGreeting = new Greeting() {
			@Override
			public void perform() {
				System.out.println("Hey World!");
			}
		};
		innerClassGreeting.perform();

		greeter.greet(greetingFunction);
		greeter.greet(innerClassGreeting);
		greeter.greet(() -> System.out.println("Hey World!"));

	}
}

interface MyLambda {
	void foo();
}