package br.dev.phsaraiva.alafiasaude.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Consultas  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate dataConsulta;
    private String subjetivo;
    private String objetivo;
    private String avaliacao;
    private String plano;

    @ManyToOne
    @JoinColumn(name = "prontuario_id", nullable = false)
    private Prontuario prontuario;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getSubjetivo() {
        return subjetivo;
    }

    public void setSubjetivo(String subjetivo) {
        this.subjetivo = subjetivo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }
}
