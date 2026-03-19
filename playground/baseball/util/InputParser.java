package baseball.util;

import baseball.common.BaseBallConstant;
import baseball.common.ErrorMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputParser {
    private static final int ANSWER_MIN_LENGTH = BaseBallConstant.MIN.getValue();
    private static final int ANSWER_MAX_LENGTH = BaseBallConstant.MAX.getValue();

    private InputParser() {
    }

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
        if (userGuess == null || userGuess.isBlank())
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT.getMessage());

        if (userGuess.length() != answerLength)
            throw new IllegalArgumentException(ErrorMessage.INVALID_GUESS_LENGTH.get(answerLength));

        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < userGuess.length(); i++)
            result.add(parseAndValidateDigit(userGuess.charAt(i), seen));

        return result;
    }

    private static int parseAndValidateDigit(char c, Set<Integer> seen) {
        try {
            int number = Integer.parseInt(String.valueOf(c));

            if (number < ANSWER_MIN_LENGTH || number > ANSWER_MAX_LENGTH)
                throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.get(ANSWER_MIN_LENGTH, ANSWER_MAX_LENGTH));
            if (!seen.add(number)) throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}