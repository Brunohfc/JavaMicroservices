package com.training.hrworker.resources;


import com.training.hrworker.entities.Worker;
import com.training.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//fazendo o mapeamento para tornar uma aplicacao web com APIs
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
    @Autowired
    private WorkerRepository reepository;

    //o responseEntity encapsula as respostas http e aqui retorna uma lista de workres
    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> listAllWorker = reepository.findAll();
            //vai retornar a lista de todos os workers salvo no DB
        return ResponseEntity.ok(listAllWorker);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        Worker worker = reepository.findById(id).get(); //reepository.findById retorna um objeto opcional, precisa inserir o .get()
        return ResponseEntity.ok(worker);
    }


}
