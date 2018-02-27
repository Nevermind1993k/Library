package com.nevermind.bu.util;

import com.nevermind.bu.config.AppConfig;
import com.nevermind.bu.entity.Author;
import com.nevermind.bu.entity.Book;
import com.nevermind.bu.entity.Literature;
import com.nevermind.bu.service.interfaces.AuthorService;
import com.nevermind.bu.service.interfaces.BookService;
import com.nevermind.bu.service.interfaces.LiteratureService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
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
    private static AuthorService authorService = context.getBean(AuthorService.class);
    private static BookService bookService = context.getBean(BookService.class);

    /**
     * Main function
     * Run Application
     */
    public static void run() {

        boolean runStatus = true;

        greeting();
//        initBooks();


        while (runStatus) {
            System.out.print(" -> ");
            try {
                int command = Integer.parseInt(sc.nextLine());
                switch (command) {
                    case 1: {
                        break;
                    }
                    case 2: {
                        chooseCategoryForPrint();
                        break;
                    }
                    case 3: {
                        break;
                    }
                    case 4: {
                        break;
                    }
                    case 5: {
                        runStatus = false;
                        break;
                    }
                }
            } catch (NumberFormatException ex) {
                System.err.println("Not a number. Try again.");
            }
        }
    }

    /**
     * Greeting
     * Show instructions how to use the console application
     */
    private static void greeting() {
        System.out.print("Welcome to library! \n " +
                "Commands : \n 1.Add \n 2.Select \n 3.Update \n 4.Delete \n 5.Exit \n ");

    }

    /**
     * Choose Category
     * Method method allows to navigate through subcategories
     */
    private static void chooseCategoryForPrint() {
        System.out.print("Choose one of the category for print: \n 1.Literature \n 2.Authors \n 3.Books \n -> ");
        try {
            int category = Integer.parseInt(sc.nextLine());
            switch (category) {
                case 1: {
                    printLiterature(selectLiterature());
                    break;
                }
                case 2: {
                    printAuthors(selectAuthors());
                    break;
                }
                case 3: {
                    printBooks(selectBooks());
                    break;
                }
            }
        } catch (NumberFormatException ex) {
            System.err.println("Not a number. Try again.");
        }
    }

    /**
     * Print Literature
     * Method prints information about literature from literature list
     *
     * @param literatureList - list of literature that need to be printed
     */
    private static void printLiterature(List<Literature> literatureList) {
        if (literatureList != null) {
            for (int i = 0; i < literatureList.size(); i++) {
                System.out.println(" " + i + "  : " + literatureList.get(i));
            }
        }
    }

    /**
     * Select Literature
     * Provide tools for getting list of literature with some argument
     *
     * @return list of literature
     */
    private static List<Literature> selectLiterature() {
        System.out.print(" Select by : \n 1.All \n 2.Name \n  -> ");
        List<Literature> literatureToReturn = new ArrayList<>();
        try {
            int type = Integer.parseInt(sc.nextLine());
            switch (type) {
                case 1: {
                    System.out.print(" All Literature -> ");
                    literatureToReturn = literatureService.getAll();
                    return literatureToReturn;
                }
                case 2: {
                    System.out.print(" Name -> ");
                    String literatureName = sc.nextLine();
                    literatureToReturn.add(literatureService.getByName(literatureName));
                    return literatureToReturn;
                }
            }
        } catch (NumberFormatException ex) {
            System.err.println("Not a number. Try again");
        }
        return new ArrayList<>();
    }

    /**
     * Print Authors
     * Method prints information about authors from author list
     *
     * @param authors - list of authors that need to be printed
     */
    private static void printAuthors(List<Author> authors) {
        if (authors != null) {
            for (int i = 0; i < authors.size(); i++) {
                System.out.println(" " + i + "  : " + authors.get(i));
            }
        }
    }

    /**
     * Select Authors
     * Provide tools for getting list of authors with some argument
     *
     * @return list of authors
     */
    private static List<Author> selectAuthors() {
        System.out.print(" Select by : \n 1.All \n 2.Name \n  -> ");
        List<Author> authorsToReturn = new ArrayList<>();
        try {
            int type = Integer.parseInt(sc.nextLine());
            switch (type) {
                case 1: {
                    System.out.print(" All Authors -> ");
                    authorsToReturn = authorService.getAll();
                    return authorsToReturn;
                }
                case 2: {
                    System.out.print(" Name -> ");
                    String authorName = sc.nextLine();
                    authorsToReturn.add(authorService.getByName(authorName));
                    return authorsToReturn;
                }
            }
        } catch (NumberFormatException ex) {
            System.err.println("Not a number. Try again");
        }
        return new ArrayList<>();
    }


    /**
     * Print Books
     * Method prints information about books from books list
     *
     * @param books - list of books that need to be printed
     */
    private static void printBooks(List<Book> books) {
        if (books != null) {
            for (int i = 0; i < books.size(); i++) {
                System.out.println(" " + i + "  : " + books.get(i));
            }
        }
    }


    /**
     * Select Books
     * Provide tools for getting list of books with some argument
     *
     * @return list of books
     */
    private static List<Book> selectBooks() {
        System.out.print(" Select by : \n 1.All \n 2.Name \n 3.Author \n 4.Genre \n 5.Pages \n -> ");
        List<Book> booksToReturn = new ArrayList<>();
        try {
            int type = Integer.parseInt(sc.nextLine());
            switch (type) {
                case 1: {
                    System.out.print(" All Books -> ");
                    booksToReturn = bookService.getAll();
                    return booksToReturn;
                }
                case 2: {
                    System.out.print(" Name -> ");
                    String bookName = sc.nextLine();
                    booksToReturn.add(bookService.getByName(bookName));
                    return booksToReturn;
                }
                case 3: {
                    System.out.print(" Author -> ");
                    String authorName = sc.nextLine();
                    booksToReturn = bookService.getByAuthor(authorName);
                    return booksToReturn;
                }
                case 4: {
                    System.out.print(" Genre -> ");
                    String genreName = sc.nextLine();
                    booksToReturn = bookService.getByGenre(genreName);
                    return booksToReturn;
                }
                case 5: {
                    System.out.print(" Pages : \n" +
                            " Enter first page of search range -> ");
                    int firstPage = sc.nextInt();
                    System.out.print("Enter last page of search range -> ");
                    int lastPage = sc.nextInt();
                    booksToReturn = bookService.getByPages(firstPage, lastPage);
                    return booksToReturn;
                }
            }
        } catch (NumberFormatException ex) {
            System.err.println("Not a number. Try again");
        }
        return new ArrayList<Book>();
    }


    /**
     * Initialization of standard values for DB
     */
    private static void initBooks() {

        Literature rusLit = new Literature("Russian");
        Literature engLit = new Literature("English");
        literatureService.save(rusLit);
        literatureService.save(engLit);

        Author author = new Author("Bruce Eckel", engLit);
        Author author1 = new Author("Lev Tolstoy", rusLit);
        Author author2 = new Author("Fedor Dostoevskiy", rusLit);
        Author author3 = new Author("Steven King", engLit);
        authorService.save(author);
        authorService.save(author1);
        authorService.save(author2);
        authorService.save(author3);

        bookService.save(new Book("Philosophy of Java", author, 666, "Education"));
        bookService.save(new Book("Voina i Mir", author1, 555, "Novel"));
        bookService.save(new Book("Idiot", author2, 432, "Novel"));
        bookService.save(new Book("It", author3, 400, "Novel"));
        bookService.save(new Book("Shining", author3, 500, "Novel"));

        context.close();
    }

}
