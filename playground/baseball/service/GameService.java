package baseball.service;

import baseball.model.Answer;

import java.util.*;

public class GameService {
    public List<Integer> checkUserSubmit(List<Integer> userGuess, Answer answer) {
        List<Integer> answerNumbers = answer.getNumbers();
        Set<Integer> answerSet = answer.getNumbersToSet();

        int ball = 0, strike = 0;

        for (int i = 0; i < userGuess.size(); i++) {
            int guess = userGuess.get(i);

            if (Objects.equals(answerNumbers.get(i), guess)) {
                strike++;
                continue;
            }
            if (answerSet.contains(guess)) ball++;
        }

        int out = userGuess.size() - (ball + strike);
        return List.of(ball, strike, out);
    }

    public boolean checkFinish(List<Integer> guessResult, int answerLength) {
        return guessResult.get(1) == answerLength;
    }
}