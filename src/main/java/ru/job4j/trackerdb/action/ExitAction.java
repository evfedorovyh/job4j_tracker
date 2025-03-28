package ru.job4j.trackerdb.action;

import ru.job4j.trackerdb.Tracker;
import ru.job4j.trackerdb.input.Input;
import ru.job4j.trackerdb.output.Output;

public class ExitAction implements UserAction {
    private final Output output;

    public ExitAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Завершить программу";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Завершение программы ===");
        return false;
    }
}
