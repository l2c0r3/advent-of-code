package ch.c0r3.aoc.year2025.day3;

import ch.c0r3.aoc.util.FileUtil;
import org.slf4j.Logger;

import java.io.FileReader;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class Main {

    record HighestNumberResult(int number, int pos){}

    private static final Logger LOGGER = getLogger(Main.class);

    static void main() {
        var filePath = "2025/day2/input.txt";
        int count = 0;

        try (var in = new FileReader(FileUtil.loadFile(filePath))) {
            for (var line : in.readAllLines()) {
                count += getJoltagePart1(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        LOGGER.info("Joltage is {}", count);
    }

    public static int getJoltagePart1(String input) {
        var charArr = input.toCharArray();

        // skip latest char - to get secondHighest too
        var highestNumber = getHighestNumber(charArr, 0, charArr.length - 1);
        var secondHighestNumber = getHighestNumber(charArr, highestNumber.pos() + 1, charArr.length);

        return highestNumber.number() * 10 + secondHighestNumber.number();
    }


    /**
     * returns the highest number within a range
     */
    private static HighestNumberResult getHighestNumber(char[] input, int startPos, int endPos) {
        HighestNumberResult highestNumber = new HighestNumberResult(-1,-1);
        for (int i = startPos; i < endPos; i++) {
            var parsed = Integer.parseInt(String.valueOf(input[i]));
            if (parsed > highestNumber.number()) {
                highestNumber = new HighestNumberResult(parsed, i);
            }
        }
        return highestNumber;
    }
}
