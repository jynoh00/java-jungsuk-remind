package baseball.common;

public enum ThresholdConstant {
    SUBMIT(new int[][]{{3, 5}, {5, 4}, {7, 3}, {10, 2}}),
    TIME(new int[][]{{10, 5}, {20, 4}, {40, 3}, {60, 2}});

    private final int[][] threshold;

    ThresholdConstant(int[][] threshold) {
        this.threshold = threshold;
    }

    public int[][] getThreshold() {
        return threshold;
    }
}
