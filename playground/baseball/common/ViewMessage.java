package baseball.common;

public enum ViewMessage {
    ANSWER_LENGTH_INPUT("정답 숫자 길이 입력 : "),
    GUESS_INPUT("예측 숫자 입력 : "),
    RESTART_MESSAGE("\n---------------\n게임을 재시작합니다\n---------------\n");

    private String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}