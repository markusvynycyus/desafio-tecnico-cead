package domain.controller;

import domain.model.Tarefa;
import domain.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class TarefaBean {

    private Tarefa tarefa = new Tarefa();
    private List<Tarefa> tarefas;

    @Autowired
    private TarefaService tarefaService;

    @PostConstruct
    public void init() {
        tarefas = tarefaService.listarPorProjeto(1L);
    }

    public void salvar() {
        tarefaService.salvar(tarefa);
        tarefa = new Tarefa();
        tarefas = tarefaService.listarPorProjeto(1L);
    }

    public void excluir(Long id) {
        tarefaService.excluir(id);
        tarefas = tarefaService.listarPorProjeto(1L);
    }

    // Getters e Setters
    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public TarefaService getTarefaService() {
        return tarefaService;
    }

    public void setTarefaService(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }
}


