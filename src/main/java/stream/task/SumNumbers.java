package stream.task;

import java.util.Scanner;
import java.util.stream.IntStream;

public class SumNumbers {
    private static int marged(int N, int[] A, int[] B) {

        Integer sumA = IntStream.of(A).boxed().reduce((a, b) -> a + b).get();

        Integer sumB = IntStream.of(B).boxed().reduce((a, b) -> a + b).get();

        int sumAB = Math.abs(sumA-sumB);
        System.out.println(sumAB);

        return 44;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        for (int i = 0;i<N;i++){
            A[i]=sc.nextInt();
        }
        for (int i = 0;i<N;i++){
            B[i]=sc.nextInt();
        }


        marged(N,A,B);
    }


}
