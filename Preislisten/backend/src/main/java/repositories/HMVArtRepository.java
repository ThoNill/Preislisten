package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.HMVArt;
import interfaces.IHMVArtRepository;

@Repository
public interface HMVArtRepository extends JpaRepository<HMVArt, Long>,
        IHMVArtRepository {


}