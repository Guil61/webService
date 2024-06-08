package com.placeTi.webService.contratos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/contratos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ContratosAPI {
    @Autowired
    private ContratosFacade contratosFacade;

    @PostMapping
    @ResponseBody
    public ContratosDto criar(@RequestBody ContratosDto contratosDto){
        return contratosFacade.criar(contratosDto);
    }

    @PutMapping("/{contratosId}")
    @ResponseBody

    public ContratosDto atualizar(@PathVariable("contratosId") Long contratosId,
                                  @RequestBody ContratosDto contratosDto) {
        return contratosFacade.atualizar(contratosDto, contratosId);
    }

    @GetMapping("")
    @ResponseBody
    public List<ContratosDto> getall(){
        return contratosFacade.getall();

    }

    @GetMapping("/{contratosId}")
    @ResponseBody
    public ContratosDto getById(@PathVariable("contratosId") Long contratosId){
        return contratosFacade.getById(contratosId);
    }

    @DeleteMapping("/{contratosId}")
    @ResponseBody
    public  String deletar(@PathVariable("contratosId") Long contratosId){
        return contratosFacade.delete(contratosId);
    }
}
