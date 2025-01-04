package ru.job4j.pojo;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Nick Rose");
        student.setGroup("5A");
        student.setEnterDate(LocalDate.of(2021, 9, 1));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate enterDate = student.getEnterDate();
        System.out.println("Student " + student.getName() + " entered the Institute in group "
                + student.getGroup() + " at " + enterDate.format(formatter));
    }
}
