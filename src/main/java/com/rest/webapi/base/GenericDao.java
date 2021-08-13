package com.rest.webapi.base;

import java.util.HashMap;
import java.util.List;

public interface GenericDao<E extends BaseModel,K> {
     void add(E entity) ;
     void saveOrUpdate(E entity) ;
     void update(E entity) ;
     void remove(E entity);
     E find(K key);
     List<E> getAll();
     List<E> search(HashMap<String, String> searchFilter);
}