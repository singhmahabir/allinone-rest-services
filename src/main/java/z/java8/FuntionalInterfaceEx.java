/**
 * Copyright 2019 Mahabir Singh. All rights reserved.
 */

package z.java8;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class FuntionalInterfaceEx {

	public static void main(String[] args) {
		Runnable job = () -> System.out.println("thread running");
		Thread thread = new Thread(job);
		thread.start();
		Set<Person> set = new HashSet<>();
		Person person = new Person(1, "name");
		set.add(person);
		set.add(person);
		set.add(person);

		set.forEach(System.out::println);

	}
}

@Getter
@Setter
@ToString
class Person {
	String name;
	int number;

	public Person(int i, String name) {
		this.name = name;
		number = i;
	}

	@Override
	public boolean equals(Object o) {
		return false;
	}

	@Override
	public int hashCode() {
		return 10;
	}
}
