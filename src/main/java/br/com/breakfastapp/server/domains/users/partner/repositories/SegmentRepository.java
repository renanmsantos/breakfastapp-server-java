package br.com.breakfastapp.server.domains.users.partner.repositories;

import br.com.breakfastapp.server.domains.users.partner.domains.Segment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SegmentRepository extends JpaRepository<Segment,Integer> {

    @Query("select s from Segment s where s.active = true ")
    List<Segment> findAll();

    @Query("select s from Segment s where s.id = :id and s.active = true ")
    Segment findOneById(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("update Segment s set s.active = false where s.id = :id")
    void deleteById(@Param("id") Integer id);

}
