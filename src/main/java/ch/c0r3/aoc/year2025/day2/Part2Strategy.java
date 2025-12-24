package ch.c0r3.aoc.year2025.day2;

import java.util.function.Predicate;

public class Part2Strategy implements FilterStrategy {
    @Override
    public Predicate<Long> isIdValid() {
        return id -> {
            if (id == null) {
                return false;
            }

            var idStr = String.valueOf(id);
            if (idStr.length() == 1) {
                return true;
            }


            for (int i = 0; i < idStr.length(); i++) {
                var subStr = idStr.substring(0, i + 1);

                if (subStr.equals(idStr)) {
                    continue;
                }

                // can't be possible
                if (idStr.length() % subStr.length() != 0) {
                    continue;
                }

                var testString = "";
                for (int j = 0; j < idStr.length() / subStr.length(); j++) {
                    testString += subStr;
                }
                if (testString.equals(idStr)) {
                    return false;
                }
            }
            return true;
        };
    }
}
