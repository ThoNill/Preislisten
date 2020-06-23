package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.PreislistePosition;

@Repository
public interface PreislistePositionRepository extends JpaRepository<PreislistePosition, Long> {


}