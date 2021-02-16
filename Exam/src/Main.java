import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] a = {20, 1, 5, 4, 7, 8, 2, 10};
        int[] b = {0, 19, 3, 5, 11, -3, 4, 7, 2};
//        System.out.println("Q1.lis(a) = " + Q1.lis(a));
        System.out.println("Q1.lcs(a,b) = " + Arrays.toString(Q1.lcs(a, b)));
        System.out.println("Q1.lcsIncrease(a, b) = " + Q1.lcsIncrease(a, b));

//        Node[][] mat = {
//                {new Node(2,4),new Node(7,1),new Node(2,2),new Node(0,2),},
//                {new Node(1,3),new Node(5,2),new Node(2,1),new Node(0,3),},
//                {new Node(8,1),new Node(4,4),new Node(3,4),new Node(0,1),},
//                {new Node(2,0),new Node(2,0),new Node(2,0),new Node(0,0),},
//        };
//        Node[][] mat2 = {
//                {new Node(5,2),new Node(2,1),new Node(0,3),},
//                {new Node(4,4),new Node(3,4),new Node(0,1),},
//                {new Node(2,0),new Node(2,0),new Node(0,0),},
//        };
//        System.out.println("Q2.numOfPaths(mat) = " + Q2.numOfPaths(mat2));
//        System.out.println();
//        NodePQ[][] mat3 = {
//                {new NodePQ(2,4),new NodePQ(7,1),new NodePQ(2,2),new NodePQ(0,2),},
//                {new NodePQ(1,3),new NodePQ(5,2),new NodePQ(2,1),new NodePQ(0,3),},
//                {new NodePQ(8,1),new NodePQ(4,4),new NodePQ(3,4),new NodePQ(0,1),},
//                {new NodePQ(2,0),new NodePQ(2,0),new NodePQ(2,0),new NodePQ(0,0),},
//        };
//        System.out.println("Q2.numOfPathsPQ(mat2, 4,4) = " + Q2.numOfPathsPQ(mat3, 1, 0));
    }
}
