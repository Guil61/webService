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
        Contratos  contratos = new Contratos();
        contratos.setVeiculo(contratosDto.getVeiculo());
        contratos.setNomeDevedor(contratosDto.getNomeDevedor());
        contratos.setDataNascimentoDevedor(contratosDto.getDataNascimentoDevedor());
        contratos.setNumeroRegistroEletronico(contratosDto.getNumeroRegistroEletronico());
        repository.save(contratos);
        contratosDto.setId(contratos.getId());
        return contratosDto;
    }

    public ContratosDto atualizar(ContratosDto  contratosDto, Long contratosId){
        Contratos contratosDataBase =  repository.getOne(contratosId);
        contratosDataBase.setVeiculo(contratosDto.getVeiculo());
        contratosDataBase.setNomeDevedor(contratosDto.getNomeDevedor());
        contratosDataBase.setDataNascimentoDevedor(contratosDto.getDataNascimentoDevedor());
        contratosDataBase.setNumeroRegistroEletronico(contratosDto.getNumeroRegistroEletronico());
        return contratosDto;
    }

    private ContratosDto converter (Contratos contratos){
        ContratosDto result = new ContratosDto();
        result.setId(contratos.getId());
        result.setVeiculo(contratos.getVeiculo());
        result.setNomeDevedor(contratos.getNomeDevedor());
        result.setDataNascimentoDevedor(contratos.getDataNascimentoDevedor());
        result.setNumeroRegistroEletronic(contratos.getNumeroRegistroEletronico());
        return result;
    }


    public List<ContratosDto>  getall(){
        return repository
                .findAll()
                .stream()
                .map(this::converter).collect(Collectors.toList());
    }

    public String delete(Long contratosId){
        repository.deleteById(contratosId);
        return "DELETED";
    }


}
