package repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import interfaces.IHMVProduktRepository;
import interfaces.IHMVProdukt;
import entities.HMVProdukt;
import org.springframework.stereotype.Repository;

@Repository
public interface HMVProduktRepository extends JpaRepository<HMVProdukt, Long>,
        IHMVProduktRepository {


}