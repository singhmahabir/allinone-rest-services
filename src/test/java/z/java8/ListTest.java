/**
 *
 */
package z.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;

/**
 * @author Mahabir Singh
 *
 */
public class ListTest {

    @Test
    public void printEvenOddOfaList() {

	final List<Integer> list = Arrays.asList(1, 3, 8, 9, 5, 4, 6, 2);

	final Predicate<Integer> even = i -> i % 2 == 0;
	final Predicate<Integer> odd = i -> i % 2 == 1;

	list.stream().sorted().filter(even.or(odd)).forEach(i -> System.out.print(i));
	System.out.println();
	list.stream().sorted(Integer::compare).filter(even).forEach(i -> System.out.print(i));
	list.stream().sorted(Integer::compareTo).filter(odd).forEach(i -> System.out.print(i));

    }
}