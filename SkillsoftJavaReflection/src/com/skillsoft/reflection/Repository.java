package com.skillsoft.reflection;

public interface Repository {

    void create(Object obj);

    Object read(int id);

    void update(Object obj);

    void delete(int id);
}
