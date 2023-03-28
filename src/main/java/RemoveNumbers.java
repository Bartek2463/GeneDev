import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemoveNumbers {
    public static int lastNumberLeft(int N, int[] A) {
        List<Integer> collect = IntStream.of(A).sorted().boxed().collect(Collectors.toList());
        while (collect.size() > 1) {
            for (int i = collect.size() - 1; i >= 1; i--) {
                if (i % 2 != 0) {
                    Integer minInteger = collect.stream().min(Comparator.comparing(Integer::intValue)).get();
                    collect.remove(minInteger);
                    System.out.println("collect = " + collect);
                } else if (i % 2 == 0) {
                    Integer maxInteger = collect.stream().max(Comparator.comparing(Integer::intValue)).get();
                    collect.remove(maxInteger);
                    System.out.println("collect = " + collect);
                }
            }
        }
        return collect.get(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        sc.close();
        System.out.println("lastNumberLeft(N, A) = " + lastNumberLeft(N, A));
    }
}
