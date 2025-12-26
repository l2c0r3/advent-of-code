package ch.c0r3.aoc.year2025.day3;

import ch.c0r3.aoc.util.FileUtil;
import org.slf4j.Logger;

import java.io.FileReader;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class Part1 {

    private static final Logger LOGGER = getLogger(Part1.class);

    static void main() {
        var filePath = "2025/day2/input.txt";
        int count = 0;

        try (var in = new FileReader(FileUtil.loadFile(filePath))) {
            for (var line : in.readAllLines()) {
                count += getJoltage(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        LOGGER.info("Joltage is {}", count);
    }

    public static int getJoltage(String input) {
        var highestNumber = 0;
        var posHighestNumber = 0;
        var secondHighestNumber = 0;
        var charArr = input.toCharArray();

        // skip latest - to get secondHighest too
        for (int i = 0; i < charArr.length - 1; i++) {
            var parsed = Integer.parseInt(String.valueOf(charArr[i]));
            if (parsed > highestNumber) {
                highestNumber = parsed;
                posHighestNumber = i;
            }
        }

        for (int i = posHighestNumber + 1; i < charArr.length; i++) {
            var parsed = Integer.parseInt(String.valueOf(charArr[i]));
            if (parsed > secondHighestNumber) {
                secondHighestNumber = parsed;
            }
        }
        return highestNumber * 10 + secondHighestNumber;
    }
}
