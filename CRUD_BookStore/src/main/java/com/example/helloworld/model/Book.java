package com.example.helloworld.model;

public class Book {
    private String bookId;
    private String bookName;
    private String isbn;
    private double price;

    public Book() {
        this.bookId = null;
        this.bookName = null;
        this.isbn = null;
        this.price = 0.0;
    }

    public Book(String bookId, String bookName, String isbn, double price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.isbn = isbn;
        this.price = price;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", bookName=" + bookName + ", isbn=" + isbn + ", price="
                + price + "]";
    }
}
