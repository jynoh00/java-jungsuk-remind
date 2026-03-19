package baseball.controller;

import baseball.model.Answer;
import baseball.model.GameResult;
import baseball.model.GuessResult;
import baseball.service.GameService;
import baseball.util.InputParser;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {
    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;

    public BaseballController(InputView inputView, OutputView outputView, GameService gameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = gameService;
    }

    public void run() {
        outputView.showInitMessage();
        while (true) {
            try {
                Answer answer = new Answer(InputParser.parseAnswerLength(inputView.inputAnswerLength()));
                GameResult gameResult = playGame(answer);
                outputView.showResult(gameResult);
                return;
            } catch (IllegalArgumentException e) {
                outputView.showError(e.getMessage());
                outputView.showRestartMessage();
            }
        }
    }

    private GameResult playGame(Answer answer) {
        GameResult gameResult = new GameResult();

        while (true) {
            GuessResult guessResult = playTurn(answer);
            gameResult.addSubmitCount();
            if (guessResult.isAllStrike(answer.getLength())) break;
        }

        return gameResult.gameOver();
    }

    private GuessResult playTurn(Answer answer) {
        List<Integer> userGuess = InputParser.parseUserGuess(
                inputView.inputGuess(), answer.getLength()
        );
        GuessResult guessResult = gameService.checkUserSubmit(userGuess, answer);
        outputView.showSubmitResult(guessResult.getResult());
        return guessResult;
    }
}
