package ch.c0r3.aoc.year2025.day2;

import java.util.Arrays;
import java.util.stream.LongStream;

public class InputParser {

    public static LongStream getLongStreamFromInput(String input) {
        return Arrays.stream(input.split(","))
                .flatMapToLong(l -> {
                    var rStr = l.split("-");
                    var rangeFrom = Long.parseLong(rStr[0]);
                    var rangeTo = Long.parseLong(rStr[1]);
                    return LongStream.range(rangeFrom, rangeTo + 1);
                });

    }
}
