package br.dev.phsaraiva.alafiasaude.data.dto;

import br.dev.phsaraiva.alafiasaude.model.Consulta;
import br.dev.phsaraiva.alafiasaude.model.Paciente;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;

public class ProntuarioDTO extends RepresentationModel<PacienteDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String observacoesGeerais;
    private Paciente paciente;
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
