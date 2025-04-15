package br.dev.phsaraiva.alafiasaude.service;

import br.dev.phsaraiva.alafiasaude.controllers.PacienteController;
import br.dev.phsaraiva.alafiasaude.data.dto.PacienteDTO;
import br.dev.phsaraiva.alafiasaude.data.dto.ProntuarioDTO;
import br.dev.phsaraiva.alafiasaude.model.Paciente;
import br.dev.phsaraiva.alafiasaude.repository.PacienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;
import static br.dev.phsaraiva.alafiasaude.mapper.ObjectMapper.parseObject;
import static br.dev.phsaraiva.alafiasaude.service.hateos.HeteosLinks.addHateosLinks;

@Service
public class PacienteServices {

    private final ProntuarioServices prontuarioServices;
    private final PacienteRepository repository;
    private  final PagedResourcesAssembler<PacienteDTO> assembler;
    private final Logger log = LoggerFactory.getLogger(PacienteController.class);


    public PacienteServices(ProntuarioServices prontuarioServices, PacienteRepository pacienteRepository, PagedResourcesAssembler<PacienteDTO> assembler) {
        this.prontuarioServices = prontuarioServices;
        this.repository = pacienteRepository;

        this.assembler = assembler;
    }

    public PagedModel<EntityModel<PacienteDTO>> getAllPaciente(PageRequest pageable) throws Exception {
        log.info("Paciente Service getAllPaciente");
        var pacienteList = repository.findAll(pageable);

        var pacienteWithLinks  = pacienteList.map( paciente -> {

            var pacienteDTO = parseObject(paciente, PacienteDTO.class);
            try {
                addHateosLinks(pacienteDTO);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return pacienteDTO;
        });

        Link findAll = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(PacienteController.class)
                        .getAllPacientes(
                                pageable.getPageNumber(),
                                pageable.getPageSize() ,
                                String.valueOf(pageable.getSort()))).withSelfRel();

        return assembler.toModel(pacienteWithLinks, findAll);
    }

    public PacienteDTO findById(Long id) throws Exception {
        log.info("Paciente Service findById");
        var isPaciente = repository.findById(id).orElseThrow(() -> new Exception("Paciente não encontrado "));
        var dto = parseObject(isPaciente, PacienteDTO.class);
        return addHateosLinks(dto);
    }

    public PacienteDTO create(PacienteDTO pacienteDTO) throws Exception {
    log.info("Create Paciente DTO");
      var paciente =  parseObject(pacienteDTO, Paciente.class);
      var pacienteSaved = repository.save(paciente);
      var prontuario = prontuarioServices.create(paciente) ;
        pacienteSaved.setProntuario(prontuario);
      var response = parseObject(repository.save(pacienteSaved), PacienteDTO.class);
      return addHateosLinks(response);
    }

    public PacienteDTO updatePaciente(Long id, PacienteDTO paciente) throws Exception {
        log.info("Service updatePaciente");
        var isPaciente = repository.findById(id).orElseThrow(() -> new RuntimeException("Paciente para Atualização não encontrado"));
            isPaciente.setNome(paciente.getNome());
            isPaciente.setEmail(paciente.getEmail());
            isPaciente.setTelefone(paciente.getTelefone());
        var newPaciente = repository.save(isPaciente);
        var dto = parseObject(newPaciente, PacienteDTO.class);
        return addHateosLinks(dto);

    }

    public void deleteById(Long id) throws Exception {
        repository.findById(id).orElseThrow(() -> new Exception("Não foi possivel excluir : Paciente não encontrado"));
        repository.deleteById(id);
    }

    public ProntuarioDTO findByProntuarioId(Long id) throws Exception {

      var isPaciente =  repository.findById(id).orElseThrow(() -> new Exception( "Paciente não encontrado "));
      prontuarioServices.findProntuarioByPaciente(isPaciente) ;

    return null;
    }
}
