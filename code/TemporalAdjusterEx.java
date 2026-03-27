package ch10;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjusterEx {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate date = today.with(new DayAfterTomorrow());

        p(today);
        p(date);

        /*
        TemporalAdjusters 클래스를 살펴보면
        final 제어자가 붙어 상속이 불가능하게 되어 있으며,
        생성자를 private으로 하여 객체 생성도 불가능하게 막았다.

        이를 통해 잘못된 확장과 객체 생성을 막고
        static 멤버만을 통해 기능을 사용하도록 강제되어있는 것을 알 수 있다.
         */

        p(today.with(TemporalAdjusters.firstDayOfNextMonth()));
        p(today.with(TemporalAdjusters.firstDayOfMonth()));
        p(today.with(TemporalAdjusters.lastDayOfMonth()));
        p(today.with(TemporalAdjusters.firstInMonth(DayOfWeek.TUESDAY)));
        p(today.with(TemporalAdjusters.lastInMonth(DayOfWeek.TUESDAY)));
        p(today.with(TemporalAdjusters.previous(DayOfWeek.TUESDAY)));
        p(today.with(TemporalAdjusters.previousOrSame(DayOfWeek.TUESDAY)));
        p(today.with(TemporalAdjusters.next(DayOfWeek.TUESDAY)));
        p(today.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY)));
        p(today.with(TemporalAdjusters.dayOfWeekInMonth(4, DayOfWeek.TUESDAY)));
    }

    static void p(Object obj) {
        System.out.println(obj);
    }
}

class DayAfterTomorrow implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        return temporal.plus(2, ChronoUnit.DAYS);
    }
}