package ch10;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateFormatEx {
    public static void main(String[] args) {
        Date today = new Date();

        List<SimpleDateFormat> formats = new ArrayList<>();

        formats.add(new SimpleDateFormat("yyyy-MM-dd"));
        formats.add(new SimpleDateFormat("''yy년 MMM dd일 E요일"));
        formats.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));
        formats.add(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a\n"));

        formats.add(new SimpleDateFormat("오늘은 올 해의 D번째 날입니다."));
        formats.add(new SimpleDateFormat("오늘은 이 달의 d번째 날입니다."));
        formats.add(new SimpleDateFormat("오늘은 올 해의 w번째 주입니다."));
        formats.add(new SimpleDateFormat("오늘은 이 달의 W번째 주입니다."));
        formats.add(new SimpleDateFormat("오늘은 이 달의 F번째 E요일입니다."));

        for (SimpleDateFormat sdf : formats) {
            System.out.println(sdf.format(today));
        }
    }
}