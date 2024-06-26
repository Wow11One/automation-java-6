import com.ukma.cipher.CaesarCipher;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JUnitCaesarCipherTest {

    public CaesarCipher caesarCipher = new CaesarCipher();

    @ParameterizedTest
    @MethodSource("parameterizedTestParams")
    public void parameterizedTestWithMethodSource(String initialValue, int shift) {
        assertNotNull(initialValue);

        String encryptedString = caesarCipher.encrypt(initialValue, shift);
        assertNotEquals(initialValue, encryptedString);

        String decryptedString = caesarCipher.decrypt(encryptedString, shift);
        assertEquals(decryptedString, initialValue);
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void parameterizedTestWithNullAndEmptyValues(String value) {
        Exception exception = assertThrows(RuntimeException.class, () ->
                caesarCipher.encrypt(value, 10));

        assertEquals(exception.getMessage(), "NULL TEXT ERROR!");
    }

    @Test
    public void testThatNegativeShiftWillReturnSameString() {
        String value = "aaa";
        int shift = -55;

        String encryptedValue = caesarCipher.encrypt(value, shift);
        String decryptedValue = caesarCipher.decrypt(value, shift);

        assertEquals(value, encryptedValue);
        assertEquals(value, decryptedValue);
    }

    private static Stream<Arguments> parameterizedTestParams() {
        return Stream.of(
                Arguments.of("ABCDEFGH", 5),
                Arguments.of("password15", 6),
                Arguments.of("AAAAAAA", 7)
        );
    }
}
