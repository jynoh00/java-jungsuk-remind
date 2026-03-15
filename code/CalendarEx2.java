package ch10;

import java.util.Calendar;

public class CalendarEx2 {
    public static void main(String[] args) {
        final String[] DAY_OF_WEEK = {"", "일", "월", "화", "수", "목", "금", "토"};

        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();

        date1.set(2026, Calendar.MARCH, 10); // 2026/03/10
//        date2.set(2026, 2, 10); // 2026/03/10

        System.out.println(toString(date1) + " " + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] + "요일");
        System.out.println(toString(date2) + " " + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)] + "요일");

        long difference = (date2.getTimeInMillis() - date1.getTimeInMillis()) / 1000;

        System.out.println(("date2부터 date1까지 : ") + difference + "초가 지났습니다.");
        System.out.println("일로 계산하면 : " + difference / (24*60*60) + "일 입니다.");
    }

    static String toString(Calendar date) {
        return date.get(Calendar.YEAR) + "년 " + (date.get(Calendar.MONTH) + 1) + "월 " + date.get(Calendar.DAY_OF_MONTH) + "일";
    }
}
