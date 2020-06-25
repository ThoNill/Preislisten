package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entities.VersandZiel;
import tho.nill.preislisten.simpleAttributes.IK;

@Repository
public interface VersandZielRepository extends JpaRepository<VersandZiel, Long> {

	@Query("select z from entities.VersandZiel z where z.von_ik = :ik  ")
	public List<VersandZiel> getVersandZieleZurIK(@Param("ik") IK ik);

}