package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int a) {
        return sum(a) + minus(a) + multiply(a) + divide(a);
    }

    public static void main(String[] args) {
        System.out.println(Calculator.sum(10));
        System.out.println(Calculator.minus(10));
        Calculator oneCalc = new Calculator();
        System.out.println(oneCalc.multiply(10));
        System.out.println(oneCalc.divide(10));
        System.out.println(oneCalc.sumAllOperation(10));
    }
}
