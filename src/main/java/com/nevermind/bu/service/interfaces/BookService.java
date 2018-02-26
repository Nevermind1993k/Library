package com.nevermind.bu.service.interfaces;

import com.nevermind.bu.entity.Book;
import com.nevermind.bu.entity.Literature;

/**
 * Service interface for {@link Book}.
 *
 * @author Roman Kovaliov
 */
public interface BookService extends IService<Book> {
    Book getByName(String name);

    void updateById(int id,String name, String author, int pages, String genre, Literature literature);

}
