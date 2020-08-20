package br.com.xpto.systems.xptosystems.repository;

import br.com.xpto.systems.xptosystems.model.Cidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchivesRepository extends JpaRepository<Cidades, String> {
}
