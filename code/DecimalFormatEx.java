package ch10;

import java.text.DecimalFormat;

public class DecimalFormatEx {
    public static void main(String[] args) {
        double number = 1234567.89;
        String[] pattern = {"0",
                "#",
                "0.0",
                "#.#",
                "0000000000.0000",
                "##########.####",
                "#.#-",
                "-#.#",
                "#,###.##",
                "#E0",
                "0E0",
                "##E0",
                "00E0",
        };

        for (String s : pattern) {
            DecimalFormat df = new DecimalFormat(s);
            System.out.println(s + ": " + df.format(number));
        }
    }
}
