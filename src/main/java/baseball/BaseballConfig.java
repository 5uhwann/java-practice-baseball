package baseball;

import baseball.controller.ApplicationController;
import baseball.domain.computer.Computer;
import baseball.domain.computer.ComputerImpl;
import baseball.view.input.InputView;
import baseball.view.input.InputViewImpl;
import baseball.view.output.OutputView;
import baseball.view.output.OutputViewImpl;

public class BaseballConfig {

    public ApplicationController applicationController() {
        return new ApplicationController(inputView(), outputView(), computer());
    }

    private InputView inputView() {
        return new InputViewImpl();
    }

    private OutputView outputView() {
        return new OutputViewImpl();
    }

    private Computer computer() {
        return new ComputerImpl();
    }

}
