package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StartUITest {

    @Test
    void whenCreateItem() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();

        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Добавить новую заявку" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Создание новой заявки ===" + System.lineSeparator()
                        + "Добавленная заявка: " + tracker.findAll()[0] + System.lineSeparator()
                        + "Меню:" + System.lineSeparator()
                        + "0. Добавить новую заявку" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item")); /* Добавляется в tracker новая заявка */
        Input input = new MockInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Удалить заявку" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Удаление заявки ===" + System.lineSeparator()
                        + "Заявка удалена успешно." + System.lineSeparator()
                        + "Меню:" + System.lineSeparator()
                        + "0. Удалить заявку" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenExit() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }
}