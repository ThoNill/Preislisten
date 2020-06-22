package repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import interfaces.IPreislisteBezugRepository;
import interfaces.IPreislisteBezug;
import entities.PreislisteBezug;
import org.springframework.stereotype.Repository;

@Repository
public interface PreislisteBezugRepository extends JpaRepository<PreislisteBezug, Long>,
        IPreislisteBezugRepository {


}