package baseball.model;

import baseball.common.BaseBallConstant;

import java.util.Arrays;
import java.util.List;

public class SubmitResult {
    private int[] result = new int[BaseBallConstant.SUBMIT_RESULT_SIZE.getValue()];

    public void addValue(int index) {
        result[index]++;
    }

    public void outCalculate(int length) {
        result[BaseBallConstant.OUT.getValue()] = length
                - result[BaseBallConstant.BALL.getValue()]
                - result[BaseBallConstant.STRIKE.getValue()];
    }

    public List<Integer> getResult() {
        return Arrays.stream(result)
                .boxed()
                .toList();
    }
}
