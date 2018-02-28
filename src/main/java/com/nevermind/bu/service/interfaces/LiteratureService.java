package com.nevermind.bu.service.interfaces;

import com.nevermind.bu.entity.Literature;

/**
 * Service interface for {@link Literature}.
 *
 * @author Roman Kovaliov
 */
public interface LiteratureService extends IService<Literature> {

    Literature getById(int id);

    Literature getByName(String name);

    void updateById(int id, String name);
}
