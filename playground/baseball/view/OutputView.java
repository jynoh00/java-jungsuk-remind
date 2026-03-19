package baseball.view;

import baseball.common.BaseBallConstant;
import baseball.common.ErrorMessage;
import baseball.common.ViewMessage;
import baseball.model.GameResult;

import java.util.List;

public class OutputView {
    public void showSubmitResult(List<Integer> result) {
        System.out.println(ViewMessage.SUBMIT_RESULT.get(
                result.get(BaseBallConstant.BALL.getValue()),
                result.get(BaseBallConstant.STRIKE.getValue()),
                result.get(BaseBallConstant.OUT.getValue())
        ));
    }

    public void showResult(GameResult gameResult) {
        System.out.println(ViewMessage.RESULT_MESSAGE.get(
                gameResult.getPlayTime(),
                gameResult.getUserSubmit(),
                gameResult.getRank()
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
