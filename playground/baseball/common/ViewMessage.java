package baseball.common;

public enum ViewMessage {
    ANSWER_LENGTH_INPUT("정답 숫자 길이 입력 : "),
    GUESS_INPUT("예측 숫자 입력 : "),
    RESTART_MESSAGE("\n---------------\n게임을 재시작합니다\n---------------\n"),
    INIT_MESSAGE("---------------\n게임 시작\n---------------\n"),
    RESULT_MESSAGE("\n" +
            "----------------\n" +
            "총 걸린 시간 : %.2f초\n" +
            "총 제출 횟수 : %d번\n" +
            "최종 랭크 : %s\n" +
            "----------------"),
    SUBMIT_RESULT("%d[B] %d[S] %d[O]\n");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String get(Object... args) {
        return String.format(message, args);
    }
}