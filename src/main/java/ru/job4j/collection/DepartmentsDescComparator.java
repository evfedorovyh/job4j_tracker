package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int result;
        String[] s1 = o1.split("/");
        String[] s2 = o2.split("/");
        result = s2[0].compareTo(s1[0]);
        if (result != 0) {
            return result;
        }
        for (int i = 1; i < Math.min(s1.length, s2.length); i++) {
            result = s1[i].compareTo(s2[i]);
            if (result != 0) {
                return result;
            }
        }
        return Integer.compare(s1.length, s2.length);
    }
}
