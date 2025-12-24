package ch.c0r3.aoc.year2025.day2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Part2StrategyTest {

    Part2Strategy testee = new Part2Strategy();

    private static Stream<Arguments> idProvider() {
        return Stream.of(
                Arguments.of(11, false),
                Arguments.of(22, false),
                Arguments.of(110, true),
                Arguments.of(111, false),
                Arguments.of(115, true),
                Arguments.of(111, false),
                Arguments.of(1010, false),
                Arguments.of(1188511885, false),
                Arguments.of(565656, false),
                Arguments.of(565657, true)
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