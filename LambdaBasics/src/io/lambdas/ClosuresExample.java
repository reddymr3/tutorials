package io.lambdas;

public class ClosuresExample {
	public static void main(String[] args) {
		int a = 10;
		int b = 20; // effectively final [java treats it as final and it passes
					// this variable to the lambda.even we can put final while
					// declaring]
		doProcess(a, new Process() {
			@Override
			public void process(int i) {
				System.out.println(i + 10);
			}
		});

		doProcess(a, new Process() {
			@Override
			public void process(int i) {
				// b=40;
				System.out.println(i + b);
			}
		});

		doProcess(a, i -> System.out.println(i + b));

	}

	public static void doProcess(int i, Process p) {
		p.process(i);
	}
}

interface Process {
	void process(int i);
}
