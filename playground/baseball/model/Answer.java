package baseball.model;

import baseball.common.BaseBallConstant;

import java.util.*;

public class Answer {
    private final List<Integer> numbers;
    private final Set<Integer> numbersToSet;

    public Answer(int answerLength) {
        this.numbers = generate(answerLength);
        this.numbersToSet = new HashSet<>(numbers);
    }

    private List<Integer> generate(int answerLength) {
        List<Integer> result = new ArrayList<>();
        Random random = new Random();
        Set<Integer> seen = new HashSet<>();

        while (result.size() < answerLength) {
            int tmp = random.nextInt(BaseBallConstant.MAX.getValue()) + BaseBallConstant.MIN.getValue();
            if (!seen.add(tmp)) continue;

            result.add(tmp);
        }
//        System.out.println(result); // x

        return result;
    }

    public int getLength() {
        return numbers.size();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public Set<Integer> getNumbersToSet() {
        return Collections.unmodifiableSet(numbersToSet);
    }
}