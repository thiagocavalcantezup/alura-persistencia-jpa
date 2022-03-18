package br.com.alura.dao;

import javax.persistence.EntityManager;

import br.com.alura.modelo.Produto;

public class ProdutoDao {

    private final EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto) {
        em.persist(produto);
    }

}
