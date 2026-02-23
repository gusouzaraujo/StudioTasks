package com.gudymaker.studiotasks.controllers;
import org.springframework.beans.factory.annotation.Autowired; //injeta automaticamente o objeto (sem usar new) via spring
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; //Permite personalizar a resposta da API (Status http + corpo JSON)
import org.springframework.web.bind.annotation.*; //Anotações da API REST

import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI; //tipo de URI do location

import java.util.List; //Lista de objetos (retorno de várias tarefas)
import com.gudymaker.studiotasks.model.Tarefa; //Entidade Tarefa usada nos métodos
import com.gudymaker.studiotasks.service.TarefaService; // Lógica de negócio usada pelo controller

@RestController // classe de API REST
@RequestMapping ("/tarefas") //prefixo para todas rotas @ desse controller
public class TarefaController {

    private final TarefaService tarefaService; //Dependência usada no metodo

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService; //Service injetado para no Construtor
    }

    @PostMapping //o metodo abaixo vai responder requisições HTTP do tipo POST
    public ResponseEntity<Tarefa> criar (@RequestBody Tarefa tarefa){ // lê JSON -> Tarefa
        Tarefa tarefaSalva = tarefaService.salvar(tarefa); //regra de negócio (persiste)
        //mostra location:/tarefas/{idRecemCriado}
        URI location = ServletUriComponentsBuilder // endereço do novo recurso criado
                .fromCurrentRequest() // pega a url da requisoção atual
                .path("/{id}") //adiciona o campo id no final
                .buildAndExpand(tarefaSalva.getId()) //Subsitui pelo valor id real
                .toUri(); // torna o objeto real
        return ResponseEntity.created(location).body(tarefaSalva); // retorna 201 created com location e corpo JSON
    }

    @GetMapping //Requisições GET
    public List<Tarefa> listar(){ //Retorna uma lista de Tarefas  (List é uma Interface)
        return tarefaService.listar(); // Chama o metodo listar da classe Service (TarefaService)
    }
    @GetMapping("/{id}") // Define que essa rota espera um id na url
    public Tarefa buscarPorId (@PathVariable Long id) { //pega o id da url no metodo
        return tarefaService.buscarPorId(id) //chama o metodo buscarPorId do Service
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "TAREFA NÃO ENCONTRADA")); //Verificação/exceção que retorna erro 404
    }

    @DeleteMapping("/{id}") //Define que esse metodo irá apagar uma tarefa específica via ID da URL
    public ResponseEntity<Void> deletar (@PathVariable Long id){ //Recebe o id da tarefa
        //obs: Só o tarefaService.deletar(id); chama o deleteById(id) lá no TarefaService, mas não verifica se a tarefa existe antes de deletar, pois então..
        tarefaService.buscarPorId(id) //Verifica se existe
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "TAREFA NÃO ENCONTRADA")); //se não existir, lança erro 404

        tarefaService.deletar(id); // se existir, deleta a tarefa
        return ResponseEntity.noContent().build(); //Retorna 204 no content (sucesso, sem corpo)
    }

    @PutMapping ("/{id}") //Requisição http do tipo put/atualizar tarefa com id específico
    public ResponseEntity<Tarefa> atualizar (@PathVariable Long id, @RequestBody Tarefa novaTarefa){ //recebe o id da url e os novos dados da tarefa (em JSON) para atualizar

        Tarefa tarefaExistente = tarefaService.buscarPorId(id) //Verifica se a tarefa existe no banco, se encontrar guarde na variável tarefaExistente
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "TAREFA NÃO ENCONTRADA")); //se não existir, lança erro 404

        tarefaExistente.setTitle(novaTarefa.getTitle()); //Define o novo nome da tarefa antiga com base no que veio do usuário
        tarefaExistente.setCompleted(novaTarefa.isCompleted()); //Define a novo status de conclusão da tarefa antiga com base no que veio do usuário

        tarefaService.salvar(tarefaExistente); //Salva a tarefa atualizada no banco
        return ResponseEntity.ok(tarefaExistente);
    }





}
