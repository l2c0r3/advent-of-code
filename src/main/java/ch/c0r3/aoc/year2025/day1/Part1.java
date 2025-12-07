package ch.c0r3.aoc.year2025.day1;

import module java.base;
import ch.c0r3.aoc.util.FileUtil;
import org.slf4j.LoggerFactory;


public class Part1 {
    private static final int MAX_NUMBER = 99;
    private static final int MIN_NUMBER = 0;
    private static final int START_NUMBER = 50;

    private static final String FILEPATH = "2025/day1/input.txt";

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Part1.class);

    void main() {

        var pointer = START_NUMBER;
        var zerohittetCounter = 0;

        try (var in = new FileReader(FileUtil.loadFile(FILEPATH))) {
            for (var line : in.readAllLines()) {
                pointer = calcNewNumber(line, pointer);
                pointer = readjustNumber(pointer);

                if (pointer == 0) {
                    zerohittetCounter++;
                }

                LOGGER.info("The dial is rotated {} to point at {}.", line, pointer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        LOGGER.info("The password is {}", zerohittetCounter);
    }

    private static int readjustNumber(int pointer) {
        if (pointer > MAX_NUMBER) {
            return pointer % (MAX_NUMBER + 1);

        } else if (pointer < MIN_NUMBER) {
            return readjustNumber(pointer + 100);
        } else {
            return pointer;
        }
    }

    private static int calcNewNumber(String instruction, int pointer) {
        var number = instruction.substring(1);
        var numParsed = Integer.parseInt(number);

        if (instruction.startsWith("L")) {
            return pointer - numParsed;
        } else {
            return pointer + numParsed;
        }
    }
}