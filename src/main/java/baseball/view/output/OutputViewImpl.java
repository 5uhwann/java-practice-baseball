package baseball.view.output;

public class OutputViewImpl implements OutputView {

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}
