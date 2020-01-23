package io.lambdas;

public class RunnableExample {

	public static void main(String[] args) {
		/*
		 * Anonymous inner class implementation of method inside an interface (Boiler
		 * plate code)
		 */
		Thread myThread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Printed inside Runnable anonymous inner class implementation");
			}

		});
		myThread.start();
		Runnable runLambdaFuntion = () -> System.out.println("Printed inside Runnable lambda implementation");
		Thread myLambdaBasedThread = new Thread(runLambdaFuntion);
		Thread myLambdaBasedThread1 = new Thread(
				() -> System.out.println("Printed inside Runnable lambda implementation"));
		myLambdaBasedThread.start();
		myLambdaBasedThread1.start();

	}

}
