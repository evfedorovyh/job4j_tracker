package ru.job4j.oop;

public class Cat {
    private String food;
    private String name;

    public void show() {
        System.out.println(this.name + " eats " + this.food + ".");
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void nick(String nickName) {
        this.name = nickName;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.name = "Gav";
        gav.food = "meat";
        gav.show();
        Cat black = new Cat();
        black.name = "Black";
        black.food = "fish";
        black.show();
    }
}
