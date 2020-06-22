package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.HMVUntergruppe;
import interfaces.IHMVUntergruppeRepository;

@Repository
public interface HMVUntergruppeRepository extends JpaRepository<HMVUntergruppe, Long>,
        IHMVUntergruppeRepository {


}