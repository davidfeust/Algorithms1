package week7;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LISTest {

    public static int[] arrays_creator(int seed) {
        Random _ran = new Random(seed);
        int n = 10;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = _ran.nextInt(15);
        }
        return res;
    }

    @Test
    public void greedy() {
        int[] arr1 = arrays_creator(1);
        System.out.println(Arrays.toString(arr1));
        assertArrayEquals(new int[]{0, 13}, LIS.greedy(arr1));
        System.out.println("the LIS is: " + Arrays.toString(LIS.greedy(arr1)));
    }

    @Test
    public void improvedGreedy() {
        int[] arr1 = arrays_creator(1);
        System.out.println(Arrays.toString(arr1));
        assertArrayEquals(new int[]{0, 13, 14, 14}, LIS.improvedGreedy(arr1));
        System.out.println("the LIS is: " + Arrays.toString(LIS.improvedGreedy(arr1)));
    }

    @Test
    void allCombinations() {
        ArrayList<int[]> t = LIS.allCombinations(new int[]{1, 2, 3, 4});
        printSortedList(t);
    }

    @Test
    void fullSearchRising() {
        int[] arr1 = arrays_creator(1);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(LIS.fullSearchRising(arr1)));
    }

    @Test
    void fullSearchDecline() {
        int[] arr1 = arrays_creator(1);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(LIS.fullSearchDecline(arr1)));
    }

    @Test
    void allLIS() {
        int[] arr1 = arrays_creator(1);
        System.out.println(Arrays.toString(arr1));
        ArrayList<int[]> list = LIS.allLIS(arr1);
        System.out.println("amount of all the LIS is: " + list.size());
        printSortedList(list);
    }

    private void printSortedList(List<int[]> list) {
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1.length < o2.length) return -1;
                if (o1.length > o2.length) return 1;
                return Arrays.compare(o1, o2);
            }
        });
        for (int[] i : list) {
            System.out.println(Arrays.toString(i));
        }
    }
}