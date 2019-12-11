/**
 * Copyright 2019 Mahabir Singh. All rights reserved.
 */

package z.java8;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Mahabir Singh
 *
 */
public class MinMaxOfArrayOrList {

	@Test
	public void maxOfList() {
		final List<Integer> list = Arrays.asList(4, 8, 99, 2, 0);

		final Integer max = list.stream().mapToInt(i -> i).max().orElseThrow(NumberFormatException::new);

		final Integer expected = 99;
		assertEquals("Should be 99", expected, max);
	}

	@Test
	public void minOfList() {
		final List<Integer> list = Arrays.asList(4, 8, 99, 2, 0);

		final Integer min = list.stream().mapToInt(i -> i).min().orElseThrow(NumberFormatException::new);

		final Integer expected = 0;
		assertEquals("Should be 0", expected, min);
	}

	@Test
	public void minOfListUsingComparator() {
		final List<Integer> list = Arrays.asList(4, 8, 99, 2, 0);

		final Integer min = list.stream().min(Comparator.naturalOrder()).orElseThrow(NumberFormatException::new);

		final Integer expected = 0;
		assertEquals("Should be 0", expected, min);
	}

	@Test
	public void minOfListUsingComparatorForPersonClass() {
		final List<Person> list = Arrays.asList(new Person("ram", 2), new Person("shyam", 7), new Person("ram12", 99),
				new Person("rani", 8));

		final Person min = list.stream()
				.min(Comparator.comparing(Person::getAge))
				.orElseThrow(NumberFormatException::new);

		final Integer expected = 2;
		assertEquals("Should be 2", expected, min.getAge());
	}

	@Setter
	@Getter
	@AllArgsConstructor
	class Person {
		String name;
		Integer age;
	}
}
