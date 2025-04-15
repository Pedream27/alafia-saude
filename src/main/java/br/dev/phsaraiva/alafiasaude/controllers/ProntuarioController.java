package br.dev.phsaraiva.alafiasaude.controllers;

import br.dev.phsaraiva.alafiasaude.data.dto.ConsultaDTO;
import br.dev.phsaraiva.alafiasaude.data.dto.ProntuarioDTO;
import br.dev.phsaraiva.alafiasaude.service.ProntuarioServices;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/prontuario")
public class ProntuarioController {

    private final ProntuarioServices prontuarioServices;

    public ProntuarioController(ProntuarioServices prontuarioServices) {
        this.prontuarioServices = prontuarioServices;
    }
//GET /prontuarios/{id} – buscar prontuário
//PUT /prontuarios/{id} – atualizar prontuário

    @GetMapping("/{id}")
    public ResponseEntity<ProntuarioDTO> getProntuario(@PathVariable("id") Long id) throws Exception {
        var response = prontuarioServices.findByid(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProntuarioDTO> updateProntuario(@PathVariable("id") Long id, @RequestBody String observacoesGerais) throws Exception {
        var reponse = prontuarioServices.updateProntuario(id , observacoesGerais);
        return ResponseEntity.ok(reponse);
    }

    //GET /prontuarios/{id}/consultas – listar consultas de um prontuário
    //
    //POST /prontuarios/{id}/consultas

    @GetMapping("{id}/consultas")
    public ResponseEntity<ConsultaDTO> getAllConsultas(
            @PathVariable("id") Long id,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "12") Integer size,
            @RequestParam(value = "direction", defaultValue = "asc") String direction) throws Exception {

        Sort.Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;
        var pageable = PageRequest.of(page, size, Sort.by(sortDirection, "title"));
        var response = prontuarioServices.getAllConsultas(id , pageable);
        return ResponseEntity.ok().body(response);

    }

}
