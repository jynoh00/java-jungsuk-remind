package baseball.service;

import baseball.model.Answer;
import baseball.model.GameResult;
import baseball.model.GuessResult;

import java.util.function.Function;

public class GameService {
    public GameResult playGame(Answer answer, Function<Answer, GuessResult> turnPlayer) {
        GameResult gameResult = new GameResult();

        while (true) {
            GuessResult guessResult = turnPlayer.apply(answer);
            gameResult.addSubmitCount();
            if (guessResult.isAllStrike(answer.getLength())) break;
        }

        return gameResult.gameOver();
    }
}