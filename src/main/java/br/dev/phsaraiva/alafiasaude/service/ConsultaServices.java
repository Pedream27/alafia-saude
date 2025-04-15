package br.dev.phsaraiva.alafiasaude.service;

import br.dev.phsaraiva.alafiasaude.data.dto.ConsultaDTO;
import br.dev.phsaraiva.alafiasaude.model.Consulta;
import br.dev.phsaraiva.alafiasaude.repository.ConsultaRepository;
import br.dev.phsaraiva.alafiasaude.repository.ProntuarioRespository;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDate;

import static br.dev.phsaraiva.alafiasaude.mapper.ObjectMapper.parseObject;
import static br.dev.phsaraiva.alafiasaude.service.hateos.HeteosLinks.addHateosLinks;

@Service
public class ConsultaServices {

    private final ConsultaRepository consultaRepository;
    private final ProntuarioRespository prontuarioRespository;
    public ConsultaServices(ConsultaRepository consultaRepository, ProntuarioRespository prontuarioRespository) {
        this.consultaRepository = consultaRepository;
        this.prontuarioRespository = prontuarioRespository;
    }


    public ConsultaDTO create(ConsultaDTO dto, Long id) throws Exception {
     var isProntuario = prontuarioRespository.findById(id).orElseThrow(() -> new Exception("Erro ao encontrar Prontuario"));
        dto.setDataConsulta(LocalDate.now());

       var consulta = parseObject(dto , Consulta.class);
       consulta.setProntuario(isProntuario);
       var response =consultaRepository.save(consulta);
       isProntuario.getConsultasList().add(response);
       prontuarioRespository.save(isProntuario);
      var  newDto  = parseObject(response , ConsultaDTO.class);
      return addHateosLinks(newDto);
    }
}
