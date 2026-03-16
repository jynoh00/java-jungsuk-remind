package baseball.view;

import baseball.common.ErrorMessage;
import baseball.common.ViewMessage;
import baseball.model.Answer;
import baseball.model.GameResult;

import java.util.List;

public class OutputView {
    public void showSubmitResult(List<Integer> result) {
        // result[3] : ball strike out
        System.out.println(ViewMessage.SUBMIT_RESULT.get(result.get(0), result.get(1), result.get(2)));
    }

    public void showResult(GameResult gameResult) {
        System.out.println(ViewMessage.RESULT_MESSAGE.get(
                gameResult.getPlayTime(),
                gameResult.getUserSubmit(),
                gameResult.calculateRank()
        ));
    }

    public void showInitMessage() {
        System.out.println(ViewMessage.INIT_MESSAGE.getMessage());
    }

    public void showError(String error) {
        System.out.println(ErrorMessage.ERROR_DEFAULT.getMessage() + error);
    }

    public void showRestartMessage() {
        System.out.println(ViewMessage.RESTART_MESSAGE.getMessage());
    }
}
