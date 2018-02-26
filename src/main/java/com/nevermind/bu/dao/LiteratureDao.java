package com.nevermind.bu.dao;

import com.nevermind.bu.entity.Literature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DAO class for {@link Literature}.
 * Reads and writes data in to DB
 */
@Repository
public interface LiteratureDao extends JpaRepository<Literature, Integer> {
    Literature findById(int id);

    Literature findByName(String name);
}
