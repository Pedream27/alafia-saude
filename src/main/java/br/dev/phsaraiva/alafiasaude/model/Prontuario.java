package br.dev.phsaraiva.alafiasaude.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Prontuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String observacoesGeerais;
    @OneToOne
    @JoinColumn(name = "paciente_id" , nullable = false)
    @JsonIgnore
    private Paciente paciente;

    @OneToMany(mappedBy = "prontuario", cascade = CascadeType.ALL)
    private List<Consulta> consultaList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getObservacoesGeerais() {
        return observacoesGeerais;
    }

    public void setObservacoesGeerais(String observacoesGeerais) {
        this.observacoesGeerais = observacoesGeerais;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Consulta> getConsultasList() {
        return consultaList;
    }

    public void setConsultasList(List<Consulta> consultaList) {
        this.consultaList = consultaList;
    }
}
