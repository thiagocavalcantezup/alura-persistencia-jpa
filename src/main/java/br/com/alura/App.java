package br.com.alura;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.modelo.Produto;

public class App {

    public static void main(String[] args) {
        Produto celular = new Produto();
        celular.setNome("Xiaomi Redmi");
        celular.setDescricao("Um celular.");
        celular.setPreco(new BigDecimal("800"));

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(
            "alura-persistencia-jpa"
        );
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(celular);
        em.getTransaction().commit();
        em.close();
    }

}
