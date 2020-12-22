package week2.moodel;

public class TwoLoops {

    public static int twoLoops(int[] arr) {
        int comparisons = 0;
        int max = arr[0];
        int     indexMax = 0;
        for (int i = 1; i < arr.length; i++) {
            comparisons++;
            if (arr[i] > max) { //***** find MAX *****
                max = arr[i];
                indexMax = i;
            }
        }
        int min = arr[0];
        int indexMin = 0;
        for (int i = 1; i < arr.length; i++) {
            comparisons++;
            if (arr[i] < min) { //***** find MIN *****
                min = arr[i];
                indexMin = i;
            }
        }
        System.out.println("max = " + max + " indexMax = " + indexMax + " min = " + min +
                " indexMin = " + indexMin);
        return comparisons;
    }

    public static void main(String[] args) {
        int a[] = BuildArray.buildRandomArray();
        int aInc[] = BuildArray.buildSortIncreasingArray();
        int aDec[] = BuildArray.buildSortDecreasingArray();
        System.out.println("\n********** Two loops Random Array **********");
        int comp1 = twoLoops(a);
        System.out.println("comp1 = " + comp1);
        System.out.println("\n********** Two loops Increasing Array **********");
        comp1 = twoLoops(aInc);
        System.out.println("comp1 = " + comp1);
        System.out.println("\n********** Two loops Decreasing Array **********");
        comp1 = twoLoops(aDec);
        System.out.println("comp1 = " + comp1);
    }
}
