package com.nevermind.bu.service.interfaces;

import com.nevermind.bu.entity.Author;
import com.nevermind.bu.entity.Literature;

/**
 * Service interface for {@link Author}.
 *
 * @author Roman Kovaliov
 */
public interface AuthorService extends IService<Author> {
    Author getByName(String name);

    void updateById(int id, String name, Literature literature);
}
