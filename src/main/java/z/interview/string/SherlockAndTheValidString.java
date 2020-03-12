/**
 *
 */
package z.interview.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *  For example, if , it is a valid string because frequencies are . So is  
 *  because we can remove one  and have  of each character in the remaining string.
 *  If  however, the string is not valid as we can only remove  occurrence of . 
 *  That would leave character frequencies of .
 * </pre>
 * 
 * @author Mahabir Singh
 *
 */
public class SherlockAndTheValidString {
    public static void main(String[] args) {
	String result = isValid("abcdefghhgfedecba");
	System.out.println(result);
	result = isValid("abdcc");
	System.out.println(result);
	result = isValid("aabbcd");
	System.out.println(result);
	result = isValid("aabbccddeefghi");
	System.out.println(result);
    }

    private static String isValid(String s) {
	if (s.length() < 1 && s.length() > 10000) {
	    return "NO";
	}
	Map<Character, Integer> entry = setUpMap(s);
	System.err.println(entry);
	Map<Integer, Integer> count = new HashMap<>();
	entry.values().forEach(value -> count.put(value, count.getOrDefault(value, 0) + 1));
	if (count.keySet().size() == 1) {
	    return "YES";
	} else if (count.keySet().size() == 2) {
	    Integer onceCount = count.get(1);
	    if (onceCount == null) {
		ArrayList<Integer> list = new ArrayList<>(count.keySet());
		return Math.abs(list.get(0) - list.get(1)) > 1 ? "NO" : "YES";
	    } else {
		if (count.get(2) != null && count.get(2) == 1) {
		    return "YES";
		}
		if (count.get(1) > 1) {
		    return "NO";
		}
		return "YES";
	    }
	}

	return "NO";
    }

    private static Map<Character, Integer> setUpMap(String s) {
	Map<Character, Integer> map = new HashMap<>();
	for (Character ch : s.toCharArray()) {
	    map.put(ch, map.getOrDefault(ch, 0) + 1);
	}
	return map;
    }
}
