package ru.mtuci.codi.common;

import org.springframework.data.repository.CrudRepository;

public interface BaseRepo<T> extends CrudRepository<T, Integer> {
}
