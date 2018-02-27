package com.nevermind.bu.dao;

import com.nevermind.bu.entity.Author;
import com.nevermind.bu.entity.Book;
import com.nevermind.bu.entity.Literature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * DAO class for {@link com.nevermind.bu.entity.Author}.
 * Reads and writes data in to DB
 *
 * @author Roman Kovaliov
 */
@Repository
public interface AuthorDao extends JpaRepository<Author, Integer> {
    Author findById(int id);

    Author findByName(String name);

    @Modifying
    @Transactional
    @Query("update Author set name = ?1, literature=?2 where id = ?3")
    void setAuthorInfoById(String name, Literature literature, int id);

}
