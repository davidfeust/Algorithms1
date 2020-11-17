package week3;

import java.util.Arrays;
import java.util.LinkedList;

public class Max1Max2 {

    static final int n = 10;
    static int[] arr;
    static int comp;

    public static void init() {
        comp = 0;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
    }

    //    return [max, index_of_max]
    public static int[] max(int s, int e) {
        int res = arr[0], index = 0;
        for (int i = s; i < e; i++) {
            if (arr[i] > res) {
                res = arr[i];
                index = i;
            }
            comp++;
        }
        return new int[]{res, index};
    }

    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //  Naive algo
    public static int[] algo1() {
        int[] max1 = max(1, n);
        swap(max1[1], n - 1);
        int[] max2 = max(1, n - 1);
        return new int[]{max1[0], max2[0]};
    }

    public static int[] algo2() {
        int max1, max2;
        if (arr[0] > arr[1]) {
            max1 = arr[0];
            max2 = arr[1];
        } else {
            max1 = arr[1];
            max2 = arr[0];
        }
        comp++;
        for (int i = 2; i < n; i++) {
            if (arr[i] > max1) {
                max2 = max1;
                max1 = arr[i];
                comp++;
            } else if (arr[i] > max2) {
                max2 = arr[i];
                comp += 2;
            } else {
                comp += 2;
            }
        }
        return new int[]{max1, max2};
    }

    public static int[] algo3() {
        int max1, max2;
        if (arr[0] > arr[1]) {
            max1 = arr[0];
            max2 = arr[1];
        } else {
            max1 = arr[1];
            max2 = arr[0];
        }
        comp++;
        for (int i = 2; i < n - 1; i += 2) {
            if (arr[i] > arr[i + 1]) {
                if (arr[i] > max1) {
                    max2 = max1;
                    max1 = arr[i];
//                    comp+=2;
                } else if (arr[i] > max2) {
                    max2 = arr[i];
                }
            } else {
                if (arr[i + 1] > max1) {
                    max2 = max1;
                    max1 = arr[i + 1];
//                    comp+=2;
                } else if (arr[i + 1] > max2) {
                    max2 = arr[i + 1];
                }
            }
            comp += 3;
        }
        if (n % 2 != 0) {
            if (arr[n - 1] > max1) {
                max1 = arr[n - 1];
            } else if (arr[n - 1] > max2) {
                max2 = arr[n - 1];
            }
        }
        return new int[]{max1, max2};
    }

    private static int algo4(Node[] a, int s, int e) {
        int max1, max2;
        if (s >= e)
            return s;
        int index = 0, middle = (s + e) / 2;
        int i = algo4(a, s, middle);
        int j = algo4(a, middle + 1, e);
        if (a[i].num > a[j].num) {
            a[i].s.push(a[j].num);
            index = i;
        } else {
            a[j].s.push(a[i].num);
            index = j;
        }
        return index;
    }

    public static int[] algo4() {
        init();
        Node[] a = new Node[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Node(arr[i]);
        }
        int index = algo4(a, 0, n - 1);
        int max1 = arr[index];
        int max2 = a[index].s.pop();
        while (!a[index].s.isEmpty()) {
            int temp = a[index].s.pop();
            if (temp > max2) {
                max2 = temp;
            }
        }
        return new int[] {max1, max2};
    }

    public static int algo5() {
        int max1, max2;
        LinkedList<Integer> ll = new LinkedList<>();
        Iterable<Integer> it = new LinkedList<>();
        ll.add(5);
        it.iterator();
//        Iterator<String> names = new EndlessIterator<>("John");
        return 0;
    }

    public static void test1() {
        init();
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(algo1()));
        System.out.println("The amount of comparisons in algo1: (" + comp +
                " == (2n - 3))=" + (2 * n - 3) + ") ? " + (comp == 2 * n - 3));
    }

    public static void test2() {
        init();
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(algo2()));
        System.out.println("The amount of comparisons in algo2: (" + comp +
                " <= (2n - 3)= " + (2 * n - 3) + ") ? " + (comp <= 2 * n - 3));
    }

    public static void test3() {
        init();
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(algo3()));
        System.out.println("The amount of comparisons in algo3: (" + comp +
                " == ((3n / 2) - 2)= " + (((3 * n) / 2) - 2) + ") ? " + (comp == ((3 * n) / 2) - 2));
    }

    public static void test4() {
        init();
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(algo4()));
//        System.out.println("The amount of comparisons in algo4: (" + comp +
//                " == (n - 1 + log(n) - 1)= " + (n - 1 + Math.log(n) - 1) + ") ? " + (comp == (n - 1 + Math.log(n) - 1)));
    }


    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
        algo5();
    }


}
