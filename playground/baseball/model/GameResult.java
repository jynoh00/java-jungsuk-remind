package baseball.model;

public class GameResult {
    private final int userSubmit;
    private final long playTime;

    public GameResult(int userSubmit, long playTime) {
        this.userSubmit = userSubmit;
        this.playTime = playTime;
    }

    public String calculateRank() {
        // 랭크 계산, Rank객체 도입
        return "A";
    }

    public double getPlayTime() {
        // 걸린 시간 계산 -> double로 반환
        return 10.0;
    }
    public int getUserSubmit() { return userSubmit; }
}
