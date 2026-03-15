package baseball.model;

public class GameResult {
    private final int userSubmit;
    private final long playTime;

    public GameResult(int userSubmit, long playTime) {
        this.userSubmit = userSubmit;
        this.playTime = playTime;
    }

    /**
     * userSubmit, playTime 기반 랭크 계산
     * @return 사용자 점수 반환
     */
    public String calculateRank() {
        return "A";
    }

    public int getUserSubmit() { return userSubmit; }
}
