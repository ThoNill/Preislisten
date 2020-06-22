package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Position;
import interfaces.IPositionRepository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long>,
        IPositionRepository {


}