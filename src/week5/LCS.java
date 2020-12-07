package week5;

import java.util.ArrayList;

public class LCS {

    // O(nm)
    private static String greedyHelper1(String x, String y) {
        String res = "";
        int start = 0;
        for (int i = 0; i < x.length(); i++) {
            int index = y.indexOf(x.charAt(i), start);
            if (index != -1) {
                res += x.charAt(i);
                start = index + 1;
            }
        }
        return res;
    }

    public static String greedy1(String x, String y) {
        String a = greedyHelper1(x, y);
        String b = greedyHelper1(y, x);
        if (a.length() > b.length()) return a;
        else return b;
    }

    // O(n)
    public static int[] abcArray(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = Character.toLowerCase(c);
            }
            arr[c - 'a']++;
        }
        return arr;
    }

    // O(n + m)
    private static String greedyHelper2(String x, String y) {
        String res = "";
        int start = 0;
        int[] help = abcArray(x);
        for (int i = 0; i < y.length(); i++) {
            char c = y.charAt(i);
            if (help[c - 'a'] > 0) {
                int index = x.indexOf(y.charAt(i), start);
                res += c;
                start = index + 1;
                help[c - 'a']--;
            }
        }
        return res;
    }


    public static String greedy2(String x, String y) {
        String a = greedyHelper2(x, y);
        String b = greedyHelper2(y, x);
        if (a.length() > b.length()) return a;
        else return b;
    }

    /**
     * add 1 to binary number
     * the number are represent in array that every cell contains 1 or 0
     * @param bin
     */
    public static void plus1(int[] bin) {
        int i = bin.length - 1;
        while (i >= 0 && bin[i] == 1) {
            bin[i--] = 0;
        }
        if (i >= 0) bin[i] = 1;
    }

    /**
     * return all the sub string of the giving string s
     * @param s
     * @return
     */
    public static String[] allSubStrings(String s) {
        int n = s.length();
        int count = (int) (Math.pow(2, n) - 1);
        String[] list = new String[count];
        int[] bin = new int[n];

        for (int i = 0; i < count; i++) {
            plus1(bin);
            String t = "";

            for (int j = 0; j < n; j++) {
                if (bin[j] == 1) {
                    t = t + s.charAt(j);
                }
            }
            list[i] = t;
        }
        return list;
    }

    public static String checkCommon(String sub, String s) {
        String res = "";
        int index = -1;
        for (int i = 0; i < sub.length(); i++) {
            char c = sub.charAt(i);
            for (int j = index + 1; j < s.length(); j++) {
                if (c == s.charAt(j)) {
                    index = j;
                    res = res + s.charAt(j);
                    break;
                }
            }
        }
        if (res.length() == sub.length())
            return res;
        else
            return "";
    }

    public static ArrayList<String> fullSearch(String x, String y) {
        ArrayList<String> result = new ArrayList<>();
        String[] allSubStr;
        int maxLength = 0;
        int lengthX = x.length();
        int lengthY = y.length();
        String longest;
        if (lengthX > lengthY) {
            allSubStr = allSubStrings(y);
            longest = x;
        } else {
            allSubStr = allSubStrings(x);
            longest = y;
        }
        for (String s : allSubStr) {
            String common = checkCommon(s, longest);
            if (common.length() > maxLength)
                maxLength = common.length();
            if (!common.equals(""))
                result.add(common);
        }
        ArrayList<String> result1 = new ArrayList<>();
        for (String s : result) {
            if (s.length() == maxLength)
                result1.add(s);
        }
        return result1;
    }
}
