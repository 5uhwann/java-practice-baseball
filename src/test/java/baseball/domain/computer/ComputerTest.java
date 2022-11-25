package baseball.domain.computer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    @DisplayName("랜덤 숫자 생성 시 서로다른 3자리 숫자를 생성한다.")
    void generateRandomNumberTest() {
        //given
        Computer computer = new ComputerImpl(new RandomNumberGenerator());

        //when
        RandomNumbers randomNumbers = computer.generateRandomNumber();

        //then
        int randomNumberSize = randomNumbers.getRandomNumbers().size();
        HashSet<Integer> nonDuplicatedRandomNumbers = new HashSet<>(randomNumbers.getRandomNumbers());

        assertThat(randomNumberSize).isEqualTo(RandomNumbers.RANDOM_NUMBER_SIZE);
        assertThat(nonDuplicatedRandomNumbers.size()).isEqualTo(RandomNumbers.RANDOM_NUMBER_SIZE);
    }

}
