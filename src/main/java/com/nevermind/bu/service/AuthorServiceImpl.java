package com.nevermind.bu.service;

import com.nevermind.bu.dao.AuthorDao;
import com.nevermind.bu.entity.Author;
import com.nevermind.bu.entity.Literature;
import com.nevermind.bu.service.interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of {@link AuthorService} interface.
 *
 * @author Roman Kovaliov
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorDao authorDao;

    @Override
    public Author getByName(String name) {
        return authorDao.findByName(name);
    }

    @Override
    public Author getById(int id) {
        return authorDao.findById(id);
    }

    @Override
    public List<Author> getAll() {
        return authorDao.findAll();
    }

    @Override
    public void save(Author author) {
        authorDao.save(author);
    }

    @Override
    public void delete(int id) {
        authorDao.delete(id);
    }

    @Override
    public void update(Author author) {
        authorDao.save(author);
    }

    @Override
    public void updateById(int id, String name, Literature literature) {
        authorDao.setAuthorInfoById(name, literature, id);
    }
}
