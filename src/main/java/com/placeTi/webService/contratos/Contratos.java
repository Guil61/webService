package com.placeTi.webService.contratos;


import com.placeTi.webService.veiculos.Veiculos;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table
public class Contratos {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    @Id
    private Long id;
    private String nomeDevedor;
    private LocalDate dataNascimentoDevedor;
    private String numeroRegistroEletronico;

    @OneToMany(mappedBy = "contrato")
    private List<Veiculos> veiculos;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDevedor() {
        return nomeDevedor;
    }

    public void setNomeDevedor(String nomeDevedor) {
        this.nomeDevedor = nomeDevedor;
    }

    public LocalDate getDataNascimentoDevedor() {
        return dataNascimentoDevedor;
    }

    public void setDataNascimentoDevedor(LocalDate dataNascimentoDevedor) {
        this.dataNascimentoDevedor = dataNascimentoDevedor;
    }

    public String getNumeroRegistroEletronico() {
        return numeroRegistroEletronico;
    }

    public void setNumeroRegistroEletronico(String numeroRegistroEletronico) {
        this.numeroRegistroEletronico = numeroRegistroEletronico;
    }

    public List<Veiculos> getVeiculo() {
        return veiculos;
    }

    public void setVeiculo(List<Veiculos> veiculo) {
        this.veiculos = veiculo;
    }
}
