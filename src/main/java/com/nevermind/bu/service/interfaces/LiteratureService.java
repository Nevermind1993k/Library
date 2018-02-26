package com.nevermind.bu.service.interfaces;

import com.nevermind.bu.entity.Literature;

/**
 * Service interface for {@link Literature}.
 */
public interface LiteratureService extends IService<Literature> {
    Literature getByName(String name);
}
