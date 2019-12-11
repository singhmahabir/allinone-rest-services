/**
 * Copyright 2018 Mercedes Benz Research & Development, A Daimler Company. All rights reserved.
 */

package singh.mahabir.allinone;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mahabir Singh
 *
 */
public class ConcurrentModificationExceptionTest {

	@Test(expected = ConcurrentModificationException.class)
	public void removingDuringIteration_shouldThrowException() throws InterruptedException {

		final List<Integer> integers = getListOfInterger();
		for (final Integer i : integers) {
			if (i == 1) {
				integers.remove(i);
			}
		}
	}

	@Test
	public void safeRemovingDuringIteratio() {

		final List<Integer> integers = getListOfInterger();
		for (final Iterator<Integer> iterator = integers.iterator(); iterator.hasNext();) {
			final Integer integer = iterator.next();
			if (integer == 2) {
				iterator.remove();
			}
		}
		assertEquals(2, integers.size());
	}

	@Test
	public void safeRemovingDuringIteratio2() {

		final List<Integer> integers = getListOfInterger();
		final List<Integer> toRemove = new ArrayList<>();
		for (final Integer integer : integers) {
			if (integer == 2) {
				toRemove.add(integer);
			}
		}
		integers.removeAll(toRemove);
		assertEquals(2, integers.size());
	}

	@Test
	public void safeRemovingUsing_Cuncurrent_java5() {

		final Collection<Integer> integers = new CopyOnWriteArrayList<>();
		integers.add(1);
		integers.add(2);
		integers.add(3);
		for (final Integer integer : integers) {
			if (integer == 1) {
				integers.remove(integer);
			}
		}
		assertEquals(2, integers.size());
	}

	/**
	 * Java 8 introduced the removeIf() method to the Collection interface we can
	 * use ideas of functional programming to achieve the same results
	 */
	@Test
	public void safeRemovingUsingJava8() {

		final List<Integer> integers = getListOfInterger();
		integers.removeIf(i -> i == 2);
		assertEquals(2, integers.size());
	}

	@Test
	public void safeRemovingUsingJava8_Stream() {

		final Collection<Integer> integers = getListOfInterger();
		final List<String> collected = integers.stream()
				.filter(i -> i != 2)
				.map(Object::toString)
				.collect(Collectors.toList());
		assertEquals(2, collected.size());
	}

	private List<Integer> getListOfInterger() {
		final List<Integer> integers = new ArrayList<>();
		integers.add(1);
		integers.add(2);
		integers.add(3);
		return integers;
	}

}
