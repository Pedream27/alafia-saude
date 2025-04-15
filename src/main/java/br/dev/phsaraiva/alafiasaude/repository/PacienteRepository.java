package br.dev.phsaraiva.alafiasaude.repository;

import br.dev.phsaraiva.alafiasaude.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
