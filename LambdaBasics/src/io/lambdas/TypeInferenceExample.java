package io.lambdas;

public class TypeInferenceExample {

	public static void main(String[] args) {

		StringLengthLambda myLambda = (String s) -> s.length();
		StringLengthLambda myLambda1 = (s) -> s.length();
		StringLengthLambda myLambda2 = s -> s.length(); // In case of single arg there is no need of mentioning type

		System.out.println(myLambda.getLength("Hey World!"));
		System.out.println(myLambda1.getLength("Hey World!"));
		System.out.println(myLambda2.getLength("Hey World!"));
		printLambda(myLambda);
	}

	public static void printLambda(StringLengthLambda lmbda) {
		System.out.println(lmbda.getLength("Hey World!"));
	}

	interface StringLengthLambda {
		int getLength(String s);
	}

}
