import java.math.BigInteger;

public class Fibonacci {

    public static BigInteger fibonacciSum(int n) {
        BigInteger prev = BigInteger.ONE;
        BigInteger curr = BigInteger.ONE;
        BigInteger next = BigInteger.ZERO;
        if (n <= 1){
            return BigInteger.ONE;
        }
        else {
            for (int j = 1; j < n; j++) {
                next = prev.add(curr);
                prev = curr;
                curr = next;
            }
        }
        return curr;
    }

    public static void main(String[] args){
        System.out.println(fibonacciSum(4));
    }

}
