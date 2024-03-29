package stream.task;

public class ProperFractions {

    public static int properFrac(int n) {
        return 1;

    }

    public static long functionGCD(long n) {
        return n < 2 ? 0 : properFractions(n);

    }

    public static long properFractions(long n) {
        double result = n;
        for (long p = 2; p * p <= n; ++p) {
            if (n % p == 0) {
                while (n % p == 0) {
                    n /= p;
                }
                result *= (1.0 - (1.0 / (double) p));
            }
        }
        if (n > 1) {
            result *= (1.0 - (1.0 / (double) n));
        }

        return (long) result;
    }
}



