package baseball.view;

import baseball.common.ViewMessage;

import java.util.Scanner;

public class InputView {
    private final Scanner sc;

    public InputView() {
        sc = new Scanner(System.in);
    }

    public String inputAnswerLength() {
        System.out.println(ViewMessage.ANSWER_LENGTH_INPUT.getMessage());
        return sc.nextLine().trim();
    }

    public String inputGuess() {
        System.out.println(ViewMessage.GUESS_INPUT.getMessage());
        return sc.nextLine().trim();
    }
}