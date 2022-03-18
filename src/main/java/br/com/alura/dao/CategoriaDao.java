package br.com.alura.dao;

import javax.persistence.EntityManager;

import br.com.alura.modelo.Categoria;

public class CategoriaDao {

    private final EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Categoria categoria) {
        em.persist(categoria);
    }

    public Categoria atualizar(Categoria categoria) {
        return em.merge(categoria);
    }

    public void remover(Categoria categoria) {
        categoria = atualizar(categoria);
        em.remove(categoria);
    }

}
