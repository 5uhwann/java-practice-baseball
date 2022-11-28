package baseball.controller;

public class GameStatus {

    public static final String RETRY = "R";

    private boolean isSuccess;

    public GameStatus() {
        this.isSuccess = false;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
