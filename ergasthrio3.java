import java.util.*;

import javax.print.DocFlavor.STRING;

public class ergasthrio3 {

    public static String longestCommonPrefix(String[] strs) {
        int left = 0;
        int right = strs.length - 1;
        return findLCP(strs, left, right);
    }

    public static String findLCP(String[] strs, int left, int right) {
        int mid = (left + right) / 2;
        if (left == right) {
            return strs[left];

        }
        String lefString = findLCP(strs, left, mid);
        String righString = findLCP(strs, mid + 1, right);
        return commonPrefix(lefString, righString);

    }

    public static String commonPrefix(String str1, String str2) {
        String counter = "";
        int j = 0;

        while (j < str1.length() && j < str2.length() && str1.charAt(j) == str2.charAt(j)) {

            counter += str1.charAt(j);
            j++;
        }
        return counter;
    }

    public static void main(String[] args) {
        String[] words = { "programming", "progress", "proactive", "project" };
        System.out.println(longestCommonPrefix(words));
    }

}