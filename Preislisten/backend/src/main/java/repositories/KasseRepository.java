package repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import entities.Kasse;
import org.springframework.stereotype.Repository;

@Repository
public interface KasseRepository extends JpaRepository<Kasse, Long> {


}