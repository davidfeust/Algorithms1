package TestPractice;

import java.util.Arrays;
import java.util.Comparator;

class Program {
    static int id_counter = 0;
    int id;
    double length, prob;

    public Program(double length, double prob) {
        this.id = id_counter++;
        this.length = length;
        this.prob = prob;
    }

    @Override
    public String toString() {
        return "{i=" + id + " l=" + length + ", p=" + prob + "}";
    }
}

public class CompilerProblem {

    public static void compilerProblem(Program[] a) {
        Arrays.sort(a, new Comparator<Program>() {
            @Override
            public int compare(Program o1, Program o2) {
                double t1 = o1.prob / o1.length;
                double t2 = o2.prob / o2.length;
                return Double.compare(t1, t2);
            }
        });
        System.out.println(Arrays.toString(a));
    }


    public static void main(String[] args) {
        Program[] a = {new Program(2, 0.56), new Program(5, 0.56), new Program(10, 0.86),
                new Program(8, 0.99), new Program(2.5, 0.25), new Program(4, 1)};
        compilerProblem(a);
    }
}
