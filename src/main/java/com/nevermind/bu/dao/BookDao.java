package com.nevermind.bu.dao;

import com.nevermind.bu.entity.Book;
import com.nevermind.bu.entity.Literature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * DAO class for {@link Book}.
 * Reads and writes data in to DB
 *
 * @author Roman Kovaliov
 */
@Repository
public interface BookDao extends JpaRepository<Book, Integer> {
    Book findById(int id);

    Book findByName(String name);

    @Modifying
    @Transactional
    @Query("update Book set name = ?1, author=?2, pages=?3, genre=?4, literature=?5  where id = ?6")
    void setBookInfoById(String name, String author, int pages, String genre, Literature literature, int id);

    List<Book> findByLiterature(String literature);

}
