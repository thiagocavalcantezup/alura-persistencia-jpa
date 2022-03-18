package br.com.alura;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.dao.ProdutoDao;
import br.com.alura.modelo.Produto;
import br.com.alura.util.JPAUtil;

public class App {

    public static void main(String[] args) {
        Produto celular = new Produto();

        celular.setNome("Xiaomi Redmi");
        celular.setDescricao("Um celular.");
        celular.setPreco(new BigDecimal("800"));

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao dao = new ProdutoDao(em);

        em.getTransaction().begin();
        dao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }

}
