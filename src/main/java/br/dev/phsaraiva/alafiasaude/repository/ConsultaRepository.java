package br.dev.phsaraiva.alafiasaude.repository;

import br.dev.phsaraiva.alafiasaude.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
