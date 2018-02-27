package com.nevermind.bu.service.interfaces;

import com.nevermind.bu.entity.Author;
import com.nevermind.bu.entity.Book;
import com.nevermind.bu.entity.Literature;

import java.util.List;

/**
 * Service interface for {@link Book}.
 *
 * @author Roman Kovaliov
 */
public interface BookService extends IService<Book> {
    Book getByName(String name);

    List<Book> getByAuthor(String authorName);

    List<Book> getByGenre(String genreName);

    List<Book> getByPages(int firstPage, int lastPage);

    void updateById(int id, String name, Author author, int pages, String genre);

}
