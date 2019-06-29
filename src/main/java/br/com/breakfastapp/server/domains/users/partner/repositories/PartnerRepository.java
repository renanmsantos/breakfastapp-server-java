package br.com.breakfastapp.server.domains.users.partner.repositories;

import br.com.breakfastapp.server.domains.users.partner.domains.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PartnerRepository extends JpaRepository<Partner,Integer> {

    @Query("select p from Partner p where p.active = true ")
    List<Partner> findAll();

    @Query("select p from Partner p where p.id = :id and p.active = true ")
    Partner findOneById(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("update Partner c set c.active = false where c.id = :id")
    void deleteById(@Param("id") Integer id);

}
