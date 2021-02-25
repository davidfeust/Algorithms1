//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class LIS3 {
//
//    private final int[] arr; // input array
//    private final int n; // size of arr
//    private int[] help;
//    private int[][] mat;
//    private final int teta;
//    private int length; // length of the longest increasing subsequences
//    private int numOfAll; // number of all the longest increasing subsequences
//
//    public LIS3(int[] arr, int teta) {
//        this.arr = arr;
//        this.teta = teta;
//        this.n = arr.length;
//        this.help = new int[n];
//        this.mat = new int[n][];
//        this.numOfAll = -1;
//        this.length = -1;
//    }
//
//    public int lengthLIS() {
//        if (length != -1) return length;
//        help[0] = arr[0];
//        int counter = 1;
//        for (int i = 1; i < n; i++) {
//            if (arr[i] > help[counter - 1]) {
//                help[counter++] = arr[i];
//            } else {
//                int index = binarySearch(help, counter - 2, arr[i]);
//                help[index] = arr[i];
//            }
//        }
//        length = counter;
//        return length;
//    }
//
//    public int numOfLIS() {
//        if (numOfAll != -1) return numOfAll;
//        int max_size = 0;
//        int[] lis = new int[n];
//        int[] count = new int[n];
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
//        System.out.println("arr =\t" + Arrays.toString(arr));
//        System.out.println("lis =\t" + Arrays.toString(lis));
//        System.out.println("count =\t" + Arrays.toString(count));
//        return numOfAll;
//    }
//
//    public int[][] allLIS() {
//        if (numOfAll == -1) {
//            numOfLIS();
//        }
//        if (numOfAll <= teta) {
//            return allLISCalc();
//        } else {
//            return new int[][]{oneLISCalc()};
//        }
//    }
//
//    private int[][] allLISCalc() {
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
//                        if (all[i] == null)
//                            all[i] = new Node(all[j], arr[i]);
//                        else if (all[i].index -1 == count[i])
//                            all[i].add(all[j], arr[i]);
//                    } else if (lis[j] + 1 == lis[i]) {
//                        count[i] += count[j];
//                        for (int k = i; k >= 0; k--) {
//                            if (count[k] - 1 == count[i]) {
//                                all[i].add(arr[i]);
//                            }
//                        }
////                        all[i].
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
//        }
//        numOfAll = counter;
//        System.out.println("all = " + Arrays.toString(all));
//        return null;
//
//
////        help = new int[n];
//////        int[][] m = new int[][];
////        mat[0] = new int[1];
////        mat[0][0] = help[0] = arr[0];
////        int[][] ans = new int[numOfAll][length];
////        int counter = 1;
////        int k = 0;
////        for (int i = 1; i < n; i++) {
////            int index = binarySearch(help, counter - 1, arr[i]);
////            if (index == counter) counter++;
////
////            mat[index] = new int[index + 1];
////            for (int j = 0; j < index; j++) mat[index][j] = mat[index - 1][j];
////            mat[index][index] = help[index] = arr[i];
////            if (index + 1 == length) ans[k++] = mat[index];
////            System.out.println("mat[index] = mat[" + index + "] =" + Arrays.toString(mat[index]));
////        }
////        return ans;
//    }
//
//    //    private int[][] allLISCalc() {
////        help = new int[n];
////        mat[0] = new int[1];
////        mat[0][0] = help[0] = arr[0];
////        int[][] ans = new int[numOfAll][length];
////        int counter = 1;
////        int k = 0;
////        for (int i = 1; i < n; i++) {
////            int index = binarySearch(help, counter - 1, arr[i]);
////            if (index == counter) counter++;
////
////            mat[index] = new int[index + 1];
////            for (int j = 0; j < index; j++) mat[index][j] = mat[index - 1][j];
////            mat[index][index] = help[index] = arr[i];
////            if (index + 1 == length) ans[k++] = mat[index];
////            System.out.println("mat[index] = mat[" + index + "] =" + Arrays.toString(mat[index]));
////        }
////        return ans;
////    }
////
//    private int[] oneLISCalc() {
//        help = new int[n];
//        mat[0] = new int[1];
//        mat[0][0] = help[0] = arr[0];
//        int counter = 1;
//        for (int i = 1; i < n; i++) {
//            int index = binarySearch(help, counter - 1, arr[i]);
//
//            if (index == counter) counter++;
//            mat[index] = new int[index + 1];
//            for (int j = 0; j < index; j++) mat[index][j] = mat[index - 1][j];
//
//            mat[index][index] = help[index] = arr[i];
//        }
//        return mat[length - 1];
//    }
//
//    private int binarySearch(int[] arr, int start, int end, int value) {
//        while (start <= end) {
//            int mid = (start + end) >>> 1;
//            if (arr[mid] < value) start = mid + 1;
//            else if (arr[mid] > value) end = mid - 1;
//            else return mid;
//        }
//        return start;
//    }
//
//    private int binarySearch(int[] arr, int end, int value) {
//        return binarySearch(arr, 0, end, value);
//    }
//
//    class Node {
//
//        ArrayList<int[]> arrayList;
//        int index;
//
//        public Node(Node node, int val) {
//            arrayList = new ArrayList<>();
//            for (int[] i : node.arrayList) {
//                index = node.index;
//                int[] temp = Arrays.copyOfRange(i, 0, length);
//                temp[index++] = val;
//                arrayList.add(temp);
//            }
//
//        }
//
//        public Node(int val) {
//            arrayList = new ArrayList<>();
//            int[] temp = new int[length];
//            temp[0] = val;
//            arrayList.add(temp);
//            index = 1;
//        }
//
//        public void add(int val) {
//            ArrayList<int[]> newArrayList = new ArrayList<>();
//            for (int[] i : arrayList) {
//                int[] temp = Arrays.copyOfRange(i, 0, length);
//                temp[index++] = val;
//                newArrayList.add(temp);
//            }
//            this.arrayList = newArrayList;
//        }
//
//        @Override
//        public String toString() {
//            String sb = "{";// + Arrays.toString(arrayList.toArray()) + '}';
//            for (int[] i : arrayList) {
//                sb += Arrays.toString(i) + "; ";
//            }
//            return sb + "}";
//        }
//
//        public void add(Node node, int val) {
//            arrayList = new ArrayList<>();
//            for (int[] i : node.arrayList) {
//                index = node.index;
//                int[] temp = Arrays.copyOfRange(i, 0, length);
//                temp[index++] = val;
//                arrayList.add(temp);
//            }
////            int[] temp =
//        }
//    }
//}
