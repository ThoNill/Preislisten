package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.PreislistePosition;
import interfaces.IPreislistePositionRepository;

@Repository
public interface PreislistePositionRepository extends JpaRepository<PreislistePosition, Long>,
        IPreislistePositionRepository {


}