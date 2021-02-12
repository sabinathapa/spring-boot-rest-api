package com.rest.webapi.base;

import java.util.List;

public interface GenericService<E, K> {
 void saveOrUpdate(E entity);
 List<E> getAll();
 E get(K id);
 void add(E entity);
 void update(E entity);
 void remove(E entity);
 void removeById(K id);
        }