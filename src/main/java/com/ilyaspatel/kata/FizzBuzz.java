package com.ilyaspatel.kata;

public class FizzBuzz {

    public String getResult(int number) {
        System.out.println(
                number % 15 != 0 ? number % 5 != 0
                        ? number % 3 != 0
                        ? number : "Fizz" : "Buzz" : "FizzBuzz");

        if (number % 15 == 0) {
            return "FizzBuzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        }

        return String.valueOf(number);
    }
}
