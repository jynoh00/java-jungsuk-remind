package baseball.common;

public enum BaseBallConstant {
    BALL(0),
    STRIKE(1),
    OUT(2),
    SUBMIT_RESULT_SIZE(3),
    ONE(1),
    NINE(9),
    ZERO(0);

    private final int value;

    BaseBallConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
