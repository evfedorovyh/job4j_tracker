package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(7, -4, 0, -2, 4, -10, 3, -9);
        List<Integer> positive = numbers.stream().filter(a -> a > 0).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}
