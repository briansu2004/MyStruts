package com.example.helloworld.action;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import com.example.helloworld.model.Book;
import com.example.helloworld.service.BookService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class BookAction extends ActionSupport implements Preparable {
    private static final Logger log = LogManager.getLogger(BookAction.class);

    private String bookId;
    private Book book;
    private List<Book> bookList = new ArrayList<>();
    private BookService bookService = new BookService();

    public String viewBookList() {
        listAllBooks();

        // Other business logic...

        return SUCCESS;
    }

    @Override
    public void prepare() throws Exception {
        // Common preparation logic before the main execute or other actions
        // For example, fetching additional data or performing initialization
        // This method is automatically called before the execute method

        // In this example, let's say we want to fetch some additional data
        // related to the book before executing the main business logic.
        // This can help to avoid duplicating this logic in each method.

        log.info("[prepare] bookId: " + bookId);

        if (bookId == null) {
            // Initialize the book object
            book = new Book();
        } else {
            book = bookService.getBookData(bookId);
            log.info("Book ID: {}", book.getBookId());
            log.info("Book Name: {}", book.getBookName());
            log.info("ISBN: {}", book.getIsbn());
            log.info("Price: {}", book.getPrice());
            log.info("--------");
        }
    }

    public String viewBook() throws Exception {
        book = getBookById();

        // Other business logic...

        return SUCCESS;
    }

    private Book getBookById() {
        if (ServletActionContext.getRequest() != null
                && ServletActionContext.getRequest().getParameter("bookId") != null) {
            bookId = ServletActionContext.getRequest().getParameter("bookId");
        }

        if (bookId == null) {
            log.info("ServletActionContext.getRequest().getParameter(\"bookId\") is null");
        } else {
            // View book details
            // The book object is already prepared in the 'prepare' method
            book = bookService.getBookData(bookId);
            log.info("[viewBook] " + bookId + ":");
            log.info("Book ID: {}", book.getBookId());
            log.info("Book Name: {}", book.getBookName());
            log.info("ISBN: {}", book.getIsbn());
            log.info("Price: {}", book.getPrice());
            log.info("--------");
        }

        return book;
    }

    public String addBook() throws Exception {
        // Add a new book
        // You can perform validation and additional logic here
        // For simplicity, let's assume the book object is already populated with form data

        bookService.addBook(book);

        listAllBooks();

        return SUCCESS;
    }

    private void listAllBooks() {
        // Retrieve the list of books from the BookService
        bookList = bookService.getAllBooks();

        // Log the contents of bookList
        log.info("Contents of bookList:");
        for (Book book : bookList) {
            log.info("Book ID: {}", book.getBookId());
            log.info("Book Name: {}", book.getBookName());
            log.info("ISBN: {}", book.getIsbn());
            log.info("Price: {}", book.getPrice());
            // Add more properties as needed
            log.info("--------");
        }
    }

    public String updateBook() throws Exception {
        // Update book details
        // The book object is already prepared in the 'prepare' method

        // Specific business logic for updating a book...

        book = getBookById();

        return SUCCESS;
    }

    // Getters and setters...
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
