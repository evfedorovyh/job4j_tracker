package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        return "Неизвестное слово: " + eng;
    }

    public static void main(String[] args) {
        DummyDic oneDic = new DummyDic();
        String engWord = "wood";
        System.out.println(oneDic.engToRus(engWord));
    }
}
