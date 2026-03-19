package baseball.model;

import baseball.common.BaseBallConstant;

public class GameResult {
    private int userSubmit;
    private long playTime;

    public GameResult() {
        this.userSubmit = 0;
        this.playTime = System.currentTimeMillis();
    }

    public GameResult gameOver() {
        playTime = System.currentTimeMillis() - playTime;
        return this;
    }

    public Rank getRank() {
        return Rank.calculate(userSubmit, getPlayTime());
    }

    public void addSubmitCount() {
        userSubmit++;
    }

    public double getPlayTime() {
        return (double) playTime / BaseBallConstant.MILLIS_PER_SECOND.getValue();
    }

    public int getUserSubmit() {
        return userSubmit;
    }
}
