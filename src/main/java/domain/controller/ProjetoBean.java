package domain.controller;

import domain.model.Projeto;
import domain.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class ProjetoBean {

    private Projeto projeto = new Projeto();
    private List<Projeto> projetos;

    @Autowired
    private ProjetoService projetoService;

    @PostConstruct
    public void init() {
        projetos = projetoService.listarTodos();
    }

    public void salvar() {
        projetoService.salvar(projeto);
        projeto = new Projeto();
        projetos = projetoService.listarTodos();
    }

    public void excluir(Long id) {
        projetoService.excluir(id);
        projetos = projetoService.listarTodos();
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

}