// java/com/projeto/resources/CarrosResource.java
package com.projeto.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.domain.Carro;
import com.projeto.repository.CarrosRepository;

@RestController
@RequestMapping(value = "/carros")
public class CarrosResource {
    
    @Autowired
    private CarrosRepository carrosRepository;

    @RequestMapping(method = RequestMethod.POST)
    public void salvar(@RequestBody Carro carro) {
        carrosRepository.save(carro);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Carro> listar() {
        return carrosRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Carro buscaId(@PathVariable("id") Long id) {
        return carrosRepository.findById(id).orElse(null);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable("id") Long id) {
        carrosRepository.deleteById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void atualizar(@RequestBody Carro carro, @PathVariable("id") Long id) {
        carro.setId(id);
        carrosRepository.save(carro);
    }
}