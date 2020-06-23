package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.VersandZiel;

@Repository
public interface VersandZielRepository extends JpaRepository<VersandZiel, Long> {


}