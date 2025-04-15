package br.dev.phsaraiva.alafiasaude.controllers;

import br.dev.phsaraiva.alafiasaude.controllers.docs.PacienteControllerDocs;
import br.dev.phsaraiva.alafiasaude.data.dto.PacienteDTO;

import br.dev.phsaraiva.alafiasaude.data.dto.ProntuarioDTO;
import br.dev.phsaraiva.alafiasaude.service.PacienteServices;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/paciente")
public class PacienteController  implements PacienteControllerDocs {

    private final PacienteServices service;

    public PacienteController(PacienteServices service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<PacienteDTO>>> getAllPacientes(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "12") Integer size,
            @RequestParam(value = "direction", defaultValue = "asc") String direction
    ) throws Exception {

        Sort.Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;

        var pageable = PageRequest.of(page, size, Sort.by(sortDirection, "nome"));
        var response = service.getAllPaciente(pageable);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<PacienteDTO>> getPacienteById(@PathVariable("id") Long id) throws Exception {
            var response = service.findById(id);
            return ResponseEntity.ok().body(EntityModel.of(response));
    }
    @PostMapping
    public ResponseEntity<PacienteDTO> createPaciente(@RequestBody PacienteDTO pacienteDTO) throws Exception {
        var response = service.create(pacienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteDTO> updatePaciente(@PathVariable("id") Long id , @RequestBody PacienteDTO paciente) throws Exception {
        var response = service.updatePaciente(id , paciente);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePaciente(@PathVariable("id") Long id) throws Exception {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

//GET /pacientes/{id}/prontuario – buscar prontuário de um paciente
@GetMapping("/{id}/prontuario")
    public ResponseEntity<ProntuarioDTO> getProntuario(@PathVariable("id") Long id) throws Exception {
        var response =  service.findByProntuarioId(id);
        return  ResponseEntity.ok().body(response);
}
}