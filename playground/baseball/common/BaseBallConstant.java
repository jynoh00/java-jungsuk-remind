package baseball.common;

public enum BaseBallConstant {
    BALL(0),
    STRIKE(1),
    OUT(2),
    SUBMIT_RESULT_SIZE(3),
    MIN(1),
    MAX(9),
    ZERO(0),
    MILLIS_PER_SECOND(1000);

    private final int value;

    BaseBallConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
