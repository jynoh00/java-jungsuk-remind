package ch09;

import java.math.BigInteger;

// long타입이라면, 20!까지밖에 계산 불가, `BigInteger`는 99! 그 이상도 얼마든지 가능하다.
// BigInteger의 최대값은 +-2의 Integer.MAX_VALUE ~= 대략 10^6억
public class BigIntegerEx {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i < 100; i++) {
            System.out.printf("%d! = %s%n", i, calcFactorial(i));
//            Thread.sleep(300); // 0.3s 지연
        }
    }

    static String calcFactorial(int n) {
        return factorial(BigInteger.valueOf(n)).toString();
    }

    static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO))
            return BigInteger.ONE; // 1

        return n.multiply(factorial(n.subtract(BigInteger.ONE))); // return n * factorial(n-1);
    }
}
