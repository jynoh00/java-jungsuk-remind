package baseball.service;

import baseball.common.BaseBallConstant;
import baseball.model.Answer;
import baseball.model.SubmitResult;

import java.util.*;

public class GameService {
    public List<Integer> checkUserSubmit(List<Integer> userGuess, Answer answer) {
        List<Integer> answerNumbers = answer.getNumbers();
        Set<Integer> answerSet = answer.getNumbersToSet();
        SubmitResult result = new SubmitResult();

        for (int i = 0; i < userGuess.size(); i++) {
            int guess = userGuess.get(i);

            if (Objects.equals(answerNumbers.get(i), guess)) {
                result.addValue(BaseBallConstant.STRIKE.getValue());
                continue;
            }
            if (answerSet.contains(guess)) result.addValue(BaseBallConstant.BALL.getValue());
        }

        result.outCalculate(userGuess.size());
        return result.getResult();
    }

    public boolean checkFinish(List<Integer> guessResult, int answerLength) {
        return guessResult.get(BaseBallConstant.STRIKE.getValue()) == answerLength;
    }
}