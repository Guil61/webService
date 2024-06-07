package com.placeTi.webService.veiculos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculosFacade {
    @Autowired
    private VeiculosRepository repository;

    public VeiculosDto criar(VeiculosDto veiculosDto){
        Veiculos veiculos = new Veiculos();
        veiculos.setContrato(veiculosDto.getContrato());
        veiculos.setNumeroChassi(veiculosDto.getNumeroChassi());
        veiculos.setPlaca(veiculosDto.getPlaca());
        veiculos.setNumeroGravame(veiculosDto.getNumeroGravame());
        veiculos.setNumeroRenavam(veiculosDto.getNumeroRenavam());
        repository.save(veiculos);
        veiculosDto.setId(veiculos.getId());
        return veiculosDto;
    }

    public VeiculosDto atualizar(VeiculosDto veiculosDto, Long veiculosId){
            Veiculos veiculosDataBase = repository.getOne(veiculosId);
            veiculosDataBase.setContrato(veiculosDto.getContrato());
            veiculosDataBase.setNumeroChassi(veiculosDto.getNumeroChassi());
            veiculosDataBase.setPlaca(veiculosDto.getPlaca());
            veiculosDataBase.setNumeroGravame(veiculosDto.getNumeroGravame());
            veiculosDataBase.setNumeroRenavam(veiculosDto.getNumeroRenavam());
            return veiculosDto;
    }

    private VeiculosDto converter (Veiculos veiculos){
        VeiculosDto result = new VeiculosDto();
        result.setId(veiculos.getId());
        result.setContrato(veiculos.getContrato());
        result.setNumeroChassi(veiculos.getNumeroChassi());
        result.setPlaca(veiculos.getPlaca());
        result.setNumeroGravame(veiculos.getNumeroGravame());
        result.setNumeroRenavam(veiculos.getNumeroRenavam());
        return result;
    }

    public List<VeiculosDto> getall(){
        return repository
                .findAll()
                .stream()
                .map(this::converter).collect(Collectors.toList());
    }

    public String delete (Long veiculosId){
        repository.deleteById(veiculosId);
        return "DELETED";
    }

}
