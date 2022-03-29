package strings.easy;

import java.util.HashMap;
import java.util.Map;

/**
 Given two strings s and t, determine if they are isomorphic.
 Two strings are isomorphic if the characters in s can be replaced to get t.
 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 For example, Given "egg", "add", return true.
 Given "foo", "bar", return false.
 Given "paper", "title", return true.
 */

//s : "badc", "baba"

//https://leetcode.com/problems/isomorphic-strings/submissions/ 205
public class Isomorphic {

    public static void main (String args[] ) {
        System.out.println(isomorphic("egg", "add")); // true
        System.out.println(isomorphic("foo", "bar")); // false
        System.out.println(isomorphic("paper", "title")); // true
        System.out.println(isomorphic("badc", "baba")); // false
    }

    public static boolean  isomorphic(String s , String t) {
        Map<Character, Character> map = new HashMap<>();
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length() ; i++) {
            Character key = s.charAt(i);
            Character value = t.charAt(i);
            if (map.containsKey(key)) {
                if (map.get(key) != value) {
                    return false;
                }
            } else {
                if (map.containsValue(value)) {
                    return false;
                } else {
                    map.put(key, value);
                }
            }
        }
        return true;
    }
}
