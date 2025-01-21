package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("jhon2002@mail.ru", "Evgeny");
        map.put("jhon@mail.ru", "Evgeny Fedorovyh");
        map.put("jhon2002@mail.ru", "Evgeny Fedorovyh");
        for (String key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
    }
}
