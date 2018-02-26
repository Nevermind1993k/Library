package com.nevermind.bu.service;

import com.nevermind.bu.dao.LiteratureDao;
import com.nevermind.bu.entity.Book;
import com.nevermind.bu.entity.Literature;
import com.nevermind.bu.service.interfaces.LiteratureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of {@link LiteratureService} interface.
 */
@Service
public class LiteratureServiceImpl implements LiteratureService {

    @Autowired
    private LiteratureDao literatureDao;


    @Override
    public Literature getByName(String name) {
        return literatureDao.findByName(name);
    }

    @Override
    public Literature getById(int id) {
        return literatureDao.findById(id);
    }

    @Override
    public List<Literature> getAll() {
        return literatureDao.findAll();
    }

    @Override
    public void save(Literature entity) {
        literatureDao.save(entity);
    }

    @Override
    public void delete(int id) {
        literatureDao.delete(id);
    }

    @Override
    public void update(Literature entity) {
        literatureDao.save(entity);
    }
}
