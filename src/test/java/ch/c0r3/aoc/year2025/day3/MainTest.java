package ch.c0r3.aoc.year2025.day3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private static Stream<Arguments> idProvider() {
        return Stream.of(
                Arguments.of("987654321111111", 98),
                Arguments.of("811111111111119", 89),
                Arguments.of("234234234234278", 78),
                Arguments.of("818181911112111", 92)
        );
    }

    @ParameterizedTest
    @MethodSource("idProvider")
    void getJoltage_Part1_returnsExpected(String input, int expected) {
        // Act
        var result = Main.getJoltagePart1(input);

        // Assert
        assertEquals(expected, result);
    }
}