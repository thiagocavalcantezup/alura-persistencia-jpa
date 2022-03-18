package br.com.alura.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory EMFACTORY = Persistence.createEntityManagerFactory(
        "alura-persistencia-jpa"
    );

    public static EntityManager getEntityManager() {
        return EMFACTORY.createEntityManager();
    }

}
