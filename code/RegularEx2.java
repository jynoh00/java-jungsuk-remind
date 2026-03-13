package ch09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx2 {
    public static void main(String[] args) {
        String source = "HP:011-1111-1111, HOME:02-999-9999 ";
        String pattern = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";
        // 0\\d{1,2} : 0으로 시작하고 이후, \\d{1,2} 숫자로 구성된 최소 1자리, 최대 2자리 -> 0으로 시작하는 2~3자리 숫자
        // \\d{3,4} : 최소 3, 최대 4개의 d(숫자)
        // \\d{4} : 4자리 숫자
        // 정규식의 일부를 괄호로 묶어 그룹화할 수 있다.

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(source);

        int i = 0;

        while (m.find()) // find()는 주어진 소스 내에서 패턴과 일치하는 부분을 찾으면 true를 반환한다. (없으면 false)
                         // 이후 find()를 다시 호출하면, 이전 발견 패턴 다음부터 다시 패턴매칭을 시작한다.
            System.out.println(++i + ": " + m.group(0) + " -> " + m.group(1) +
                    ", " + m.group(2) + ", " + m.group(3));
            // group(int i)으로 그룹화된 부분을 얻을 수 있다. 범위를 벗어나면 IndexOutOfBoundsException 발생
    }
}
