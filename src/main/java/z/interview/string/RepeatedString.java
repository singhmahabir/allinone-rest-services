/**
 *
 */
package z.interview.string;

/**
 * @author Mahabir Singh
 *
 */
public class RepeatedString {

    public static void main(String[] args) {
	Long n = repeatedString("abcd", 10l);
	System.out.println(n);
    }

    private static Long repeatedString(String s, Long n) {
	if (s.length() < 1 && s.length() > 100 || (n < 1 && n > 100)) {
	    throw new IllegalArgumentException("out of range");
	}
	Long multiply = n / s.length();
	Long reminder = n % s.length();
	Long count = findAinString(s, 'a');

	count = count * multiply + findAinString(s.substring(0, reminder.intValue()), 'a');

	return count;
    }

    private static Long findAinString(String s, Character c) {
	Long count = 0l;
	for (Character ch : s.toCharArray()) {
	    if (ch.equals(c)) {
		count++;
	    }
	}
	return count;
    }
}
