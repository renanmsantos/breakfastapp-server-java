package br.com.breakfastapp.server.domains.users.partner.repositories;

import br.com.breakfastapp.server.domains.users.partner.domains.SocialInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SocialInformationRepository extends JpaRepository<SocialInformation,Integer> {

    @Query("select si from SocialInformation si where si.active = true ")
    List<SocialInformation> findAll();

    @Query("select si from SocialInformation si where si.id = :id and si.active = true ")
    SocialInformation findOneById(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("update SocialInformation si set si.active = false where si.id = :id")
    void deleteById(@Param("id") Integer id);

}
