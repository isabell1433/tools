package strings.medium;

/**

 Given an array of characters chars, compress it using the following algorithm:
 Begin with an empty string s. For each group of consecutive repeating characters in chars:
 - If the group's length is 1, append the character to s.
 - Otherwise, append the character
 After you are done modifying the input array, return the new length of the array.
 You must write an algorithm that uses only constant extra space.

 Example 1:
 ```
 Input: chars = ['a','a','b','b','c','c','c']
 Output: return "a2b2c3" and input array should be: ['a','2','b','2','c','3'] of size 6 and make it to return like 'a2b2c3' string
 Explanation: The groups are 'aa', 'bb', and 'ccc'. This compresses to 'a2b2c3'.


 ```
 Example 2:
 ```
 Input: chars = ['a']
 Output: return "a" and the input array should be: ['a']
 Explanation: The only group is 'a', which remains uncompressed since it's a single character.

 ```
 Example 3:
 ```
 Input: chars = ['a','b','b','b','b','b','b','b','b','b','b','b','b']
 Output: return "ab12" and the input array should be: ['a','b','1','2'] of size 4
 Explanation: The groups are 'a' and 'bbbbbbbbbbbb'. This compresses to 'ab12'.
 ```
 */



//https://leetcode.com/problems/string-compression/ 443
public class StringCompression {

    public static void main(String args[]) {
        char[] example1 = {'a'};
        char[] example2 = {'a','a','b','b','c','c','c'};
        char[] example3 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compress(example1)); // a
        System.out.println(compress(example2)); //a2b2c3
        System.out.println(compress(example3)); //ab12
    }

    public static String compress (char chars[]) {
        if (chars == null || chars.length == 0) return "";

        int left = 0;
        int index = 0;

        for (int i = 1 ; i <= chars.length ; i++) {
            if (i == chars.length || chars[i] != chars[left]) {
                chars[index++] = chars[left];

                int diff = i - left ;
                if (diff > 1) {
                    String diffStr = String.valueOf(diff);
                    for (char c : diffStr.toCharArray()) {
                        chars[index++] = c;
                    }
                }
                left = i;
            }
        }

        return new String(chars).substring(0, index);
    }
}
