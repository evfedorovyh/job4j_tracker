package ru.job4j.pojo;

public class Book {
    private String name;
    private int countList;

    public Book(String name, int countList) {
        this.name = name;
        this.countList = countList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountList() {
        return countList;
    }

    public void setCountList(int countList) {
        this.countList = countList;
    }
}
