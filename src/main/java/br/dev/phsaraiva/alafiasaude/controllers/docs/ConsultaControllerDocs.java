package br.dev.phsaraiva.alafiasaude.controllers.docs;

import br.dev.phsaraiva.alafiasaude.data.dto.ConsultaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ConsultaControllerDocs {

    @Operation (summary = "Criar Consulta", description = "Cria uma nova consulta " , tags = {"Consulta"},
    responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = {@Content(schema = @Schema(implementation = ConsultaDTO.class))}),
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Erro", responseCode = "500", content = @Content)
    })
    ResponseEntity<ConsultaDTO> addConsulta(@RequestBody br.dev.phsaraiva.alafiasaude.data.dto.ConsultaDTO dto, @PathVariable("id") Long id) throws Exception;

    @Operation (summary = "Deleta Consulta", description = "Deleta uma consulta a partir do ID  " , tags = {"Consulta"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = {@Content(schema = @Schema(implementation = ConsultaDTO.class))}),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Erro", responseCode = "500", content = @Content)
            })
     ResponseEntity deleteConsulta(@PathVariable("id") Long id) throws Exception;

}
