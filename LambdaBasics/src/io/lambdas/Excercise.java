package io.lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Excercise {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51), new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));
		/*
		 * Step 1 : Sort list by last name Step 2 : Create a method that prints
		 * all elements in the list Step 3 : Create a method that prints all
		 * people that have name beginning with C
		 */
		Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
		printConditonally(people, p -> true);
		printConditonally(people, p -> p.getLastName().startsWith("C"));
		
		//java.util.function based implementation
		printConditonallyUsingPredicate(people, p -> true);
		performConditionally(people, p -> true, p -> System.out.println(p));
	}

	private static void printConditonally(List<Person> people, Condition condition) {
		for (Person p : people) {
			if (condition.test(p))
				System.out.println(p);
		}
	}

	private static void printConditonallyUsingPredicate(List<Person> people, Predicate<Person> predicate) {
		for (Person p : people) {
			if (predicate.test(p))
				System.out.println(p);
		}
	}

	private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> c) {
		for (Person p : people) {
			if (predicate.test(p))
				c.accept(p);
		}
	}

	interface Condition {
		boolean test(Person p);
	}
}
