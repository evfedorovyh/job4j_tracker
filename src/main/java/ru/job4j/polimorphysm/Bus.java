package ru.job4j.polimorphysm;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("Автобус начал движение");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Автобус вмещает " + count + " пассажиров");
    }

    @Override
    public int refuel(int fuel) {
        return fuel * 60;
    }

    public static void main(String[] args) {
        Bus bus = new Bus();
        bus.move();
        bus.passengers(20);
        System.out.println("Стоимость запрвки составляет " + bus.refuel(50) + " рублей");
    }
}
