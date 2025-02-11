package ru.job4j.ex;

public class Factorial {
    public int calc(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Число не может быть меньше 0");
        }
        int result = 1;
        for (int index = 2; index <= number; index++) {
            result *= index;
        }
        return result;
    }

    public static void main(String[] args) {
        int number = 3;
        System.out.println("Factorial of " + number + " is : " + new Factorial().calc(number));
    }
}