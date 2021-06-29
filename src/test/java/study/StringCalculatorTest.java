package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringCalculatorTest {

    @ParameterizedTest(name = "[{index}] {0} = {1}")
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "2:2"}, delimiter = ':')
    @DisplayName("문자열 계산기 테스트")
    void calculate(String input, int expected) {
        // when
        final int result = new StringCalculator().calculate(input);
        // then
        assertThat(result).isEqualTo(expected);
    }
}
