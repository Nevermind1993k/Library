package com.nevermind.bu;

import com.nevermind.bu.config.AppConfig;
import com.nevermind.bu.entity.Book;
import com.nevermind.bu.entity.Literature;
import com.nevermind.bu.service.interfaces.BookService;
import com.nevermind.bu.service.interfaces.LiteratureService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Main class
 */
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        LiteratureService literatureService = context.getBean(LiteratureService.class);
        BookService bookService = context.getBean(BookService.class);


        literatureService.save(new Literature("Russian"));
        literatureService.save(new Literature("European"));
        bookService.save(new Book("Philosophy of Java", "Bruce Eccel", 555,"Education"));
        bookService.save(new Book("Hello", "World", 222,"Comedy"));
        bookService.save(new Book("Hello2", "World2", 333,"Detective"));
        bookService.save(new Book("Hello3", "World3", 444,"Fun"));

        List<Book> books = bookService.getAll();
        for (Book book : books) {
            System.out.println("Id = " + book.getId());
            System.out.println("Name = " + book.getName());
            System.out.println("Author = " + book.getAuthor());
            System.out.println("Pages = " + book.getPages());
        }

        context.close();
    }
}
