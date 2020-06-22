package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.HMVGruppe;
import interfaces.IHMVGruppeRepository;

@Repository
public interface HMVGruppeRepository extends JpaRepository<HMVGruppe, Long>,
        IHMVGruppeRepository {


}