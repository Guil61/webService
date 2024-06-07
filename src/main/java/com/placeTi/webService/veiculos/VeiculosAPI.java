package com.placeTi.webService.veiculos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/veiculos", produces = MediaType.APPLICATION_JSON_VALUE)
public class VeiculosAPI {
    @Autowired
    private VeiculosFacade veiculosFacade;

    @PostMapping
    @ResponseBody
    public VeiculosDto criar(@RequestBody VeiculosDto veiculosDto){
        return veiculosFacade.criar(veiculosDto);
    }

    @PutMapping("/{veiculosId}")
    @ResponseBody
    public  VeiculosDto atualizar(@PathVariable("veiculosId") Long veiculosId,
                                  @RequestBody VeiculosDto veiculosDto) {
        return veiculosFacade.atualizar(veiculosDto, veiculosId);
    }

    @GetMapping
    @ResponseBody
    public List<VeiculosDto> getAll(){
        return veiculosFacade.getall();
    }

    @DeleteMapping("/{veiculosId}")
    @ResponseBody
    public String deletar(@PathVariable("veiculosId") Long veiculosId){
        return veiculosFacade.delete(veiculosId);
    }


}
