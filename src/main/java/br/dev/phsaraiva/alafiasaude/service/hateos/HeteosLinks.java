package br.dev.phsaraiva.alafiasaude.service.hateos;

import br.dev.phsaraiva.alafiasaude.controllers.ConsultaController;
import br.dev.phsaraiva.alafiasaude.controllers.PacienteController;
import br.dev.phsaraiva.alafiasaude.controllers.ProntuarioController;
import br.dev.phsaraiva.alafiasaude.data.dto.ConsultaDTO;
import br.dev.phsaraiva.alafiasaude.data.dto.PacienteDTO;
import br.dev.phsaraiva.alafiasaude.data.dto.ProntuarioDTO;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class HeteosLinks {

    public static PacienteDTO addHateosLinks(PacienteDTO dto) throws Exception {

        dto.add(linkTo(methodOn(PacienteController.class).getAllPacientes(1,12 , "asc")).withRel("findAll").withType("GET"));
        dto.add(linkTo(methodOn(PacienteController.class).getPacienteById(dto.getId())).withRel("findById").withType("GET"));
        dto.add(linkTo(methodOn(PacienteController.class).updatePaciente(dto.getId(), dto)).withRel("update").withType("PUT"));
        dto.add(linkTo(methodOn(ProntuarioController.class).getProntuario(dto.getProntuario().getId())).withRel("findProntuario").withType("GET"));
        dto.add(linkTo(methodOn(ProntuarioController.class).getAllConsultas(dto.getId(), 1,12,"asc")).withRel("findAll").withType("GET"));
        dto.add(linkTo(methodOn(ConsultaController.class).addConsulta(new ConsultaDTO(), dto.getProntuario().getId())).withRel("addConsulta").withType("POST"));

        return dto;

    }

    public static ProntuarioDTO addHateosLinks(ProntuarioDTO dto) throws Exception {

        dto.add(linkTo(methodOn(ProntuarioController.class).getProntuario(dto.getId())).withRel("getProntuario").withType("GET"));


        return dto;

    }

    public static ConsultaDTO addHateosLinks(ConsultaDTO dto) throws Exception {

        return dto;

    }
}
