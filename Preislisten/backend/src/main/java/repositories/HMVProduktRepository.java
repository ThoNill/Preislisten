package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.HMVProdukt;
import interfaces.IHMVProduktRepository;

@Repository
public interface HMVProduktRepository extends JpaRepository<HMVProdukt, Long>,
        IHMVProduktRepository {


}