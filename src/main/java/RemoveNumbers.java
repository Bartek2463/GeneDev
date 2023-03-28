import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemoveNumbers {
    public static int lastNumberLeft(int N, int[] A) {

        List<Integer> numbers = IntStream.of(A).sorted().boxed().collect(Collectors.toList());
       while (numbers.size()-1>0){
           for (int i = numbers.size()-1;i>0;i--){
               if (i%2!=0){
                   Integer minNumber = numbers.stream().min(Comparator.comparing(Integer::intValue)).get();
                   numbers.remove(minNumber);
                   System.out.println("numbers = " + numbers);
               }else {
                   Integer maxNumber = numbers.stream().max(Comparator.comparing(Integer::intValue)).get();
                   numbers.remove(maxNumber);
                   System.out.println("numbers = " + numbers);
               }
           }
       }

return numbers.get(0);

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
