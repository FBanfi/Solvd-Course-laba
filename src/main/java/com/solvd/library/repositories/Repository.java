package com.solvd.library.repositories;

import com.solvd.library.exception.ExceptionRegister;

import java.util.Set;

public class Repository<T> {
    private final String tableName;
    private Set<T> objects;

    public Repository(String tableName) {
        this.tableName = tableName;
    }

    public void add(T object) {
        if (this.repositoryContains(object)) {
            throw new ExceptionRegister("It already exist on this repository, you should have used a Set Collection!!");
        }
        this.objects.add(object);
    }

    public boolean repositoryContains(T objeto) {
        return objects.contains(objeto);
    }

}
