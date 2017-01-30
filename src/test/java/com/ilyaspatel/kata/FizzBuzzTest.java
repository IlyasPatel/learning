package com.ilyaspatel.kata;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    /*
    * “fizz” if the number is dividable by 3
    * “buzz” if the number is dividable by 5
    * “fizzbuzz” if the number is dividable by 3 and 5 (15) ?
    * the same number if no other requirement is fulfilled 
    * */

    @Test
    public void should_ReturnFizz_when_NumberIsDividableByThree() throws Exception {

        FizzBuzz sut = new FizzBuzz();

        assertThat(sut.getResult(3)).isEqualTo("Fizz");
        assertThat(sut.getResult(6)).isEqualTo("Fizz");
        assertThat(sut.getResult(9)).isEqualTo("Fizz");
    }

    @Test
    public void should_ReturnBuzz_when_NumberIsDividableByFive() throws Exception {

        FizzBuzz sut = new FizzBuzz();

        assertThat(sut.getResult(5)).isEqualTo("Buzz");
        assertThat(sut.getResult(10)).isEqualTo("Buzz");
    }

    @Test
    public void should_ReturnFizzBuzz_when_NumberIsDividableByFifteen() throws Exception {

        FizzBuzz sut = new FizzBuzz();

        assertThat(sut.getResult(15)).isEqualTo("FizzBuzz");
        assertThat(sut.getResult(30)).isEqualTo("FizzBuzz");
        assertThat(sut.getResult(45)).isEqualTo("FizzBuzz");
    }

    @Test
    public void should_ReturnOriginalNumber_when_NoFizzBuzzRulesAreMet() throws Exception {

        FizzBuzz sut = new FizzBuzz();

        assertThat(sut.getResult(1)).isEqualTo("1");
        assertThat(sut.getResult(2)).isEqualTo("2");
        assertThat(sut.getResult(4)).isEqualTo("4");
        assertThat(sut.getResult(7)).isEqualTo("7");
    }
}
