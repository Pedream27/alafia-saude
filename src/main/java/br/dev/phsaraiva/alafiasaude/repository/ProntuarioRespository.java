package br.dev.phsaraiva.alafiasaude.repository;

import br.dev.phsaraiva.alafiasaude.data.dto.ProntuarioDTO;
import br.dev.phsaraiva.alafiasaude.model.Paciente;
import br.dev.phsaraiva.alafiasaude.model.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProntuarioRespository extends JpaRepository<Prontuario, Long> {
    Prontuario findByPaciente(Paciente paciente);

    ProntuarioDTO findByPacienteId(Long id);
}
