//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}

public class LibraryManagementSystem {

    // Linear search to find books by title
    public static List<Book> linearSearchByTitle(List<Book> books, String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    // Binary search to find a book by title
    public static Book binarySearchByTitle(List<Book> books, String title) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books.get(mid).title.compareToIgnoreCase(title);

            if (comparison == 0) {
                return books.get(mid);
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Title not found
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book(2, "To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book(3, "1984", "George Orwell"));
        books.add(new Book(4, "The Catcher in the Rye", "J.D. Salinger"));
        books.add(new Book(5, "The Great Gatsby", "F. Scott Fitzgerald"));

        // Linear search
        System.out.println("Linear Search Results:");
        List<Book> linearSearchResults = linearSearchByTitle(books, "The Great Gatsby");
        for (Book book : linearSearchResults) {
            System.out.println(book);
        }

        // Sort the books by title for binary search
        books.sort(Comparator.comparing(b -> b.title));

        // Binary search
        System.out.println("\nBinary Search Result:");
        Book binarySearchResult = binarySearchByTitle(books, "1984");
        if (binarySearchResult != null) {
            System.out.println(binarySearchResult);
        } else {
            System.out.println("Book not found.");
        }
    }
}
