package main.java.baseball.util;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    private static final int ANSWER_MIN_LENGTH = 1;
    private static final int ANSWER_MAX_LENGTH = 9;

    private InputParser() {}

    public static int parseAnswerLength(String answerLength) {
        if (answerLength == null || answerLength.isBlank())
            throw new IllegalArgumentException("입력이 비어있습니다.");

        try {
            int length = Integer.parseInt(answerLength);
            if (length < ANSWER_MIN_LENGTH || length > ANSWER_MAX_LENGTH)
                throw new IllegalArgumentException(ANSWER_MIN_LENGTH + "~" + ANSWER_MAX_LENGTH + " 사이 숫자를 입력하세요.");

            return length;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자 형식을 입력하세요.");
        }
    }

    public static List<Integer> parseUserGuess(String userGuess, int answerLength) {
        // 개별 숫자 검사, 중복 숫자 불가
        if (userGuess == null || userGuess.isBlank())
            throw new IllegalArgumentException("입력이 비어있습니다.");

        if (userGuess.length() != answerLength)
            throw new IllegalArgumentException("예측 숫자는 " + answerLength + "자리 수여야 합니다.");

        List<Integer> result = new ArrayList<>();
        boolean[] isUsed = new boolean[10];

        for (int i = 0; i < userGuess.length(); i++)
            result.add(parseAndValidateDigit(userGuess.charAt(i), isUsed));

        return result;
    }

    private static int parseAndValidateDigit(char c, boolean[] isUsed) {
        try {
            int number = Integer.parseInt(String.valueOf(c));

            if (number < 1 || number > 9)
                throw new IllegalArgumentException(ANSWER_MIN_LENGTH + "~" + ANSWER_MAX_LENGTH + " 사이 숫자를 입력하세요.");
            if (isUsed[number])
                throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");

            isUsed[number] = true;
            return number;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자 형식을 입력하세요.");
        }
    }
}