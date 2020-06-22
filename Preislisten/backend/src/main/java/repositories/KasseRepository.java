package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Kasse;
import interfaces.IKasseRepository;

@Repository
public interface KasseRepository extends JpaRepository<Kasse, Long>,
        IKasseRepository {


}