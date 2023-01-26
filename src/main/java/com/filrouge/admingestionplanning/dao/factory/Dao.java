package com.filrouge.admingestionplanning.dao.factory;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> get(Long id);   // Read : "SELECT ... FROM ... WHERE...
    List<T> getAll();           //READ : "SELECT *
    void create(T t);           //CREATE : INSERT INTO
    void update(T t);           //UPDATE
    void delete(T t);           //DELETE
}