package com.nevermind.bu.dao;

import com.nevermind.bu.entity.Literature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * DAO class for {@link Literature}.
 * Reads and writes data in to DB
 *
 * @author Roman Kovaliov
 */
@Repository
public interface LiteratureDao extends JpaRepository<Literature, Integer> {
    Literature findById(int id);

    Literature findByName(String name);

    @Modifying
    @Transactional
    @Query("update Literature set name = ?1 where id = ?2")
    void setLiteratureInfoById(String name, int id);
}
