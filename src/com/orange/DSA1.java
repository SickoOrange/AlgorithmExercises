package com.orange;

/**
 * 按要求分解字符串，输入两个数M，N；M代表输入的M串字符串，N代表输出的每串字符串的位数，
 * 不够补0。例如：输入2,8， “abc” ，“123456789”，则输出为“abc00000”,“12345678“,”90000000”
 */
public class DSA1 {

    public static void main(String[] args) {
        String a = "1234567890";
        String b = "abc";
        splitString(a);

    }

    private static void splitString(String string) {
        if (string.length() < 8) {
            int n = 8 - string.length();
            StringBuilder stringBuilder = new StringBuilder(string);
            for (int i = 0; i < n; i++) {
                stringBuilder.append("0");
            }
            string = stringBuilder.toString();
            System.out.println(string);
        } else {
            String substring = string.substring(0, 8);
            System.out.println(substring);
            splitString(string.substring(8));
        }

    }
}
