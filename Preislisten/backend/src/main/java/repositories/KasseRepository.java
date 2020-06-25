package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entities.Kasse;
import tho.nill.preislisten.simpleAttributes.IK;

@Repository
public interface KasseRepository extends JpaRepository<Kasse, Long> {
	
	@Query("select k from entities.Kasse k where k.ik = :ik  ")
	public List<Kasse> getKassenZurIK(@Param("ik") IK ik);


}