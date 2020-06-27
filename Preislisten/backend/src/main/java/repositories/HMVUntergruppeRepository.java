package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.HMVUntergruppe;

@Repository
public interface HMVUntergruppeRepository extends JpaRepository<HMVUntergruppe, Long> {

	HMVUntergruppe findByGruppeAndUntergruppeAndOrt(long gruppe,long unterGruppe,long ort);
}