package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("','를 가지고 split()하면 나누어지는가")
    void splitWithCommaHitPatternThenSpliced() {
        // given
        final String str = "1,2";
        // when
        final String[] result = str.split(",");
        // then
        assertThat(result).contains("1", "2");
    }

    @Test
    @DisplayName("','를 가지고 split()하지만 패턴이 없는 경우 그대로 반환하는가")
    void splitWithCommaMissPatternThenSame() {
        // given
        final String str = "1";
        // when
        final String[] result = str.split(",");
        // then
        assertThat(result).containsExactly(str);
    }

    @Test
    @DisplayName("subString()로 '()'가 제거되는가")
    void subStringToRemoveBracket() {
        // given
        final String str = "(1,2)";
        final String expected = "1,2";
        // when
        final String result = str.substring(1, str.length() - 1);
        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("charAt()로 특정 위치의 문자를 가져오는가")
    void charAtThenOk() {
        // given
        final String str = "abc";
        // when
        final char a = str.charAt(0);
        final char b = str.charAt(1);
        final char c = str.charAt(2);
        // then
        assertThat(a).isEqualTo('a');
        assertThat(b).isEqualTo('b');
        assertThat(c).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt()로 범위를 벗어난 호출시 예외를 발생하는가")
    void chatAtThenIndexOutOfBoundsException() {
        // given
        final String str = "abc";
        // when
        // then
        assertThatThrownBy(() -> str.charAt(4))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageMatching("String index out of range: \\d+");
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> str.charAt(4))
                .withMessageMatching("String index out of range: \\d+");
    }
}
