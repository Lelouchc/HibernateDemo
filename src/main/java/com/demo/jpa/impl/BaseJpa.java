package com.demo.jpa.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * Created by yy on 2016/3/18.
 */
public class BaseJpa {
    private EntityManager entityManager;

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    public BaseJpa setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
        return this;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
