package ch.c0r3.aoc.year2025.day2;

import java.util.function.Predicate;

@FunctionalInterface
public interface FilterStrategy {

    Predicate<Long> isIdValid();
}
