package com.viana.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    // O nome "notasPU" deve ser identico ao que está no seu persistence.xml
    private static EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("notasPU");

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}