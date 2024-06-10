package com.placeTi.webService.contratos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContratosFacade {
    @Autowired
    private ContratosRepository repository;

    public ContratosDto criar(ContratosDto contratosDto){
        Contratos contratos = new Contratos();
        contratos.setVeiculo(contratosDto.getVeiculo());
        contratos.setNomeDevedor(contratosDto.getNomeDevedor());
        contratos.setDataNascimentoDevedor(contratosDto.getDataNascimentoDevedor());
        contratos.setNumeroRegistroEletronico(contratosDto.getNumeroRegistroEletronico());
        repository.save(contratos);
        contratosDto.setId(contratos.getId());
        return contratosDto;
    }

    public ContratosDto atualizar(ContratosDto contratosDto, Long contratosId){
        Contratos contratosDataBase =  repository.getOne(contratosId);
        contratosDataBase.setVeiculo(contratosDto.getVeiculo());
        contratosDataBase.setNomeDevedor(contratosDto.getNomeDevedor());
        contratosDataBase.setDataNascimentoDevedor(contratosDto.getDataNascimentoDevedor());
        contratosDataBase.setNumeroRegistroEletronico(contratosDto.getNumeroRegistroEletronico());
        repository.save(contratosDataBase);
        return contratosDto;
    }

    private ContratosDto converter(Contratos contratos){
        ContratosDto result = new ContratosDto();
        result.setId(contratos.getId());
        result.setVeiculo(contratos.getVeiculo());
        result.setNomeDevedor(contratos.getNomeDevedor());
        result.setDataNascimentoDevedor(contratos.getDataNascimentoDevedor());
        result.setNumeroRegistroEletronico(contratos.getNumeroRegistroEletronico());
        return result;
    }

    public List<ContratosDto> getall(){
        return repository
                .findAll()
                .stream()
                .map(this::converter)
                .collect(Collectors.toList());
    }

    public ContratosDto getById(Long contratosId){
        return toDto(repository.findById(contratosId).orElse(null));
    }

    public String delete(Long contratosId){
        repository.deleteById(contratosId);
        return "DELETED";
    }

    private ContratosDto toDto(Contratos contratos) {
        if (contratos == null) return null;
        ContratosDto contratosDto = new ContratosDto();
        contratosDto.setNumeroRegistroEletronico(contratos.getNumeroRegistroEletronico());
        contratosDto.setId(contratos.getId());
        contratosDto.setVeiculo(contratos.getVeiculo());
        contratosDto.setNomeDevedor(contratos.getNomeDevedor());
        return contratosDto;
    }
}
