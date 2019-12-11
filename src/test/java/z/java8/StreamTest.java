/**
 * All rights reserved.
 */
package z.java8;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * @author Mahabir Singh
 *
 */
public class StreamTest {

	@Test
	public void testStreamIntermediary() {

		Stream<String> stream = Stream.of("one", "two", "three", "four");
		System.out.println(stream);
		Predicate<String> p1 = Predicate.isEqual("two");
		Predicate<String> p2 = Predicate.isEqual("three");
		List<String> list = new ArrayList<>();

		stream.peek(System.out::println).filter(p1.or(p2)).peek(list::add);

		assertEquals(0, list.size());
	}

	@Test
	public void testStreamNotIntermediary() {

		Stream<String> stream = Stream.of("one", "two", "three", "four");
		Predicate<String> p1 = Predicate.isEqual("two");
		Predicate<String> p2 = Predicate.isEqual("three");
		List<String> list = new ArrayList<>();

		stream.peek(System.out::println).filter(p1.or(p2)).forEach(list::add);

		assertEquals(2, list.size());
	}

}
