package junit;

import com.ukma.cipher.CaesarCipher;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JUnitCaesarCipherTest {

    CaesarCipher caesarCipher = new CaesarCipher();

    @ParameterizedTest
    @MethodSource("parameterizedTestParams")
    void parameterizedTestWithMethodSource(String value, int shift) {

    }

    @ParameterizedTest
    @NullAndEmptySource
    void parameterizedTestWithMethodSource(String value) {
        Exception exception = assertThrows(RuntimeException.class, () ->
                caesarCipher.encrypt(value, 10));

        assertEquals(exception.getMessage(), "NULL TEXT ERROR!");
    }

    private static Stream<Arguments> parameterizedTestParams() {
        return Stream.of(
                Arguments.of("ABCDEFGH", 10),
                Arguments.of("password15", 19)
        );
    }
}
