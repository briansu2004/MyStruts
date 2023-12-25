package com.example.helloworld.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.helloworld.model.Book;

public class BookService {
    // Assume this is a simple in-memory database for demonstration purposes
    private static final Map<String, Book> bookDatabase = new HashMap<>();

    static {
        // Populate some sample books
        initializeBookDatabase();
    }

    private static void initializeBookDatabase() {
        // Adding multiple books to the book database during initialization
        initAddBook(new Book("1", "The Great Gatsby", "1234567890", 19.99));
        initAddBook(new Book("2", "To Kill a Mockingbird", "9876543210", 24.99));
        initAddBook(new Book("3", "1984", "3456789012", 15.50));
        // initAddBook(new Book("4", "The Catcher in the Rye", "2345678901", 12.75));
        // initAddBook(new Book("5", "Pride and Prejudice", "5678901234", 18.25));
        // initAddBook(new Book("6", "The Hobbit", "6789012345", 22.99));
        // initAddBook(new Book("7", "One Hundred Years of Solitude", "7890123456", 28.50));
        // initAddBook(new Book("8", "The Lord of the Rings", "8901234567", 32.75));
        // initAddBook(new Book("9", "Brave New World", "9012345678", 14.99));
        // initAddBook(new Book("10", "The Shining", "0123456789", 27.50));
        // initAddBook(new Book("11", "The Hunger Games", "3456789012", 19.99));
        // initAddBook(new Book("12", "The Da Vinci Code", "4567890123", 25.50));
    }

    public static void initAddBook(Book book) {
        bookDatabase.put(book.getBookId(), book);
    }

    public List<Book> getAllBooks() {
        // Retrieve all books from the book database
        return new ArrayList<>(bookDatabase.values());
    }

    public Book getBookData(String bookId) {
        // Assume we are fetching additional data related to the book
        // For simplicity, let's say we're just adding a prefix to the book name
        if (bookId == null) {
            return null;
        }

        Book book = bookDatabase.get(bookId);
        if (book == null) {
            return null;
        }

        book.setBookName(book.getBookName());
        return book;
    }

    public void addBook(Book book) {
        // Find the maximum book ID in the current bookDatabase
        int maxId = bookDatabase.keySet().stream().mapToInt(Integer::parseInt).max().orElse(0);

        // Increment the max ID to generate a new book ID
        int newBookId = maxId + 1;

        // Set the new book ID to the book being added
        book.setBookId(String.valueOf(newBookId));

        // Assume we are adding a new book to the database
        bookDatabase.put(book.getBookId(), book);
    }

    public void updateBook(Book book) {
        // Assume we are updating an existing book in the database
        bookDatabase.put(book.getBookId(), book);
    }
}
