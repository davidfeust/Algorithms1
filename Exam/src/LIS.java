import java.util.ArrayList;
import java.util.Arrays;

public class LIS {

    private final int[] arr; // input array
    private final int n; // size of arr
    private int[] help;
    private int[][] mat;
    private final int teta;
    private int length; // length of the longest increasing subsequences
    private int numOfAll; // number of all the longest increasing subsequences

    int[] lis;
    int[] count;

    public LIS(int[] arr, int teta) {
        this.arr = arr;
        this.teta = teta;
        this.n = arr.length;
        this.help = new int[n];
        this.mat = new int[n][];
        this.numOfAll = -1;
        this.length = -1;
    }

    public int lengthLIS() {
        if (length != -1) return length;
        help[0] = arr[0];
        int counter = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > help[counter - 1]) {
                help[counter++] = arr[i];
            } else {
                int index = binarySearch(help, counter - 2, arr[i]);
                help[index] = arr[i];
            }
        }
        length = counter;
        return length;
    }

    public int numOfLIS() {
        if (numOfAll != -1) return numOfAll;
        int max_size = 0;
        lis = new int[n];
        count = new int[n];
        Arrays.fill(lis, 1);
        Arrays.fill(count, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i]) {
                    if (lis[j] + 1 > lis[i]) {
                        lis[i] = lis[j] + 1;
                        count[i] = count[j];
                    } else if (lis[j] + 1 == lis[i]) {
                        count[i] += count[j];
                    }
                    max_size = Math.max(max_size, lis[i]);
                }
            }
        }
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if (lis[i] == max_size) counter += count[i];
        }
        numOfAll = counter;
        System.out.println("arr =\t" + Arrays.toString(arr));
        System.out.println("lis =\t" + Arrays.toString(lis));
        System.out.println("count =\t" + Arrays.toString(count));
        return numOfAll;
    }

    public int[][] allLIS() {
        if (numOfAll == -1) {
            numOfLIS();
        }
        if (numOfAll <= teta) {
            return allLISCalc();
        } else {
            return new int[][]{oneLISCalc()};
        }
    }

    private int[][] allLISCalc() {
        int[][] ans = new int[numOfAll][];
//        int[][][] t = new int[n][n][n];
//        int max_size = 0;
//        lis = new int[n];
//        count = new int[n];
//        Arrays.fill(lis, 1);
//        Arrays.fill(count, 1);
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if (arr[j] <= arr[i]) {
//                    if (lis[j] + 1 > lis[i]) {
//                        lis[i] = lis[j] + 1;
//                        count[i] = count[j];
//                    } else if (lis[j] + 1 == lis[i]) {
//                        count[i] += count[j];
//                    }
//                    max_size = Math.max(max_size, lis[i]);
//                }
//            }
//        }
//        int counter = 0;
//        for (int i = 0; i < n; i++) {
//            if (lis[i] == max_size) counter += count[i];
//        }
//        numOfAll = counter;














//        int c = 0;
//        for (int i = n - 1; i >= 0; i--) {
//            if (lis[i] == length) {
//                for (int j = 0; j < count[i]; j++) {
//                    int[] ints = new int[length];
//                    ints[length - 1] = arr[i];
//                    c = findAll(ints, i - j, length - 1, c, ans);
//                }
//            }
//        }
//        for (int[] i : ans) System.out.println(Arrays.toString(i));

//        int max_size = 0;
//        int[] lis = new int[n];
//        int[] count = new int[n];
//        Node[] all = new Node[n];
//        Arrays.fill(lis, 1);
//        Arrays.fill(count, 1);
//        all[0] = new Node(arr[0]);
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if (arr[i] >= arr[j]) {
//                    if (lis[j] + 1 > lis[i]) {
//                        lis[i] = lis[j] + 1;
//                        count[i] = count[j];
//                        if (all[i] == null && lis[j] == lis[i] - 1) {
//                            all[i] = new Node(all[j], arr[i]);
//                        } else if (lis[j] == lis[i] - 1){
//                            all[i].add(all[j], arr[i]);
//                        }
//                    } else if (lis[j] + 1 == lis[i]) {
//                        count[i] += count[j];
//                        if (all[i] == null) {
//                            all[i] = new Node(all[j], arr[i]);
//                        } else {
//                            all[i].add(all[j], arr[i]);
//                        }
//                    }
//                    max_size = Math.max(max_size, lis[i]);
//                } else {
//                    all[i] = new Node(arr[i]);
//                }
//            }
//        }
//        int counter = 0;
//        for (int i = 0; i < n; i++) {
//            if (lis[i] == max_size) counter += count[i];
//            all[i].print();
//        }
//        numOfAll = counter;
//        System.out.println("all = " + Arrays.toString(all));
        return null;
    }

    private int findAll(int[] ints, int index, int k, int c, int[][] ans) {
//        int k = length - 1;
        if (index >= 0) {
            for (int j = index - 1, l = 1; j >= 0; j--) {
                if (lis[j] + l == lis[index]) {
                    ints[--k] = arr[j];
                    l++;
//                    if (count[j] > 1)
                    int curr_count = count[j];
                    if (curr_count > 1) {
                        for (int i = 1; i <= curr_count; i++) {
                            c = findAll(Arrays.copyOf(ints, length), j, k, c, ans);
                        }
                    }
                }
                if (k == 0) {
                    ans[c++] = ints;
                    System.out.println("ints = " + Arrays.toString(ints));
                    return c;
                }
            }
        }
        return -1;
    }

    private int[] oneLISCalc() {
        help = new int[n];
        mat[0] = new int[1];
        mat[0][0] = help[0] = arr[0];
        int counter = 1;
        for (int i = 1; i < n; i++) {
            int index = binarySearch(help, counter - 1, arr[i]);

            if (index == counter) counter++;
            mat[index] = new int[index + 1];
            for (int j = 0; j < index; j++) mat[index][j] = mat[index - 1][j];

            mat[index][index] = help[index] = arr[i];
        }
        return mat[length - 1];
    }

    private int binarySearch(int[] arr, int start, int end, int value) {
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (arr[mid] < value) start = mid + 1;
            else if (arr[mid] > value) end = mid - 1;
            else return mid;
        }
        return start;
    }

    private int binarySearch(int[] arr, int end, int value) {
        return binarySearch(arr, 0, end, value);
    }

    class Node {

        ArrayList<int[]> arrayList;
        int index;


        public Node(int val) {
            arrayList = new ArrayList<>();
            arrayList.add(new int[]{val});
            index = 1;
        }

        public Node(Node node, int val) {
            arrayList = new ArrayList<>();
            index = node.index;
            for (int[] i : node.arrayList) {
                int[] temp = Arrays.copyOfRange(i, 0, length);
                temp[index++] = val;
                arrayList.add(temp);
            }
        }

        @Override
        public String toString() {
            String sb = "{";// + Arrays.toString(arrayList.toArray()) + '}';
            for (int[] i : arrayList) {
                sb += Arrays.toString(i) + "; ";
            }
            return sb + "}";
        }

        public void add(Node node, int val) {
            for (int[] i : node.arrayList) {
                int[] temp = Arrays.copyOfRange(i, 0, length);
                temp[node.index] = val;
                arrayList.add(temp);
            }
            index = node.index + 1;
        }

        public void print() {
            for (int[] i : arrayList) {
                if (index == length) {
                    System.out.println(Arrays.toString(i));
                }
            }
        }
    }
}
