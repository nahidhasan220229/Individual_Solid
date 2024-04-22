//*************************************************************************
// TITLE : A JAVA PROGRAMME TO DEMOSTRATE SINGLE RESPONSIBILITY PRINCIPLE .
// AUTHOR : MOZAZA AL , UNDERGRADUATE STUDENT (2ND YEAR) Of KHULNA UNIVERSITY
//*************************************************************************

/**
 * Represents a Book entity with properties and methods to manage its details.
 */
class Book {
    private String title;
    private String author;
    private int pages;

    /**
     * Constructs a new Book with the given title, author, and number of pages.
     * 
     * @param title  the title of the book
     * @param author the author of the book
     * @param pages  the number of pages in the book
     */
    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    /**
     * Returns the title of the book.
     * 
     * @return the title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the author of the book.
     * 
     * @return the author of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the number of pages in the book.
     * 
     * @return the number of pages in the book
     */
    public int getPages() {
        return pages;
    }
}

/**
 * Represents a BookPrinter responsible for printing book details.
 */
class BookPrinter {
    /**
     * Prints the details of the given book.
     * 
     * @param book the book to print
     */
    public void print(Book book) {
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Pages: " + book.getPages());
    }
}

/**
 * Main class to demonstrate the Single Responsibility Principle.
 */
public class SRPExample {
    public static void main(String[] args) {
        // Create a book
        Book book = new Book("Clean Code", "Robert C. Martin", 464);

        // Print the book details
        BookPrinter bookPrinter = new BookPrinter();
        bookPrinter.print(book);
    }
}
