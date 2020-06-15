package io.lambdas;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {

	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5 };
		int key = 2;
		process(numbers, key, (i, k) -> System.out.println(i + k));
		key = 1;
		process(numbers, key, (i, k) -> System.out.println(i / k));
		key = 0;
		process(numbers, key, (i, k) -> {
			try {
				System.out.println(i / k);
			} catch (ArithmeticException e) {
				e.printStackTrace();
				System.out.println("Arithmetic exception happened");
			}
		});
		
		process(numbers,key,wrapperLambda((i, k) -> System.out.println(i / k)));

	}

	private static void process(int[] numbers, int key, BiConsumer<Integer, Integer> consumer) {
		for (int i : numbers) {
			consumer.accept(i, key);
		}
	}
	
	private static BiConsumer<Integer,Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer){
		return (v,k) -> {
			try{
				consumer.accept(v, k);
			}catch(Exception e){
				e.printStackTrace();
			}
		};
	}
}
