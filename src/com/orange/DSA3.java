package com.orange;

/**
 * 1.去除字符串中相邻重复的字符
 * 2.去除字符串中所有重复的字符
 */
public class DSA3 {
    public static void main(String[] args) {
        String s = "aaabbbcccddddeeeeaaabbbcccdddeee";
        String s1 = removeAdjacentRepeatString(s);
        String s2 = removeRepeatString(s);
        System.out.println(s1);
        System.out.println(s2);
    }

    private static String removeAdjacentRepeatString(String s) {
        int length = s.length();
        StringBuilder builder = new StringBuilder();
        int startIndex = 0;
        while (startIndex < length) {
            char currentChar = s.charAt(startIndex);
            builder.append(currentChar);
            startIndex++;
            while (startIndex < length && s.charAt(startIndex) == currentChar) {
                startIndex++;
            }
        }

        return builder.toString();
    }


    private static String removeRepeatString(String s) {

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.indexOf(c) == s.lastIndexOf(c)) {
                builder.append(c);
            } else {
                if (s.indexOf(c) == i) {
                    builder.append(c);
                }
            }
        }

        return builder.toString();
    }
}
