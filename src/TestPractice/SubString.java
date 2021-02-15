package TestPractice;

public class SubString {

    public static String subString(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        int[] h = new int[24];
        for (int i = 0; i < n; i++) {
            h[s.charAt(i) - 'a']++;
        }
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (h[c - 'a'] > 0) {
                ans.append(c);
                h[c - 'a'] = 0;
            }
            i++;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println("subString(\"abcabcbb\") = " + subString("abcabcbb"));
        System.out.println("subString(\"bbbbb\") = " + subString("bbbbb"));
        System.out.println("subString(\"pwwkew\") = " + subString("pwwkew"));
    }
}
