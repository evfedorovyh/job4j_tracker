package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int leftLength = left.length();
        int rightLength = right.length();
        int count = leftLength <= rightLength ? leftLength : rightLength;
        int result = 0;
        for (int index = 0; index < count; index++) {
            result = Character.compare(left.charAt(index), right.charAt(index));
            if (result != 0) {
               break;
            }
        }
        if (result == 0) {
            result = Integer.compare(leftLength, rightLength);
        }
        return result;
    }
}
