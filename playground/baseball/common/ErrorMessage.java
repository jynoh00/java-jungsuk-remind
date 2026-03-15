package baseball.common;

public enum ErrorMessage {
    BLANK_INPUT("입력이 비어있습니다"),
    INVALID_NUMBER_FORMAT("올바른 숫자 형식을 입력하세요"),
    INVALID_GUESS_LENGTH("%d자리 수를 입력하세요"),
    OUT_OF_RANGE("%d ~ %d 사이 숫자를 입력하세요"),
    DUPLICATE_NUMBER("중복된 숫자는 입력할 수 없습니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String get(Object... args) {
        return String.format(message, args);
    }
}