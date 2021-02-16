import java.util.HashMap;

interface Condition {
    public boolean condition(int x, int y);
}

public class LongestSeqCondition {

    public static int longestSeqSqrtPowInNTimes(int[] a) {
        int n = a.length;
        HashMap<Integer, Integer> h = new HashMap<>();
        int ans = 0;
        for (int i = 1; i < n; i++) {
            int max = 1;
            Integer x = h.get(a[i] * a[i]);
            Integer y = h.get((int) Math.sqrt(a[i]));
            if (x != null) max = Math.max(max, x + 1);
            if (y != null && (int) Math.sqrt(a[i]) == Math.sqrt(a[i])) max = Math.max(max, y + 1);
            h.put(a[i], max);
            ans = Math.max(ans, max);
        }
//        System.out.println(Arrays.toString(h));
        return ans;
    }

    public static int longestSeq(int[] a, Condition c) {
        int n = a.length;
        int[] h = new int[n];
        h[0] = 1;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (c.condition(a[j], a[i])) {
                    max = Math.max(max, h[j] + 1);
                }
            }
            h[i] = max;
            ans = Math.max(ans, max);
        }
//        System.out.println(Arrays.toString(h));
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 1, 49, 3, 4, 1, 9, 2, 30, 81};
        Condition lis = (x, y) -> x > y;
        Condition sqrtPow = (x, y) -> x * x == y || y * y == x;
        Condition small1 = (x, y) -> Math.abs(x - y) <= 1;
        Condition odd = (x, y) -> x % 2 == 1 && y % 2 == 1;
        Condition abs = (x, y) -> Math.abs(x - y) == 4;
        System.out.println("longestSeq(a, lis) = " + longestSeq(a, lis));
        System.out.println("longestSeq(a, sqrtPow) = " + longestSeq(a, sqrtPow));
        System.out.println("longestSeq(a, small1) = " + longestSeq(a, small1));
        System.out.println("longestSeq(a, small1) = " + longestSeq(a, odd));
        System.out.println("longestSeqSqrtPowInNTimes(a) = " + longestSeqSqrtPowInNTimes(a));

    }
}


