package ch10;

import java.time.*;

public class ZonedDateTimeEx {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2024, 12, 31);
        LocalTime time = LocalTime.of(12, 34, 56);

        LocalDateTime ldt = LocalDateTime.of(date, time);

        ZoneId zid = ZoneId.of("Asia/Seoul");
        ZonedDateTime zdt = ldt.atZone(zid);

        ZonedDateTime seoulTime = ZonedDateTime.now();
        ZoneId nyId = ZoneId.of("America/New_York");
        ZonedDateTime nyTime = ZonedDateTime.now().withZoneSameInstant(nyId);

        OffsetDateTime odt = zdt.toOffsetDateTime();

        System.out.println(ldt); // 2024-12-31T12:34:56
        System.out.println(zid); // Asia/Seoul
        System.out.println(zdt); // 2024-12-31T12:34:56+09:00[Asia/Seoul]
        System.out.println(seoulTime); // 2026-03-27T19:00:34.882147+09:00[Asia/Seoul]
        System.out.println(nyTime); // 2026-03-27T06:00:34.883657-04:00[America/New_York]
        System.out.println(odt); // 2024-12-31T12:34:56+09:00
    }
}