package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
        try (PreparedStatement statement =
                     connection.prepareStatement("ALTER TABLE items ALTER COLUMN id RESTART WITH 1")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(1)).isEqualTo(item);
    }

    @Test
    public void whenSaveItemAndFindByNameMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item firstItem = new Item("first");
        Item secondItem = new Item("second");
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(firstItem);
        assertThat(tracker.findByName("first").size()).isEqualTo(2);
        assertThat(tracker.findByName("first").get(0)).isEqualTo(firstItem);
        assertThat(tracker.findByName("first").get(1)).isEqualTo(firstItem);
    }

    @Test
    public void whenSaveThreeItemsAndFindAllMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item firstItem = new Item("first");
        Item secondItem = new Item("second");
        Item thirdItem = new Item("third");
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        assertThat(tracker.findAll().size()).isEqualTo(3);
        assertThat(tracker.findAll()).hasSameElementsAs(List.of(firstItem, secondItem, thirdItem));
    }

    @Test
    public void whenSaveThreeItemsAndDeleteOneMustBeTwoAndSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item firstItem = new Item("first");
        Item secondItem = new Item("second");
        Item thirdItem = new Item("third");
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        tracker.delete(2);
        assertThat(tracker.findAll().size()).isEqualTo(2);
        assertThat(tracker.findAll()).hasSameElementsAs(List.of(firstItem, thirdItem));
    }

    @Test
    public void whenSaveThreeItemsAndReplaceSecondMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item firstItem = new Item("first");
        Item secondItem = new Item("second");
        Item thirdItem = new Item("third");
        Item fourthItem = new Item("fourth");
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        tracker.replace(2, fourthItem);
        assertThat(tracker.findAll().size()).isEqualTo(3);
        assertThat(tracker.findAll()).hasSameElementsAs(List.of(firstItem, fourthItem, thirdItem));
    }
}