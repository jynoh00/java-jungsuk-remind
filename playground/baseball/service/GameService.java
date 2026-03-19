package baseball.service;

import baseball.common.BaseBallConstant;
import baseball.model.Answer;
import baseball.model.GuessResult;

import java.util.*;

public class GameService {
    public GuessResult checkUserSubmit(List<Integer> userGuess, Answer answer) {
        List<Integer> answerNumbers = answer.getNumbers();
        Set<Integer> answerSet = answer.getNumbersToSet();
        GuessResult result = new GuessResult();

        for (int i = 0; i < userGuess.size(); i++) {
            int guess = userGuess.get(i);

            if (Objects.equals(answerNumbers.get(i), guess)) {
                result.addValue(BaseBallConstant.STRIKE.getValue());
                continue;
            }
            if (answerSet.contains(guess)) result.addValue(BaseBallConstant.BALL.getValue());
        }

        return result.outCalculate(userGuess.size());
    }
}