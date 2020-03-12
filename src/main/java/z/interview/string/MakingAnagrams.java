/**
 *
 */
package z.interview.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * remove the uncommon character
 * 
 * <pre>
 * Sample Input

	cde
	abc
Sample Output

	4
	
 * Explanation
 * 
 * We delete the following characters from our two strings to turn them into
 * anagrams of each other:
 * 
 * 1. Remove d and e from cde to get c.
 * 2. Remove a and b from abc to get c.
 *    We must delete characters to make both strings anagrams, so we print on a new line.
 * </pre>
 * 
 *
 * 
 * @author Mahabir Singh
 *
 */
public class MakingAnagrams {

    public static void main(String[] args) {
	int delete = makeAnagram("cde", "aabc");
	System.out.println(delete);
    }

    private static int makeAnagram(String a, String b) {
	if (a.length() < 1 && a.length() > 10000 || b.length() < 1 && b.length() > 10000) {
	    return 0;
	}
	Map<Character, Integer> map1 = setUpMap(a);
	Map<Character, Integer> map2 = setUpMap(b);
	System.out.println(map1);
	System.out.println(map2);
	int count = 0;
	for (Iterator<Character> iterator = map1.keySet().iterator(); iterator.hasNext();) {
	    Character c = iterator.next();
	    if (map2.containsKey(c)) {
		count += Math.abs(map1.get(c) - map2.get(c));
		iterator.remove();
		map2.remove(c);
	    }
	}
	count += map1.values().stream().mapToInt(Integer::intValue).sum();
	count += map2.values().stream().mapToInt(Integer::valueOf).sum();
	System.out.println(map1);
	System.out.println(map2);
	return count;
    }

    private static Map<Character, Integer> setUpMap(String s) {
	Map<Character, Integer> map = new HashMap<>();
	for (Character ch : s.toCharArray()) {
	    map.put(ch, map.getOrDefault(ch, 0) + 1);
	}
	return map;
    }
}
