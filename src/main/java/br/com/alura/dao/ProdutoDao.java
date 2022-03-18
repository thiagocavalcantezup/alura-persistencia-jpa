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

    public Produto atualizar(Produto produto) {
        return em.merge(produto);
    }

    public void remover(Produto produto) {
        produto = atualizar(produto);
        em.remove(produto);
    }

}
