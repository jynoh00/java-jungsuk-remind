package ch10;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatterEx {
    public static void main(String[] args) {
        test1();
        System.out.println("--");
        test2();
    }

    private static void test1() {
        ZonedDateTime zdt = ZonedDateTime.now();
        String[] patternArr = {
                "yyyy-MM-dd HH:mm:ss",
                "''yy년 MMM dd일 E요일",
                "yyyy-MM-dd HH:mm:ss.SSS Z VV",
                "yyyy-MM-dd hh:mm:ss a",
                "올해의 D번째 날",
                "이달의 d번째 날",
                "올해의 w번째 주",
                "이 달의 W번째 주",
                "이 달의 W번째 E요일",
        };

        for (String p : patternArr) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(p);
            System.out.println(formatter.format(zdt));
        }
    }

    private static void test2() {
        LocalDate newYear = LocalDate.parse("2024-01-01", DateTimeFormatter.ISO_LOCAL_DATE);

        LocalDate date = LocalDate.parse("2001-01-01");
        LocalTime time = LocalTime.parse("23:59:59");
        LocalDateTime ldt = LocalDateTime.parse("2001-01-01T23:59:59");

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime endOfYear = LocalDateTime.parse("2024-12-31 23:59:59", pattern);

        System.out.println(newYear);
        System.out.println(date);
        System.out.println(time);
        System.out.println(ldt);
        System.out.println(endOfYear);
    }
}
