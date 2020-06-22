package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.PreislisteKopf;
import interfaces.IPreislisteKopfRepository;

@Repository
public interface PreislisteKopfRepository extends JpaRepository<PreislisteKopf, Long>,
        IPreislisteKopfRepository {


}