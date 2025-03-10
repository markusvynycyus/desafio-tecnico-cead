package domain.service;

import domain.dao.ProjetoDAO;
import domain.model.Projeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoDAO projetoDAO;

    public void salvar(Projeto projeto) {
        projetoDAO.salvar(projeto);
    }

    public Projeto buscarPorId(Long id) {
        return projetoDAO.buscarPorId(id);
    }

    public List<Projeto> listarTodos() {
        return projetoDAO.listarTodos();
    }

    public void excluir(Long id) {
        projetoDAO.excluir(id);
    }
}