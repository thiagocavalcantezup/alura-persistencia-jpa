package br.com.alura;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.dao.CategoriaDao;
import br.com.alura.dao.ProdutoDao;
import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Produto;
import br.com.alura.util.JPAUtil;

public class App {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();

        Categoria celulares = new Categoria("CELULARES");
        Categoria testes = new Categoria("TESTES");
        Produto celular = new Produto(
            "Xiaomi Redmi", "Um celular.", new BigDecimal("800"), celulares
        );

        CategoriaDao categoriaDao = new CategoriaDao(em);
        ProdutoDao produtoDao = new ProdutoDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);

        System.out.println("// Testes");
        categoriaDao.cadastrar(testes);
        testes.setNome("NOVO NOME");

        em.flush();
        em.clear();

        testes = categoriaDao.atualizar(testes);
        testes.setNome("OUTRO NOME");
        em.flush();

        categoriaDao.remover(testes);
        em.flush();

        em.getTransaction().commit();
        em.close();
    }

}
