package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book firstBook = new Book("First Steps", 150);
        Book secondBook = new Book("Clean Code", 300);
        Book thirdBook = new Book("Your Mind", 500);
        Book fourthBook = new Book("Best Practices", 450);
        Book[] books = new Book[4];
        books[0] = firstBook;
        books[1] = secondBook;
        books[2] = thirdBook;
        books[3] = fourthBook;
        for (Book book: books) {
            System.out.println(book.getName() + " - " + book.getCountList());
        }
        System.out.println("Replace first and fourth books");
        Book tempBook = books[0];
        books[0] = books[3];
        books[3] = tempBook;
        for (Book book: books) {
            System.out.println(book.getName() + " - " + book.getCountList());
        }
        System.out.println("All books with name \"Clean Code\"");
        for (Book book: books) {
            if (book.getName().equals("Clean Code")) {
                System.out.println(book.getName() + " - " + book.getCountList());
            }
        }
    }
}
