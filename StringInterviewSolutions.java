package Strings;

import java.util.*;

public class StringInterviewSolutions {
    public static void main(String[] args) {
        // Test cases for all methods

        // 1. String - Palindrome
        System.out.println("1. Palindrome Check:");
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car")); // false
        System.out.println();

        // 2. String - Count Vowels
        System.out.println("2. Count Vowels:");
        System.out.println(countVowels("Hello World")); // 3
        System.out.println(countVowels("Programming Interview")); // 6
        System.out.println();

        // 3. Joining Strings - Custom Join
        System.out.println("3. Custom Join:");
        System.out.println(joinStrings(new String[]{"apple", "banana", "cherry"}, ", ")); // "apple, banana, cherry"
        System.out.println(joinStrings(new String[]{"Java", "is", "fun"}, "-")); // "Java-is-fun"
        System.out.println();

        // 4. Joining Strings - Alternate Characters
        System.out.println("4. Alternate Characters:");
        System.out.println(alternateCharacters("abc", "123")); // "a1b2c3"
        System.out.println(alternateCharacters("hello", "world!")); // "hweolrllod!"
        System.out.println();

        // 5. Additional String Methods - Longest Substring
        System.out.println("5. Longest Substring Without Repeating Characters:");
        System.out.println(longestSubstringWithoutRepeating("abcabcbb")); // "abc"
        System.out.println(longestSubstringWithoutRepeating("bbbbb")); // "b"
        System.out.println(longestSubstringWithoutRepeating("pwwkew")); // "wke"
        System.out.println();

        // 6. Additional String Methods - First Non-Repeated Character
        System.out.println("6. First Non-Repeated Character:");
        System.out.println(firstNonRepeatedCharacter("swiss")); // "w"
        System.out.println(firstNonRepeatedCharacter("aabb")); // null
        System.out.println();

        // 7. StringBuffer - Reverse Words
        System.out.println("7. Reverse Words:");
        System.out.println(reverseWords("Java programming is fun")); // "avaJ gnimmargorp si nuf"
        System.out.println(reverseWords("Hello World")); // "olleH dlroW"
        System.out.println();

        // 8. StringBuffer - Remove Character
        System.out.println("8. Remove Character:");
        System.out.println(removeCharacter("programming", 'm')); // "prograing"
        System.out.println(removeCharacter("banana", 'a')); // "bnn"
        System.out.println();

        // 9. StringBuilder - Generate Substrings
        System.out.println("9. Generate All Substrings:");
        System.out.println(generateSubstrings("abc")); // [a, ab, abc, b, bc, c]
        System.out.println(generateSubstrings("xy")); // [x, xy, y]
        System.out.println();

        // 10. StringBuilder - Insert Space
        System.out.println("10. Insert Space After Every N Characters:");
        System.out.println(insertSpaceAfterNChars("ABCDEFGHIJKLMNOPQR", 4)); // "ABCD EFGH IJKL MNOP QR"
        System.out.println(insertSpaceAfterNChars("programming", 3)); // "pro gra mmi ng"
    }

    /**
     * 1. Check if a string is a palindrome, ignoring case and non-alphanumeric characters.
     */
    public static boolean isPalindrome(String s) {
        if (s == null) return false;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            left++;
            right--;
        }
        return true;
    }

    /**
     * 2. Count vowels in a string, case-insensitive.
     */
    public static int countVowels(String s) {
        if (s == null) return 0;
        int count = 0;
        String vowels = "aeiou";
        for (char c : s.toLowerCase().toCharArray()) {
            if (vowels.indexOf(c) != -1) count++;
        }
        return count;
    }

    /**
     * 3. Join an array of strings with a specified delimiter.
     */
    public static String joinStrings(String[] strings, String delimiter) {
        if (strings == null || strings.length == 0) return "";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            result.append(strings[i]);
            if (i < strings.length - 1) result.append(delimiter);
        }
        return result.toString();
    }

    /**
     * 4. Concatenate alternating characters from two strings.
     */
    public static String alternateCharacters(String s1, String s2) {
        if (s1 == null) s1 = "";
        if (s2 == null) s2 = "";
        StringBuilder result = new StringBuilder();
        int maxLength = Math.max(s1.length(), s2.length());
        for (int i = 0; i < maxLength; i++) {
            if (i < s1.length()) result.append(s1.charAt(i));
            if (i < s2.length()) result.append(s2.charAt(i));
        }
        return result.toString();
    }

    /**
     * 5. Find the longest substring without repeating characters.
     */
    public static String longestSubstringWithoutRepeating(String s) {
        if (s == null || s.isEmpty()) return "";
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int start = 0, maxLength = 0, maxStart = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charIndexMap.containsKey(c) && charIndexMap.get(c) >= start) {
                start = charIndexMap.get(c) + 1;
            }
            if (i - start + 1 > maxLength) {
                maxLength = i - start + 1;
                maxStart = start;
            }
            charIndexMap.put(c, i);
        }
        return s.substring(maxStart, maxStart + maxLength);
    }

    /**
     * 6. Find the first non-repeated character in a string.
     */
    public static Character firstNonRepeatedCharacter(String s) {
        if (s == null || s.isEmpty()) return null;
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return null;
    }

    /**
     * 7. Reverse every word in a sentence using StringBuffer.
     */
    public static String reverseWords(String s) {
        if (s == null || s.isEmpty()) return "";
        String[] words = s.split(" ");
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < words.length; i++) {
            StringBuffer reversedWord = new StringBuffer(words[i]);
            reversedWord.reverse();
            result.append(reversedWord);
            if (i < words.length - 1) result.append(" ");
        }
        return result.toString();
    }

    /**
     * 8. Remove all occurrences of a character from a string using StringBuffer.
     */
    public static String removeCharacter(String s, char c) {
        if (s == null) return null;
        StringBuffer buffer = new StringBuffer(s);
        int i = 0;
        while (i < buffer.length()) {
            if (buffer.charAt(i) == c) buffer.deleteCharAt(i);
            else i++;
        }
        return buffer.toString();
    }

    /**
     * 9. Generate all possible substrings of a string using StringBuilder.
     */
    public static List<String> generateSubstrings(String s) {
        if (s == null) return null;
        List<String> substrings = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                builder.append(s.charAt(j));
                substrings.add(builder.toString());
            }
        }
        return substrings;
    }

    /**
     * 10. Insert a space after every n characters in a string using StringBuilder.
     */
    public static String insertSpaceAfterNChars(String s, int n) {
        if (s == null || n <= 0) return s;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            result.append(s.charAt(i));
            if ((i + 1) % n == 0 && i < s.length() - 1) result.append(" ");
        }
        return result.toString();
    }
}