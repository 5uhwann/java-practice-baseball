package baseball.domain.computer;

public enum BallAndStrike {

    ball("볼"),
    strike("스트라이크");

    private final String koreanTag;

    BallAndStrike(String koreanTag) {
        this.koreanTag = koreanTag;
    }

    public String getKoreanTag() {
        return koreanTag;
    }
}
