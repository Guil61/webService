package com.placeTi.webService.veiculos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.placeTi.webService.contratos.Contratos;
import jakarta.persistence.*;

@Entity
@Table
public class Veiculos {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    @Id
    private Long id;
    private String numeroGravame;
    private String numeroRenavam;
    private String placa;
    private String numeroChassi;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "contrato_id")
    private Contratos contrato;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroGravame() {
        return numeroGravame;
    }

    public void setNumeroGravame(String numeroGravame) {
        this.numeroGravame = numeroGravame;
    }

    public String getNumeroRenavam() {
        return numeroRenavam;
    }

    public void setNumeroRenavam(String numeroRenavam) {
        this.numeroRenavam = numeroRenavam;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNumeroChassi() {
        return numeroChassi;
    }

    public void setNumeroChassi(String numeroChassi) {
        this.numeroChassi = numeroChassi;
    }

    public Contratos getContrato() {
        return contrato;
    }

    public void setContrato(Contratos contrato) {
        this.contrato = contrato;
    }

    public Veiculos(Long id, String numeroGravame, String numeroRenavam, String placa, String numeroChassi, Contratos contrato) {
        this.id = id;
        this.numeroGravame = numeroGravame;
        this.numeroRenavam = numeroRenavam;
        this.placa = placa;
        this.numeroChassi = numeroChassi;
        this.contrato = contrato;
    }

    public Veiculos() {
    }
}
