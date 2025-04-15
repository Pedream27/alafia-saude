package br.dev.phsaraiva.alafiasaude.controllers.docs;

import br.dev.phsaraiva.alafiasaude.data.dto.PacienteDTO;
import br.dev.phsaraiva.alafiasaude.data.dto.ProntuarioDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface PacienteControllerDocs {

    @Operation (summary = "Buscar Paciente", description = "Pega todos os pacientes do banco de dados e o tranforma em uma lista paginada  " , tags = {"Paciente"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = {@Content(schema = @Schema(implementation = PacienteDTO.class))}),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Erro", responseCode = "500", content = @Content)
            })
    ResponseEntity<PagedModel<EntityModel<PacienteDTO>>> getAllPacientes(@RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "12") Integer size, @RequestParam(value = "direction", defaultValue = "asc") String direction) throws Exception ;

    @Operation (summary = "Buscar Paciente", description = "Busca Paciente pelo ID  " , tags = {"Paciente"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = {@Content(schema = @Schema(implementation = PacienteDTO.class))}),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Erro", responseCode = "500", content = @Content)
            })
    ResponseEntity<EntityModel<PacienteDTO>> getPacienteById(@PathVariable("id") Long id) throws Exception;

    @Operation (summary = "Adiciona Paciente", description = "Cria um novo Paciente no banco de dados  " , tags = {"Paciente"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = {@Content(schema = @Schema(implementation = PacienteDTO.class))}),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Erro", responseCode = "500", content = @Content)
            })
    ResponseEntity<PacienteDTO> createPaciente(@RequestBody PacienteDTO pacienteDTO) throws Exception;

    @Operation (summary = "Atualiza Paciente", description = "Atualiza informaçoes do Paciente   " , tags = {"Paciente"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = {@Content(schema = @Schema(implementation = PacienteDTO.class))}),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Erro", responseCode = "500", content = @Content)
            })
    ResponseEntity<PacienteDTO> updatePaciente(@PathVariable("id") Long id , @RequestBody PacienteDTO paciente) throws Exception;

    @Operation (summary = "Deleta Paciente", description = "Deleta o paciente pelo ID " , tags = {"Paciente"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = {@Content(schema = @Schema(implementation = PacienteDTO.class))}),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Erro", responseCode = "500", content = @Content)
            })
    ResponseEntity deletePaciente(@PathVariable("id") Long id) throws Exception;

    @Operation (summary = "Busca o prontuario do  paciente", description = "Pelo ID no paciente ele retorna um prontuario" , tags = {"Paciente"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = {@Content(schema = @Schema(implementation = PacienteDTO.class))}),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Erro", responseCode = "500", content = @Content)
            })
    public ResponseEntity<ProntuarioDTO> getProntuario(@PathVariable("id") Long id) throws Exception;

}

