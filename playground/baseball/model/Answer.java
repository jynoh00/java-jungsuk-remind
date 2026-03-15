package baseball.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Answer {
    private final List<Integer> numbers;

    public Answer(int answerLength) {
        this.numbers = generate(answerLength);
    }

    private List<Integer> generate(int answerLength) {
        List<Integer> result = new ArrayList<>();
        Random random = new Random();
        boolean[] isUsed = new boolean[10]; // 0 ~ 9

        while (result.size() < answerLength) {
            int tmp = random.nextInt(9) + 1;
            if (isUsed[tmp]) continue; // 사용한 숫자면 다시 생성

            result.add(tmp); // primitive int tmp값 오토 박싱, Integer.valueOf(tmp);
            isUsed[tmp] = true;
        }

        return result;
    }

    public int getLength() { return numbers.size(); }
    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}