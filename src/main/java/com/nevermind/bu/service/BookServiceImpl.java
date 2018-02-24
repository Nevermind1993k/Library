package com.nevermind.bu.service;

import com.nevermind.bu.dao.BookDao;
import com.nevermind.bu.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Implementation of {@link BookService} interface.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Book getByName(String name) {
        return bookDao.findByName(name);
    }

    @Override
    public Book getById(int id) {
        return bookDao.findById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.findAll();
    }

    @Override
    public void save(Book entity) {
        bookDao.save(entity);
    }

    @Override
    public void delete(int id) {
        bookDao.delete(id);
    }

    @Override
    public void update(Book entity) {
        bookDao.save(entity);
    }
}
