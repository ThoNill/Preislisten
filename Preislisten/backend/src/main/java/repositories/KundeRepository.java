package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Kunde;
import interfaces.IKundeRepository;

@Repository
public interface KundeRepository extends JpaRepository<Kunde, Long>,
        IKundeRepository {


}