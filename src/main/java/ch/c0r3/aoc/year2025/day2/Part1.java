package ch.c0r3.aoc.year2025.day2;

import org.slf4j.Logger;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.LongStream;

import static org.slf4j.LoggerFactory.getLogger;

public class Part1 {

    private static final Logger LOGGER = getLogger(Part1.class);

    public static final Predicate<Long> IS_ID_VALID = id -> {
        if (id == null) {
            return false;
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

    public static LongStream getInvalidIds(long startRange, long endRange) {
        return LongStream.range(startRange, endRange + 1)
                .filter(i -> IS_ID_VALID.negate().test(i));
    }

    public static LongStream getInvalidIds(String input) {
        return Arrays.stream(input.split(","))
                .flatMapToLong(l -> {
                    var rStr = l.split("-");
                    var rangeFrom = Long.parseLong(rStr[0]);
                    var rangeTo = Long.parseLong(rStr[1]);
                    return getInvalidIds(rangeFrom, rangeTo);
                });

    }

    static void main() {
        var input = "26803-38596,161-351,37-56,9945663-10044587,350019-413817," +
                "5252508299-5252534634,38145069-38162596,1747127-1881019,609816-640411," +
                "207466-230638,18904-25781,131637-190261,438347308-438525264," +
                "5124157617-5124298820,68670991-68710448,8282798062-8282867198," +
                "2942-5251,659813-676399,57-99,5857600742-5857691960,9898925025-9899040061," +
                "745821-835116,2056-2782,686588904-686792094,5487438-5622255," +
                "325224-347154,352-630,244657-315699,459409-500499,639-918,78943-106934," +
                "3260856-3442902,3-20,887467-1022885,975-1863,5897-13354,43667065-43786338";
        var sum = getInvalidIds(input).sum();
        LOGGER.info("sum is {}", sum);
    }
}
