package org.example;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load the Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the BookService bean from the context
        BookService bookService = (BookService) context.getBean("bookService");

        // Call the manageBooks method to test the dependency injection
        bookService.manageBooks();
    }
}
