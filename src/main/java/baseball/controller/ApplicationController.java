package baseball.controller;

import static baseball.utils.OutputMessage.*;

import baseball.domain.computer.Computer;
import baseball.domain.result.BaseballResultDto;
import baseball.domain.user.User;
import baseball.domain.user.UserImpl;
import baseball.view.input.InputView;
import baseball.view.output.OutputView;

public class ApplicationController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Computer computer;
    private final GameStatus gameStatus;

    public ApplicationController(InputView inputView, OutputView outputView, Computer computer) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.computer = computer;
        this.gameStatus = new GameStatus();
        outputView.printMessage(START_MESSAGE);
    }

    public void startBaseballGame() {
        computer.generateRandomNumber();

        runEachGame(new UserImpl());
    }

    private void runEachGame(User user) {
        while (!gameStatus.isSuccess()) {
            outputView.printMessage(REQUEST_BASEBALL_MESSAGE);
            String baseballInput = user.submitBaseballNumber(inputView.userInput());
            BaseballResultDto baseballResultDto = computer.generateBaseballResult(baseballInput);
            outputView.printMessage(baseballResultDto.getResultDto());
            gameStatus.setSuccess(baseballResultDto.isSuccess());
        }
        retry(user);
    }

    private void retry(User user) {
        outputView.printMessage(REQUEST_GAME_COMMAND_MESSAGE);
        String gameCommandInput = user.submitGameCommand(inputView.userInput());

        if (gameCommandInput.equals(GameStatus.RETRY)) {
            gameStatus.setSuccess(false);
            startBaseballGame();
        }
    }
}
