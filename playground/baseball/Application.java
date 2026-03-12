package main.java.baseball;

import main.java.baseball.controller.BaseballController;
import main.java.baseball.service.GameService;
import main.java.baseball.util.InputParser;
import main.java.baseball.view.InputView;
import main.java.baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        GameService gameService = new GameService();

        BaseballController gc = new BaseballController(inputView, outputView, gameService);
        gc.run();
    }
}