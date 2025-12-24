package ch.c0r3.aoc.year2025.day2;

import java.util.function.Predicate;

public class Part1Strategy implements FilterStrategy {
    @Override
    public Predicate<Long> isIdValid() {
        return id -> {
            if (id == null) {
                return Boolean.FALSE;
            }

            var idStr = String.valueOf(id);
            if (idStr.length() % 2 != 0) {
                return true;
            }

            var indexSplit = idStr.length() / 2;
            var idFirstHalf = idStr.substring(0, indexSplit);
            var idLastHalf = idStr.substring(indexSplit);

            return Long.parseLong(idFirstHalf) != Long.parseLong(idLastHalf);
        };
    }
}
