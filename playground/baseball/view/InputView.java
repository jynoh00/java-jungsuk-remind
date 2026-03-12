package main.java.baseball.view;

import java.util.Scanner;

public class InputView {
    private final Scanner sc;

    public InputView() {
        sc = new Scanner(System.in);
    }

    public String inputAnswerLength() {
        System.out.println("정답 숫자 길이 입력 : ");
        return sc.nextLine().trim();
    }

    public String inputGuess() {
        System.out.println("예측 숫자를 입력 : ");
        return sc.nextLine().trim();
    }

//    private String answerLengthValidate(String answerLength) throws IllegalArgumentException {
//        if (answerLength == null || answerLength.isBlank())
//            throw new IllegalArgumentException("answerLength는 null값 혹은 빈 입력이 될 수 없습니다.");
//
//        if (answerLength.matches("\\d+"))
//            throw new IllegalArgumentException("answerLength에 숫자를 입력해야 합니다.");
//
//        return answerLength;
//    }
}