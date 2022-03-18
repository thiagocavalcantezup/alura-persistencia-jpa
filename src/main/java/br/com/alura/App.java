package br.com.alura;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.dao.CategoriaDao;
import br.com.alura.dao.ProdutoDao;
import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Produto;
import br.com.alura.util.JPAUtil;

public class App {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ProdutoDao produtoDao = new ProdutoDao(em);

        cadastrarProduto(em, categoriaDao, produtoDao);

        Produto produto = produtoDao.buscarPorId(1L);
        System.out.println(produto);

        List<Produto> produtos = produtoDao.buscarTodos();
        System.out.println(produtos);

        em.close();
    }

    private static void cadastrarProduto(EntityManager em, CategoriaDao categoriaDao,
                                         ProdutoDao produtoDao) {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto(
            "Xiaomi Redmi", "Um celular.", new BigDecimal("800"), celulares
        );

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);

        em.getTransaction().commit();
    }

}
