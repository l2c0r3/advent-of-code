package ch.c0r3.aoc.year2025.day2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Part1Test {

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
        var result = Part1.IS_ID_VALID.test(input);

        // Assert
        assertEquals(isValid, result);
    }

    private static Stream<Arguments> rangeProvider() {
        return Stream.of(
                Arguments.of(11, 22, List.of(11L, 22L)),
                Arguments.of(95, 115, List.of(99L)),
                Arguments.of(998, 1012, List.of(1010L)),
                Arguments.of(1188511880, 1188511890, List.of(1188511885L)),
                Arguments.of(1698522, 1698528, Collections.emptyList())
        );
    }

    @ParameterizedTest
    @MethodSource("rangeProvider")
    void getInvalidIds_returnsExpected(long startRange, long endRange, List<Long> expectedResult) {
        // Act
        var resultStream = Part1.getInvalidIds(startRange, endRange);
        var result = resultStream.boxed().toList();

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    void getInvalidIds_retrunsExpected() {
        // Arrange
        var input = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224," +
                "1698522-1698528,446443-446449,38593856-38593862,565653-565659," +
                "824824821-824824827,2121212118-2121212124";

        // Act
        var resultStream = Part1.getInvalidIds(input);
        var result = resultStream.boxed().toList();

        // Assert
        assertEquals(List.of(
                11L, 22L, 99L,
                1010L, 1188511885L, 222222L,
                446446L, 38593859L), result);
    }
}