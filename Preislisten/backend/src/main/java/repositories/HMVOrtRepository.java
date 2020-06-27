package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.HMVOrt;

@Repository
public interface HMVOrtRepository extends JpaRepository<HMVOrt, Long> {

	HMVOrt findByOrt(long ort);
}