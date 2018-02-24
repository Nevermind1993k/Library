package com.nevermind.bu.service;

import com.nevermind.bu.entity.Book;
/**
 * Service interface for {@link Book}.
 */
public interface BookService extends IService<Book> {
    Book getByName(String name);
}
