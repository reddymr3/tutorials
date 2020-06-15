package io.lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExerciseJava7Solution {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51), new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));
		/*
		 * Step 1 : Sort list by last name Step 2 : Create a method that prints
		 * all elements in the list Step 3 : Create a method that prints all
		 * people that have name beginning with C
		 */
		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});

		printall(people);

		printPeopleWhoseLNameStartsWithC(people);
		
		printConditonally(people, new Condition() {
			@Override
			public boolean test(Person p) {
				return true;
			}
		});

		printConditonally(people, new Condition() {
			@Override
			public boolean test(Person p) {
				return p.getLastName().startsWith("C");
			}
		});
	}

	private static void printall(List<Person> people) {
		for (Person p : people) {
			System.out.println(p);
		}
	}

	private static void printPeopleWhoseLNameStartsWithC(List<Person> people) {
		for(Person p : people){
			if(p.getLastName().startsWith("C")){
				System.out.println(p);
			}
		}
	}

	private static void printConditonally(List<Person> people, Condition condition) {
		for (Person p : people) {
			if (condition.test(p))
				System.out.println(p);
		}
	}

	interface Condition {
		boolean test(Person p);
	}
}
