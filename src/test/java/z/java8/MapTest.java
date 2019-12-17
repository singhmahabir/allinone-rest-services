/**
 * All rights reserved.
 */
package z.java8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * @author Mahabir Singh
 *
 *         Map returns a Stream, so it is an intermediary operation
 *
 */
public class MapTest {

	@Test
	public void testSMapIntermediary() {

		final List<Person> list = new ArrayList<>();
		list.add(new Person(1, "mahabir"));
		list.add(new Person(2, "mahabir singh"));
		list.add(new Person(3, "singh"));

		final Stream<Person> stream = list.stream();
		final Stream<String> names = stream.map(person -> person.getName());
		names.peek(System.out::println) // it will not print bcz it is intermediary
				.forEach(System.out::println);

		// assertEquals(0, list.size());
	}

	@Test
	public void testMapKeyAndValue() {

		final Set<Person> set = new HashSet<>(2);
		set.add(new Person(1, "mahabir"));
		set.add(new Person(2, "mahabir singh"));
		set.add(new Person(3, "singh3"));
		set.add(new Person(4, "singh4"));
		set.add(new Person(4, "singh4"));

		set.stream().forEach(System.out::println);

		// assertEquals(0, list.size());
	}
}
