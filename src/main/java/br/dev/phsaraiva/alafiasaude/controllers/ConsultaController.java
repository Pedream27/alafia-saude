package br.dev.phsaraiva.alafiasaude.controllers;

import br.dev.phsaraiva.alafiasaude.data.dto.ConsultaDTO;
import br.dev.phsaraiva.alafiasaude.service.ConsultaServices;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/consulta")
public class ConsultaController {

    private final ConsultaServices consultaServices;
    public ConsultaController(ConsultaServices consultaServices) {
        this.consultaServices = consultaServices;
    }

@PostMapping("/{id}")
    public ResponseEntity<ConsultaDTO> addConsulta(@RequestBody ConsultaDTO dto, @PathVariable("id") Long id) throws Exception {

        var response = consultaServices.create(dto , id);
        return ResponseEntity.ok(response);

}


}
