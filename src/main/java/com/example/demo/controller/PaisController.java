package com.example.demo.controller;
import com.example.demo.entity.Pais;
import com.example.demo.entity.Pessoa;
import com.example.demo.repository.PaisRepository;
import com.example.demo.repository.PessoaRepository;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PaisController {
    @Autowired
    private PaisRepository _paisRepository;

    @RequestMapping(value = "/pais", method = RequestMethod.GET)
    public List<Pais> Get() {
        return _paisRepository.findAll();
    }

    @RequestMapping(value = "/pais/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pais> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Pais> pais = _paisRepository.findById(id);
        if(pais.isPresent())
            return new ResponseEntity<Pais>(pais.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/pais", method =  RequestMethod.POST)
    public Pais Post(@Valid @RequestBody Pais pais)
    {
        return _paisRepository.save(pais);
    }

    @RequestMapping(value = "/pais/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Pais> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Pais newPais)
    {
        Optional<Pais> oldPais = _paisRepository.findById(id);
        if(oldPais.isPresent()){
            Pais pais = oldPais.get();
            pais.setNome(newPais.get());
            _paisRepository.save(pais);
            return new ResponseEntity<Pais>(pais, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/pais/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Pais> pais = _paisRepository.findById(id);
        if(pais.isPresent()){
            _paisRepository.delete(pais.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



@PutMapping("pais/")

}