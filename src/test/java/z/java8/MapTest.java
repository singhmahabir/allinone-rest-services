/**
 * All rights reserved.
 */
package z.java8;

import java.util.ArrayList;
import java.util.List;
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

		List<Person> list = new ArrayList<>();
		list.add(new Person(1, "mahabir"));
		list.add(new Person(2, "mahabir singh"));
		list.add(new Person(3, "singh"));

		Stream<Person> stream = list.stream();
		Stream<String> names = stream.map(person -> person.getName());
		names.peek(System.out::println); // it will not print bcz it is intermediary
		names.forEach(System.out::println);

		// assertEquals(0, list.size());
	}
}
