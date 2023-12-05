// java/com/projeto/resources/PilotosResource.java
package com.projeto.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.domain.Piloto;
import com.projeto.repository.PilotosRepository;

@RestController
@RequestMapping(value = "/pilotos")
public class PilotosResource {

    @Autowired
    private PilotosRepository pilotosRepository;

    @RequestMapping(method = RequestMethod.POST)
    public void salvar(@RequestBody Piloto piloto) {
        pilotosRepository.save(piloto);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Piloto> listar() {
        return pilotosRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Piloto buscaId(@PathVariable("id") Long id) {
        return pilotosRepository.findById(id).orElse(null);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable("id") Long id) {
        pilotosRepository.deleteById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void atualizar(@RequestBody Piloto piloto, @PathVariable("id") Long id) {
        piloto.setId(id);
        pilotosRepository.save(piloto);
    }
}
