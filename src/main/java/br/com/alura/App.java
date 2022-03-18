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
        System.out.println("PRODUTO ####################");
        System.out.println(produto);

        List<Produto> produtos = produtoDao.buscarTodos();
        System.out.println("PRODUTOS ###################");
        System.out.println(produtos);

        List<Produto> produtosNome = produtoDao.buscarPorNome("Xiaomi Redmi");
        System.out.println("PRODUTOS NOME ##############");
        System.out.println(produtosNome);

        List<Produto> produtosCategoria = produtoDao.buscarPorNomeDaCategoria("CELULARES");
        System.out.println("PRODUTOS CATEGORIA #########");
        System.out.println(produtosCategoria);

        em.close();
    }

    private static void cadastrarProduto(EntityManager em, CategoriaDao categoriaDao,
                                         ProdutoDao produtoDao) {
        Categoria celulares = new Categoria("CELULARES");
        Categoria informatica = new Categoria("INFORMÁTICA");
        Produto celular = new Produto(
            "Xiaomi Redmi", "Um celular.", new BigDecimal("800"), celulares
        );
        Produto notebook = new Produto(
            "Dell Inspiron", "Um notebook.", new BigDecimal("3800"), informatica
        );

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        categoriaDao.cadastrar(informatica);
        produtoDao.cadastrar(celular);
        produtoDao.cadastrar(notebook);

        em.getTransaction().commit();
    }

}
