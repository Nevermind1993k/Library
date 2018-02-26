package com.nevermind.bu.util;

import com.nevermind.bu.config.AppConfig;
import com.nevermind.bu.entity.Book;
import com.nevermind.bu.entity.Literature;
import com.nevermind.bu.service.interfaces.BookService;
import com.nevermind.bu.service.interfaces.LiteratureService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

/**
 * Console Application
 * Contains main functions for user interaction
 *
 * @author Roman Kovaliov
 */
public class ConsoleApplication {

    private static Scanner sc = new Scanner(System.in);
    private static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    private static LiteratureService literatureService = context.getBean(LiteratureService.class);
    private static BookService bookService = context.getBean(BookService.class);

    /**
     * Main function
     * Run Application
     */
    public static void run() {
//        initBooks();
        greeting();

        boolean statusRun = true;

        do {
            System.out.print(" -> ");
            String command = sc.nextLine().trim().toLowerCase();
            switch (command) {
                case "add": {
                    break;
                }
                case "remove": {
                    break;
                }
                case "edit": {
                    break;
                }
                case "get": {
                    break;
                }
                case "exit": {
                    statusRun = false;
                    break;
                }
            }
        } while (statusRun);
    }

    /**
     * Greeting
     * Show instructions how to use the application
     */
    private static void greeting() {

    }

    /**
     * Initialization of some standard values
     */
    private static void initBooks() {
        Literature literature = new Literature("Russian");
        literatureService.save(literature);
        Literature literature1 = new Literature("English");
        literatureService.save(literature1);
        bookService.save(new Book("Philosophy of Java", "Bruce Eckel", 555, "Education", literature));
        bookService.save(new Book("Hello", "World", 222, "Comedy", literature1));
        bookService.save(new Book("Hello2", "World2", 333, "Detective", literature));
        bookService.save(new Book("Hello3", "World3", 444, "Fun", literature));

        context.close();
    }

}
