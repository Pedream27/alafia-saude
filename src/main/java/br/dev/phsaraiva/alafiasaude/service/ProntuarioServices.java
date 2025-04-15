package br.dev.phsaraiva.alafiasaude.service;

import br.dev.phsaraiva.alafiasaude.data.dto.ConsultaDTO;
import br.dev.phsaraiva.alafiasaude.data.dto.ProntuarioDTO;
import br.dev.phsaraiva.alafiasaude.model.Consulta;
import br.dev.phsaraiva.alafiasaude.model.Paciente;
import br.dev.phsaraiva.alafiasaude.model.Prontuario;
import br.dev.phsaraiva.alafiasaude.repository.PacienteRepository;
import br.dev.phsaraiva.alafiasaude.repository.ProntuarioRespository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.expression.ExpressionException;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.dev.phsaraiva.alafiasaude.mapper.ObjectMapper.parseObject;
import static br.dev.phsaraiva.alafiasaude.service.hateos.HeteosLinks.addHateosLinks;

@Service
public class ProntuarioServices {

    private final ProntuarioRespository repository;
    private final PacienteRepository pacienteRepository;

    public ProntuarioServices(ProntuarioRespository repository,  PacienteRepository pacienteRepository) {
        this.repository = repository;
        this.pacienteRepository = pacienteRepository;

    }

    public Prontuario create(Paciente paciente ) {
        Prontuario prontuario = new Prontuario();
        prontuario.setPaciente(paciente);
        return prontuario;
    }

    public ProntuarioDTO findByid(Long id) throws Exception {
        var isProntuario = repository.findById(id).orElseThrow(() -> new Exception("Prontuario não encontrado"));
        var dto =  parseObject(isProntuario , ProntuarioDTO.class);
        return addHateosLinks(dto);
    }

    public ProntuarioDTO updateProntuario(Long id, String ObservacaoGerais) throws Exception {
            var isProntuario = repository.findById(id).orElseThrow(() -> new Exception("Prontuario não encontrado"));
            isProntuario.setObservacoesGeerais(ObservacaoGerais);
            var newProntuario = repository.save(isProntuario);
            var dto = parseObject(newProntuario , ProntuarioDTO.class);
            return addHateosLinks(dto);
    }


    public ProntuarioDTO findProntuarioByPaciente(Paciente  paciente) throws Exception {
        var  isProntuario = repository.findByPaciente(paciente);
        var dto = parseObject(isProntuario , ProntuarioDTO.class);
        return addHateosLinks(dto);
    }

    public ConsultaDTO getAllConsultas(Long id, PageRequest pageable) throws Exception {
            var isPaciente = pacienteRepository.findById(id).orElseThrow(() -> new ExpressionException("Paciente não encontrado"));
            var prontuario = isPaciente.getProntuario();
            var consultas = prontuario.getConsultasList();
            var dto = parseObject(consultas , ConsultaDTO.class);
            return addHateosLinks(dto);
    }


}


