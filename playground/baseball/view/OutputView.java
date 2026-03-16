package baseball.view;

import baseball.common.ErrorMessage;
import baseball.common.ViewMessage;
import baseball.model.Answer;
import baseball.model.GameResult;

import java.util.List;

public class OutputView {
    public void showSubmitResult(List<Integer> result) {
        // result[3] : ball strike out
    }

    public void showResult(GameResult gameResult) {
        //...
    }

    public void showError(String error) {
        System.out.println(ErrorMessage.ERROR_DEFAULT.getMessage() + error);
    }

    public void showRestartMessage() {
        System.out.println(ViewMessage.RESTART_MESSAGE.getMessage());
    }
}
