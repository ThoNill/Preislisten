package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.HMVArt;

@Repository
public interface HMVArtRepository extends JpaRepository<HMVArt, Long> {

	HMVArt findByGruppeAndUntergruppeAndArtAndOrt(long gruppe,long untergruppe,long art,long ort);
}