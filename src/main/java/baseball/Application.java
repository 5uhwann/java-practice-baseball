package baseball;

import baseball.controller.ApplicationController;

public class Application {

    public static void main(String[] args) {
        BaseballConfig baseballConfig = new BaseballConfig();
        ApplicationController applicationController = baseballConfig.applicationController();
        applicationController.startBaseballGame();
    }
}
