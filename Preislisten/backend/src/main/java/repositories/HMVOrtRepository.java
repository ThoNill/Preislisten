package repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import interfaces.IHMVOrtRepository;
import interfaces.IHMVOrt;
import entities.HMVOrt;
import org.springframework.stereotype.Repository;

@Repository
public interface HMVOrtRepository extends JpaRepository<HMVOrt, Long>,
        IHMVOrtRepository {


}