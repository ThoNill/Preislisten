package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Gruppe;
import interfaces.IGruppeRepository;

@Repository
public interface GruppeRepository extends JpaRepository<Gruppe, Long>,
        IGruppeRepository {


}