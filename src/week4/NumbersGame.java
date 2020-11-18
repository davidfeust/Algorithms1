package week4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class NumbersGame {

    private static final int _n = 10; // needs to be even
    static Random _rand = new Random();
    static Heap h = new Heap(_n);
    private static int[] _arr;
    private static int _start = 0, _end = _n - 1;

    private static void init() {
//        _arr = new int[]{5, 20, 10, 1};
        _arr = new int[_n];
        for (int i = 0; i < _n; i++) {
            _arr[i] = nextRnd(0, 20);
        }
//        initHeap();
    }

    private static int sum(boolean even, int s, int e) {
        int res = 0;
        for (int i = s; i < e; i++) {
            if (even && i % 2 == 0) res += _arr[i];
            else if (!even && i % 2 != 0) res += _arr[i];
        }
        return res;
    }

    private static void printArrRange(int start, int end) {
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < _n; i++) {
            if (i >= start && i <= end)
                s.append(_arr[i]).append(i == end ? "" : "\t\t");
            else s.append("\t\t");
        }
        s.append("]\n[");
        for (int i = 0; i < _n; i++) {
            s.append(i).append(i != _n - 1 ? "\t\t" : "]");
        }
        System.out.println(s);
    }

    private static int startOrEnd(String s) {
        if (s.equals("s")) {
            return _arr[_start++];
        }
        if (s.equals("e")) {
            return _arr[_end--];
        }
        return -1;
    }

    private static int playerChoose() {
        Scanner input = new Scanner(System.in);
        int res;
        String p;
        do {
            p = input.next();
            res = startOrEnd(p);
            if (res != -1) return res;
            System.err.println("Enter s \\ e!");
        }
        while (true);
    }

    private static int level() {
        Scanner in = new Scanner(System.in);
        do {
            if (in.hasNextInt()) {
                int res = in.nextInt();
                if (res <= 10 && res > 0) return res;
                System.err.println("enter number 1 - 10!");
            } else {
                String trash = in.next();
                System.err.println("enter number!");
            }
        } while (true);
    }


    /**
     * 2 players game
     * the hint is for even / odd strategy
     */
    public static void game1() {
        init();
        int sum1 = 0, sum2 = 0;
        System.out.println("Hint: even places = " + sum(true, 0, _n) + ", odd places = " + sum(false, 0, _n));
        while (_start != _end) {
            printArrRange(_start, _end);
            System.out.println("Player 1 (" + sum1 + "):\n choose s \\ e:\t" + _arr[_start] + " \\ " + _arr[_end]);
            sum1 += playerChoose();
            printArrRange(_start, _end);
            System.out.println("Player 2 (" + sum2 + "):\n choose s \\ e:\t" + _arr[_start] + " \\ " + _arr[_end]);
            if (_start == _end) sum2 += _arr[_start];
            else sum2 += playerChoose();
            System.out.println();
        }
        System.out.println("The winner is player number " + (sum1 > sum2 ? "1" : "2") + "!");
        System.out.println("Player 1 get " + sum1 + ", Player 2 get " + sum2);
    }

    /**
     * player vs computer
     * computer first
     */
    public static void game2() throws InterruptedException {
        init();
        int player = 0, comp = 0;
        int even = sum(true, 0, _n), odd = sum(false, 0, _n);
        boolean e = even >= odd;
        System.out.println("Hint: even places = " + even + ", odd places = " + odd);
        while (_start != _end) {
            printArrRange(_start, _end);
            System.out.println("Computer (" + player + "):\n choose s \\ e:\t" + _arr[_start] + " \\ " + _arr[_end]);
            String str;
            if (e && _start % 2 == 0) str = "s";
            else if (e) str = "e";
            else if (_start % 2 != 0) str = "s";
            else str = "e";
            TimeUnit.SECONDS.sleep(1);
            int compChoo = startOrEnd(str);
            comp += compChoo;
            System.out.println("Computer selected: " + compChoo);
            printArrRange(_start, _end);
            System.out.println("Player 2 (" + player + "):\n choose s \\ e:\t" + _arr[_start] + " \\ " + _arr[_end]);
            if (_start == _end) player += _arr[_start];
            else player += playerChoose();
            System.out.println();
        }
        System.out.println("The winner is the  Computer!");
        System.out.println("Computer get " + comp + ", Player get " + player);
    }

    /**
     * player vs computer
     * computer first
     * uses the adaptive strategy
     */
    public static void game3() throws InterruptedException {
        init();
        int player = 0, comp = 0;
        while (_start != _end) {
            int even = sum(true, _start, _end + 1), odd = sum(false, _start, _end + 1);
            boolean e = even >= odd;
            System.out.println("Hint: even places = " + even + ", odd places = " + odd);
            printArrRange(_start, _end);
            System.out.println("Computer (" + player + "):\n choose s \\ e:\t" + _arr[_start] + " \\ " + _arr[_end]);
            String str;
            if (e && _start % 2 == 0) str = "s";
            else if (e) str = "e";
            else if (_start % 2 != 0) str = "s";
            else str = "e";
            TimeUnit.SECONDS.sleep(1);
            int compChoo = startOrEnd(str);
            comp += compChoo;
            System.out.println("Computer selected: " + compChoo);
            printArrRange(_start, _end);
            System.out.println("Player 2 (" + player + "):\n choose s \\ e:\t" + _arr[_start] + " \\ " + _arr[_end]);
            if (_start == _end) player += _arr[_start];
            else player += playerChoose();
            System.out.println();
        }
        System.out.println("The winner is the  Computer!");
        System.out.println("Computer get " + comp + ", Player get " + player);
    }

    /**
     * player vs computer
     * computer first
     * uses the adaptive strategy
     * with levels (1, 10)
     */
    public static void game4() throws InterruptedException {
        init();
        int player = 0, comp = 0;
        System.out.println("Select a level 1 - 10 :\n");
        int level = level();
        int i = 1;
        while (_start != _end) {
            int even = sum(true, _start, _end + 1), odd = sum(false, _start, _end + 1);
            boolean e = even >= odd;
            System.out.println("Hint: even places = " + even + ", odd places = " + odd);
            printArrRange(_start, _end);
            System.out.println("Computer (" + comp + "):\n choose s \\ e:\t" + _arr[_start] + " \\ " + _arr[_end]);
            String str;
            if (e && _start % 2 == 0) str = "s";
            else if (e) str = "e";
            else if (_start % 2 != 0) str = "s";
            else str = "e";
            if (Math.random() > 0.1 * level) {
                str = (str.equals("e") ? "s" : "e");
                System.out.println("M");
            }
            TimeUnit.SECONDS.sleep(1);
            int compChoo = startOrEnd(str);
            comp += compChoo;
            System.out.println("Computer selected: " + compChoo);
            printArrRange(_start, _end);
            even = sum(true, _start, _end + 1);
            odd = sum(false, _start, _end + 1);
            System.out.println("Hint: even places = " + even + ", odd places = " + odd);
            System.out.println("Player (" + player + "):\n choose s \\ e:\t" + _arr[_start] + " \\ " + _arr[_end]);
            if (_start == _end) player += _arr[_start];
            else player += playerChoose();
            System.out.println();
        }
        System.out.println("The winner is the " + (comp > player ? "Computer!" : "Player!"));
        System.out.println("Computer get " + comp + ", Player get " + player);
    }

    /**
     * player vs computer
     * player first
     * uses the adaptive strategy
     */
    public static void game5() throws InterruptedException {
        init();
        int player = 0, comp = 0;
        while (_start != _end) {
            int even = sum(true, _start, _end + 1), odd = sum(false, _start, _end + 1);
            boolean e = even >= odd;
            System.out.println("Hint: even places = " + even + ", odd places = " + odd);
            printArrRange(_start, _end);
            System.out.println("Player (" + player + "):\n choose s \\ e:\t" + _arr[_start] + " \\ " + _arr[_end]);
            if (_start == _end) player += _arr[_start];
            else player += playerChoose();

            even = sum(true, _start, _end + 1);
            odd = sum(false, _start, _end + 1);
            e = even >= odd;
            System.out.println("Hint: even places = " + even + ", odd places = " + odd);
            printArrRange(_start, _end);
            System.out.println("Computer (" + comp + "):\n choose s \\ e:\t" + _arr[_start] + " \\ " + _arr[_end]);
            String str;
            if (e && _start % 2 == 0) str = "s";
            else if (e) str = "e";
            else if (_start % 2 != 0) str = "s";
            else str = "e";
            TimeUnit.SECONDS.sleep(1);
            if (_start == _end) comp += _arr[_start];
            else {
                int compChoo = startOrEnd(str);
                comp += compChoo;
                System.out.println("Computer selected: " + compChoo);
            }
            System.out.println();
        }
        System.out.println("The winner is the " + (comp > player ? "Computer!" : "Player!"));
        System.out.println("Computer get " + comp + ", Player get " + player);
    }
    ///////////////

    private static int nextRnd(int min, int max) {
        double v = nextRnd(0.0 + min, max);
        return (int) v;
    }

    private static double nextRnd(double min, double max) {
        double d = _rand.nextDouble();
        double dx = max - min;
        return d * dx + min;
    }

    public static void main(String[] args) throws InterruptedException {
//        game1();
//        game2();
//        game3();
//        game4();
        game5();
//        init();
//        System.out.println(h);
    }

    public static void initHeap() {
        h._arrNodes[1] = new Heap.Node(0, _n - 1, 1);
        for (int i = 2; i < h._arrNodes.length; i++) {
            Heap.Node parent = h._arrNodes[h.parent(i)];
            if (h.leftChild(parent.ind) == i)
                h._arrNodes[i] = new Heap.Node(parent.start + 1, parent.end, i);
            else
                h._arrNodes[i] = new Heap.Node(parent.start, parent.end - 1, i);
            if (h.isLeaf(i)) {
                h._arrNodes[i]._sum = _arr[h._arrNodes[i].start];
            }
        }
        for (int i = ((h._arrNodes.length - 1) / 2); i > 0; i--) {
            int left = h.leftChild(i);
            int right = h.leftChild(i);
            System.out.println(i);
//            h._arrNodes[i]._left_sum
            h._arrNodes[i]._sum = Math.max(h._arrNodes[left]._sum, h._arrNodes[right]._sum);
        }
    }

    private static class Heap {

        private Node[] _arrNodes;
        private int _n;

        public Heap(int n) {
            this._arrNodes = new Node[(int) Math.pow(2, n)];
            this._n = n;
        }

        public int parent(int i) {
            return i / 2;
        }

        public int leftChild(int p) {
            return 2 * p;
        }

        public int rightChild(int p) {
            return 2 * p + 1;
        }

        @Override
        public String toString() {
            return "Heap{" +
                    Arrays.toString(_arrNodes) +
                    '}';
        }


        private boolean isLeaf(int i) {
            return leftChild(i) >= _arrNodes.length;
        }

        private static class Node {
            int start, end, ind;
            int _sum;
            int _left_sum;
            int _right_sum;

            public Node(int start, int end, int ind) {
                this.start = start;
                this.end = end;
                this.ind = ind;
            }

            @Override
            public String toString() {
                return "[" + start + ", " + end + "]:" + _sum;
            }
        }
    }
}
