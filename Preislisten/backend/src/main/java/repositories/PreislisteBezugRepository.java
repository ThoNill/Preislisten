package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.PreislisteBezug;

@Repository
public interface PreislisteBezugRepository extends JpaRepository<PreislisteBezug, Long> {


}