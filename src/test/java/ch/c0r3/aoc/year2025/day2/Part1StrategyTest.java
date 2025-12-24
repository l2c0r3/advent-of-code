package ch.c0r3.aoc.year2025.day2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Part1StrategyTest {

    Part1Strategy testee = new Part1Strategy();

    private static Stream<Arguments> idProvider() {
        return Stream.of(
                Arguments.of(11, false),
                Arguments.of(22, false),
                Arguments.of(95, true),
                Arguments.of(115, true),
                Arguments.of(111, true),
                Arguments.of(1010, false),
                Arguments.of(1188511880, true),
                Arguments.of(1188511885, false)
        );
    }

    @ParameterizedTest
    @MethodSource("idProvider")
    void isIdValidTest(long input, boolean isValid) {
        // Act
        var result = testee.isIdValid().test(input);

        // Assert
        assertEquals(isValid, result);
    }

}