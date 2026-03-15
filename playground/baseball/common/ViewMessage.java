package baseball.common;

public enum ViewMessage {
    ANSWER_LENGTH_INPUT("정답 숫자 길이 입력 : "),
    GUESS_INPUT("예측 숫자 입력 : ");

    private String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}