package ru.job4j.oop;

public class JukeBox {
    public void music(int position) {
        switch (position) {
            case 1:
                System.out.println("Пусть бегут неуклюже");
                break;
            case 2:
                System.out.println("Спокойной ночи");
                break;
            default:
                System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        JukeBox firstBox = new JukeBox();
        firstBox.music(1);
        firstBox.music(2);
        firstBox.music(5);
    }
}
