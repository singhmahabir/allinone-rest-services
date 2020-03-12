/**
 *
 */
package z.interview.string;

import java.util.HashSet;

/**
 * For example, given the string , remove an at positions and to make in
 * deletions.
 * 
 * <pre>
 * 	Sample Input
 * 
 * 	5
 * 	AAAA
 * 	BBBBB 
 * 	ABABABAB 
 * 	BABABA 
 * 	AAABBB 
 * 
 * 	Sample Output
 * 
 * 	3 4 0 0 4 
 * 
 * Explanation: 
 * The characters marked red are the ones that can be deleted so that the string
 * doesn't have matching consecutive characters.
 * 
 * </pre>
 * 
 * @author Mahabir Singh
 *
 */
public class AlternatingCharacters {
    public static void main(String[] args) {
	int delete = alternatingCharacters("aabcc");
	System.out.println(delete);
    }

    private static int alternatingCharacters(String s) {
	HashSet<Character> set = new HashSet<>();
	int delete = 0;
	for (Character c : s.toCharArray()) {
	    if (set.isEmpty()) {
		set.add(c);
	    } else if (set.contains(c)) {
		delete++;
	    } else {
		set.clear();
		set.add(c);
	    }
	}
	return delete;
    }
}
