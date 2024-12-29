package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Текущее состояние: " + active);
        System.out.println("Номер статуса: " + status);
        System.out.println("Описание ошибки: " + message);
    }

    public static void main(String[] args) {
        Error firstError = new Error();
        firstError.printInfo();
        Error secondError = new Error(true, 5, "Неверный пароль");
        secondError.printInfo();
    }
}
