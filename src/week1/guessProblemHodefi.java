package week1;

public class guessProblemHodefi {


    //check if the algo works
    public static void main(String[] a) {
        //algo 1: a choose random ,b choose random
        double sum = 0;
        int A = 0, B = 0, times = 1000000;
        for (int i = 0; i < times; i++) {
            A = (int) (Math.random() + 0.5);
            B = (int) (Math.random() + 0.5);
            if (A == B)
                sum++;
        }
        System.out.println("outcome 1 " + (sum / times) * 100 + "%");


        //algo 2: a choose 1 ,b choose 1
        A = 1;
        B = 1;
        sum = 0;
        int Acoin, Bcoin;

        for (int i = 0; i < times; i++) {
            Acoin = (int) (Math.random() + 0.5);
            Bcoin = (int) (Math.random() + 0.5);
            if (A == Bcoin || B == Acoin)
                sum++;
        }
        System.out.println("outcome 2 " + (sum / times) * 100 + "%");


        //algo 3: a choose Acoin ,b choose notBcoin
        sum = 0;
        for (int i = 0; i < times; i++) {
            Acoin = (int) (Math.random() + 0.5);
            Bcoin = (int) (Math.random() + 0.5);
            A = Acoin;
            B = (Bcoin + 1) % 2;
            if (A == Bcoin || B == Acoin)
                sum++;
        }
        System.out.println("outcome 3 " + (sum / times) * 100 + "%");
    }
}
