package domain.dao;

import domain.model.Tarefa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TarefaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void salvar(Tarefa tarefa) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(tarefa);
    }

    public List<Tarefa> listarPorProjeto(Long projetoId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Tarefa> query = session.createQuery("FROM Tarefa WHERE projeto.id = :projetoId", Tarefa.class);
        query.setParameter("projetoId", projetoId);
        return query.list();
    }

    public void excluir(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<?> query = session.createQuery("DELETE FROM Tarefa WHERE id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}

