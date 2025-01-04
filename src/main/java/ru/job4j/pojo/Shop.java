package ru.job4j.pojo;

public class Shop {
    public static int indexOfNull(Product[] products) {
        int num = -1;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                num = i;
                break;
            }
        }
        return num;
    }
}
