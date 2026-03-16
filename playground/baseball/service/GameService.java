package baseball.service;

import baseball.model.Answer;

import java.util.List;
import java.util.Objects;

public class GameService {
    public List<Integer> checkUserSubmit(List<Integer> userGuess, Answer answer) {
        int ball = 0, strike = 0, out = 0;

        for (int i = 0; i < userGuess.size(); i++) {
            // 포함하는 지
            if (answer.getNumbers().contains(userGuess.get(i))) {
                ball++;

                if (Objects.equals(answer.getNumbers().get(i), userGuess.get(i))) {
                    ball--;
                    strike++;
                }
            }
        }

        out = answer.getLength() - ball - strike;

        return List.of(ball, strike, out);
    }

    public boolean checkFinish(List<Integer> guessResult, int answerLength) {
        return guessResult.get(1) == answerLength;
    }
}