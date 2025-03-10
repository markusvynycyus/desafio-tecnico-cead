package domain.dao;

import domain.model.Projeto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ProjetoDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void salvar(Projeto projeto) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(projeto);
    }

    public Projeto buscarPorId(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Projeto.class, id);
    }

    public List<Projeto> listarTodos() {
        Session session = sessionFactory.getCurrentSession();
        Query<Projeto> query = session.createQuery("FROM Projeto", Projeto.class);
        return query.list();
    }

    public void excluir(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<?> query = session.createQuery("DELETE FROM Projeto WHERE id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}

