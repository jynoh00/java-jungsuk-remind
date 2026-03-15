package baseball.controller;

import baseball.model.Answer;
import baseball.model.GameResult;
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
        Answer answer = new Answer(
                InputParser.parseAnswerLength(inputView.inputAnswerLength())
        );

        GameResult gameResult = null;
        try {
            gameResult = playGame(answer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        outputView.showResult(gameResult);
    }

    private GameResult playGame(Answer answer) {
        boolean isGameOver = false;
        int userSubmit = 0;

        while (!isGameOver) {
            List<Integer> userGuess = InputParser.parseUserGuess(
                    inputView.inputGuess(), answer.getLength()
            );

            //...
        }

        return new GameResult(userSubmit, 100L); // playTime 기능 추가
    }
}
