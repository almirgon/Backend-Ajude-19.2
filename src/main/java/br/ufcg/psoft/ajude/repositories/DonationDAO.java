package br.ufcg.psoft.ajude.repositories;

import br.ufcg.psoft.ajude.models.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationDAO extends JpaRepository<Donation, Long> {


}
