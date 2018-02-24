package com.nevermind.bu;

import com.nevermind.bu.config.AppConfig;
import com.nevermind.bu.entity.Book;
import com.nevermind.bu.service.BookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.List;

/**
 * Main class
 */
public class Main {

    public static void main(String[] args) {
        disableLoggers();
        // write your code here
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        BookService bookService = context.getBean(BookService.class);

        bookService.save(new Book("Philosophy of Java", "Bruce Eccel", 555));
        bookService.save(new Book("Hello", "World", 222));
        bookService.save(new Book("Hello2", "World2", 333));
        bookService.save(new Book("Hello3", "World3", 444));

        List<Book> books = bookService.getAll();
        for (Book book : books) {
            System.out.println("Id = " + book.getId());
            System.out.println("Name = " + book.getName());
            System.out.println("Author = " + book.getAuthor());
            System.out.println("Pages = " + book.getPages());
        }

        context.close();
    }

    private static void disableLoggers() {
        List<Logger> loggers = Collections.<Logger>list(LogManager.getCurrentLoggers());
        loggers.add(LogManager.getRootLogger());
        for (Logger logger : loggers) {
            logger.setLevel(Level.OFF);
        }
    }
}
