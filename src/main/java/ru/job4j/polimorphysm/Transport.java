package ru.job4j.polimorphysm;

public interface Transport {
    void  move();

    void passengers(int count);

    int refuel(int fuel);
}
