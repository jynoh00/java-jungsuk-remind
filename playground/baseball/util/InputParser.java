package baseball.util;

import baseball.common.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    private static final int ANSWER_MIN_LENGTH = 1;
    private static final int ANSWER_MAX_LENGTH = 9;

    private InputParser() {}

    public static int parseAnswerLength(String answerLength) {
        if (answerLength == null || answerLength.isBlank())
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT.getMessage());

        try {
            int length = Integer.parseInt(answerLength);
            if (length < ANSWER_MIN_LENGTH || length > ANSWER_MAX_LENGTH)
                throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.get(ANSWER_MIN_LENGTH, ANSWER_MAX_LENGTH));

            return length;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    public static List<Integer> parseUserGuess(String userGuess, int answerLength) {
        // 개별 숫자 검사, 중복 숫자 불가
        if (userGuess == null || userGuess.isBlank())
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT.getMessage());

        if (userGuess.length() != answerLength)
            throw new IllegalArgumentException(ErrorMessage.INVALID_GUESS_LENGTH.get(answerLength));

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
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.get(ANSWER_MIN_LENGTH, ANSWER_MAX_LENGTH));
            if (isUsed[number])
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());

            isUsed[number] = true;
            return number;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}