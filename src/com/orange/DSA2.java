package com.orange;

import java.util.HashSet;
import java.util.Set;


/**
 * 删除字符串任意两个字符剩余字符无重复组合个数，
 * 例：”data”，删除任意两个字符，剩余字符组合个数为5，即”ta”, “aa”, “da”, “at”, “dt”
 *
 * 思考：
 * 1.排列组合数，数组中去中N个数的所有组合
 * 2.字符串的排列组合
 *
 */
public class DSA2 {
    public static void main(String[] args) {
        String data = "data";
        deleteElements(data);
    }

    private static void deleteElements(String data) {
        char[] chars = data.toCharArray();
        Set<String> subStrings = new HashSet<>();

        for (int i = 0; i < data.length(); i++) {
            for (int j = i + 1; j < data.length(); j++) {
                StringBuilder builder = new StringBuilder();
                for (int k = 0; k < chars.length; k++) {
                    if (k != i && k != j) {
                        builder.append(chars[k]);
                    }
                }
                subStrings.add(builder.toString());
            }
        }

        System.out.println(subStrings);

    }
}
