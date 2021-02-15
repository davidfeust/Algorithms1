package TestPractice;

import java.util.Arrays;
import java.util.Comparator;

class Prog {
    double len, prob;

    public Prog(double length, double prob) {
        this.len = length;
        this.prob = prob;
    }

    @Override
    public String toString() {
        return "{" + "l=" + len + ", p=" + prob + '}';
    }
}

public class Compiler2 {

    public static void probEqual(Prog[] a) {
        Arrays.sort(a, Comparator.comparingDouble(o -> o.len));
        System.out.println(totalTime(a));
        System.out.println(Arrays.toString(a));
    }

    public static void lengthEqual(Prog[] a) {
        Arrays.sort(a, Comparator.comparingDouble(o -> o.prob));
        System.out.println(totalTime(a));
        System.out.println(Arrays.toString(a));
    }

    public static void compiler(Prog[] a) {
        Arrays.sort(a, Comparator.comparingDouble(o -> o.len / o.prob));
        System.out.println(totalTime(a));
        System.out.println(Arrays.toString(a));
    }

    private static double totalTime(Prog[] a) {
        double totalTime;
        double totalLength;
        totalLength = totalTime = 0;
        for (Prog i : a) {
            totalLength += i.len;
            totalTime += totalLength * i.prob;
        }
        return totalTime;
    }


    public static void main(String[] args) {
        Prog[] p = {new Prog(4, 0.4), new Prog(8, 0.4), new Prog(2, 0.4), new Prog(10, 0.4)};
        probEqual(p);
        p = new Prog[]{new Prog(4, 0.4), new Prog(4, 0.8), new Prog(4, 0.1), new Prog(4, 1)};
        lengthEqual(p);
        p = new Prog[]{new Prog(4, 0.4), new Prog(8, 0.8), new Prog(2, 0.1), new Prog(10, 1)};
        compiler(p);

        System.out.println();
        Prog[] a = {new Prog(1, 2), new Prog(2, 2), new Prog(1, 3), new Prog(3, 1)};
        compiler(a);
    }
}
