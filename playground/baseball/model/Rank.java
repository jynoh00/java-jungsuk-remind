package baseball.model;

import baseball.common.RankConstant;
import baseball.common.ThresholdConstant;

public class Rank {
    private static final int[][] SUBMIT_THRESHOLD = ThresholdConstant.SUBMIT.getThreshold();
    private static final int[][] TIME_THRESHOLD = ThresholdConstant.TIME.getThreshold();

    private static final int LIMIT = 0;
    private static final int SCORE = 1;
    private static final int DEFAULT_SCORE = 1;

    private final char grade;

    private Rank(char grade) {
        this.grade = grade;
    }

    public static Rank calculate(int userSubmit, double playTime) {
        int totalScore = getSubmitScore(userSubmit) + getTimeScore(playTime);
        return new Rank(toGrade(totalScore));
    }

    private static int getSubmitScore(int userSubmit) {
        for (int[] threshold : SUBMIT_THRESHOLD)
            if (userSubmit <= threshold[LIMIT]) return threshold[SCORE];

        return DEFAULT_SCORE;
    }

    private static int getTimeScore(double playTime) {
        for (int[] threshold : TIME_THRESHOLD)
            if (playTime <= threshold[LIMIT]) return threshold[SCORE];

        return DEFAULT_SCORE;
    }

    private static char toGrade(int totalScore) {
        for (RankConstant rank : RankConstant.values())
            if (totalScore >= rank.getValue()) return rank.getGrade();

        return RankConstant.D.getGrade();
    }

    @Override
    public String toString() {
        return String.valueOf(grade);
    }
}