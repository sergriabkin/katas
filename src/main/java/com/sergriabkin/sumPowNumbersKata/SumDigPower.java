package com.sergriabkin.sumPowNumbersKata;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class SumDigPower {
    public static List<Long> sumDigPow(long a, long b) {
        return LongStream.rangeClosed(a, b)
                .filter(SumDigPower::isSumPowEqualsNumber)
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isSumPowEqualsNumber(long number) {
        long sum = getSumOfPowers(getDigitsListFromNumber(number));
        return sum == number;
    }

    private static long getSumOfPowers(List<Long> digits) {
        return IntStream.range(0, digits.size())
                .mapToLong(i -> calculateNumberInPower(digits.get(i), i+1))

                .sum();
    }

    private static long calculateNumberInPower(long number, int timesToMultiply) {
        long result = 1;
        for (int i = 0; i < timesToMultiply; i++) {
            result = number * result;
        }
        return result;
    }

    private static List<Long> getDigitsListFromNumber(long number) {
        char[] chars = ("" + number).toCharArray();
        return IntStream.range(0, chars.length)
                .mapToObj(i-> ""+chars[i])
                .map(Long::valueOf)
                .collect(Collectors.toList());
    }

}
