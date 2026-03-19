package baseball.common;

public enum RankConstant {
    S('S', 9),
    A('A', 7),
    B('B', 5),
    C('C', 3),
    D('D', 0);

    private final char grade;
    private final int value;

    RankConstant(char grade, int value) {
        this.grade = grade;
        this.value = value;
    }

    public char getGrade() {
        return grade;
    }

    public int getValue() {
        return value;
    }
}
