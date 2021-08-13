package com.rest.webapi.base;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
@Repository
public abstract class GenericDaoImpl<E extends BaseModel, K extends Serializable>
        implements GenericDao<E, K> {

    @Autowired
    private SessionFactory sessionFactory;



    protected Class<? extends E> daoType;


    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
    }

    private Session currentSession() {
        return this.sessionFactory.openSession();
    }

    @Override
    public void add(E entity) {
        currentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(E entity) {
        currentSession().saveOrUpdate(entity);
    }

    @Override
    public void update(E entity) {
        currentSession().saveOrUpdate(entity);
    }

    @Override
    public void remove(E entity) {
        currentSession().delete(entity);
    }

    @Override
    public E find(K key) {
        return (E) currentSession().get(daoType, key);
    }

    @Override
    public List<E> getAll() {
        return currentSession().createCriteria(daoType).list();
    }

    @Override
    public List<E> search(HashMap<String,String> searchFilter){
        CriteriaBuilder cb = currentSession().getCriteriaBuilder();
        CriteriaQuery cr = cb.createQuery(daoType);
        Root root = cr.from(daoType);
        List<Predicate> perdicates = new ArrayList<>();
        for (Map.Entry me : searchFilter.entrySet()) {
            perdicates.add(cb.equal(root.get(me.getKey().toString()), me.getValue()));
        }
        Predicate[] intArray = new Predicate[perdicates.size()];
        cr.select(root).where(perdicates.toArray(intArray));
        Query<E> query = currentSession().createQuery(cr);
       return  query.getResultList();
    }
}
