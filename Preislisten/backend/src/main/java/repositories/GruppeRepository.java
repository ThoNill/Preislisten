package repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import entities.Gruppe;
import org.springframework.stereotype.Repository;

@Repository
public interface GruppeRepository extends JpaRepository<Gruppe, Long> {


}