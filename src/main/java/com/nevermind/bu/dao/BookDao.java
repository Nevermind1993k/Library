package com.nevermind.bu.dao;

import com.nevermind.bu.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DAO class for {@link Book}.
 * Reads and writes data in to DB
 */
@Repository
public interface BookDao extends JpaRepository<Book, Integer> {
    Book findById(int id);

    Book findByName(String name);

}
