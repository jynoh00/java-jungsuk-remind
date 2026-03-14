package ch09;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.math.RoundingMode.*;

public class BigDecimalEx {
    public static void main(String[] args) {
        BigDecimal bd1 = new BigDecimal("123.456");
        BigDecimal bd2 = new BigDecimal("1.0");

        System.out.println(bd1.unscaledValue());
        System.out.println(bd2.unscaledValue());

        System.out.println(bd1.scale());
        System.out.println(bd2.scale());

        System.out.println(bd1.precision());
        System.out.println(bd2.precision());

        System.out.println();

        BigDecimal bd3 = bd1.multiply(bd2);
        System.out.println(bd3);

        System.out.println(bd3.unscaledValue());
        System.out.println(bd3.scale());
        System.out.println(bd3.precision());

        System.out.println(bd1.divide(bd2, 2, HALF_UP)); // 123.46
        System.out.println(bd1.setScale(2, HALF_UP)); // 123.46
        System.out.println(bd1.divide(bd2, new MathContext(2, HALF_UP))); // 1.2E+2
    }
}
