package com.ilyaspatel.kata;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

/*
    Original Source - https://opencredo.com/tdd-fizzbuzz-junit-theories

    Write a program that prints the numbers from 1 to 100. But for multiples of
    three print “Fizz” instead of the number and for the multiples of five print “Buzz”.
    For numbers which are multiples of both three and five print “FizzBuzz.

    - The output must always be either a number, “Fizz”, “Buzz”, or “FizzBuzz”. No other output is valid.
    - Whenever the input is a multiple of 3, the output must contain “Fizz”.
    - Whenever the input is a multiple of 5, the output must contain “Buzz”.
    - Whenever the output is a number, it must be the number that was input.
 */

@RunWith(Theories.class)
public class FizzBuzzTheoriesTest {

    @DataPoints
    public static final int[] numbers = IntStream.range(1, 100).toArray();

    @Theory
    public void validOutputTheory(int number) {
        FizzBuzz sut = new FizzBuzz();

        assertTrue("Output must be valid FizzBuzz", isValidFizzBuzz(sut.getResult(number)));
    }

    @Theory
    public void should_ReturnFizz_when_NumberIsDividableByThree(int number) {
        FizzBuzz sut = new FizzBuzz();

        assumeFalse(isDivisibleBy(15, number));
        assumeTrue(isDivisibleBy(3, number));

        assertThat(sut.getResult(number)).isEqualTo("Fizz");
    }

    @Theory
    public void should_ReturnBuzz_when_NumberIsDividableByFive(int number) {
        FizzBuzz sut = new FizzBuzz();

        assumeFalse(isDivisibleBy(15, number));
        assumeTrue(isDivisibleBy(5, number));

        assertThat(sut.getResult(number)).isEqualTo("Buzz");
    }

    @Theory
    public void should_ReturnFizzBuzz_when_NumberIsDividableByFifteen(int number) {
        FizzBuzz sut = new FizzBuzz();

        assumeTrue(isDivisibleBy(15, number));

        assertThat(sut.getResult(number)).isEqualTo("FizzBuzz");
    }

    @Theory
    public void numberTheory(int number) {
        FizzBuzz sut = new FizzBuzz();

        assumeFalse(isDivisibleBy(3, number));
        assumeFalse(isDivisibleBy(5, number));
        assumeFalse(isDivisibleBy(15, number));

        assertTrue(isANumber(sut.getResult(number)));

    }

    private boolean isDivisibleBy(int divisor, int number) {
        return number % divisor == 0;
    }

    private boolean isValidFizzBuzz(String candidate) {
        return candidate.equals("Fizz")
                || candidate.equals("Buzz")
                || candidate.equals("FizzBuzz")
                || isANumber(candidate);
    }

    private boolean isANumber(String candidate) {
        return candidate.chars().allMatch(Character::isDigit);
    }
}
