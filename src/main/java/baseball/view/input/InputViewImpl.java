package baseball.view.input;

import java.util.Scanner;

public class InputViewImpl implements InputView {

    private static final Scanner CONSOLE = new Scanner(System.in);

    @Override
    public String userInput() {
        return CONSOLE.nextLine();
    }
}
