package ch.c0r3.aoc.year2025.day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputParserTest {

    @Test
    void getLongStreamFromInput_noFilter_returnsAllValues() {
        // Arrange
        var input = "11-13,15-16";

        // Act
        var resultStream = InputParser.getLongStreamFromInput(input);
        var resultArray = resultStream.toArray();

        // Assert
        assertEquals(5, resultArray.length);
        assertEquals(11L, resultArray[0]);
        assertEquals(12L, resultArray[1]);
        assertEquals(13L, resultArray[2]);
        assertEquals(15L, resultArray[3]);
        assertEquals(16L, resultArray[4]);
    }
}