package ch09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx3 {
    public static void main(String[] args) {
        String source = "A broken hand works, but not a broken heart.";
        String pattern = "broken";
        StringBuffer sb = new StringBuffer();

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(source);
        System.out.println("source: " + source);

        int i = 0;

        while (m.find()) {
            System.out.println(++i + "번째 매칭: " + m.start() + "~" + m.end());
            // 정규식과 일치하는 부분의 인덱스를 start()와 end()로 알아낼 수 있다.

            m.appendReplacement(sb, "drunken"); // broken을 drunken으로 치환하여 StringBuffer객체에 저장
            // 치환된 결과는 StringBuffer객체 sb에 저장된다.
        }

        m.appendTail(sb); // 마지막 치환된 이후 부분을 StringBuffer 객체 sb에 붙인다.

        String result = sb.toString();

        System.out.println("Replacement count : " + i);
        System.out.println("result: " + result);
    }
}
