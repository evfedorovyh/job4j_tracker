package ru.job4j.trackerdb.action;

import ru.job4j.trackerdb.Tracker;
import ru.job4j.trackerdb.input.Input;

public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);
}
