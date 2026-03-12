package main.java.baseball.controller;

import main.java.baseball.model.Answer;
import main.java.baseball.model.GameResult;
import main.java.baseball.service.GameService;
import main.java.baseball.util.InputParser;
import main.java.baseball.view.InputView;
import main.java.baseball.view.OutputView;

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

        GameResult gameResult = playGame(answer);
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
