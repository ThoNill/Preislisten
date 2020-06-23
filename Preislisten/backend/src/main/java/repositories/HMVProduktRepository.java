package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.HMVProdukt;

@Repository
public interface HMVProduktRepository extends JpaRepository<HMVProdukt, Long> {


}