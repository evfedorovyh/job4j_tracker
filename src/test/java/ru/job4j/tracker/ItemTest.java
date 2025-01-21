package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ItemTest {

    @Test
    public void whenItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item("Apple"),
                new Item("Orange"),
                new Item("Pear"),
                new Item("Banana")
        );
        List<Item> expected = Arrays.asList(
                new Item("Apple"),
                new Item("Banana"),
                new Item("Orange"),
                new Item("Pear")

        );
        items.sort(new ItemAscByName());
        assertThat(items).containsExactlyElementsOf(expected);
    }

    @Test
    public void whenItemDescByName() {
        List<Item> items = Arrays.asList(
                new Item("Apple"),
                new Item("Orange"),
                new Item("Pear"),
                new Item("Banana")
        );
        List<Item> expected = Arrays.asList(
                new Item("Pear"),
                new Item("Orange"),
                new Item("Banana"),
                new Item("Apple")
        );
        items.sort(new ItemDescByName());
        assertThat(items).containsExactlyElementsOf(expected);
    }
}