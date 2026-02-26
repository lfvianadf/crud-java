package com.viana.bean;

import com.viana.model.Nota;
import com.viana.util.JPAUtil;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class NotaBean implements Serializable {
    private Nota nota = new Nota();
    private List<Nota> notas;

    public void salvar() {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        if (nota.getId() == null) {
            em.persist(nota);
        } else {
            em.merge(nota);
        }
        em.getTransaction().commit();
        em.close();
        nota = new Nota(); // Limpa o formulário
        notas = null;      // Força recarregar a lista
    }

    public void editar(Nota n) {
        this.nota = n;
    }

    public List<Nota> getNotas() {
        if (notas == null) {
            EntityManager em = JPAUtil.getEntityManager();
            notas = em.createQuery("select n from Nota n", Nota.class).getResultList();
            em.close();
        }
        return notas;
    }

    public void excluir(Nota n) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        n = em.merge(n); // Garante que o objeto está "anexado" ao JPA
        em.remove(n);
        em.getTransaction().commit();
        em.close();
        notas = null;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }
}