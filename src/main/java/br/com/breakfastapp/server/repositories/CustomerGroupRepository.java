package br.com.breakfastapp.server.repositories;

import br.com.breakfastapp.server.domains.users.customer.CustomerGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerGroupRepository extends JpaRepository<CustomerGroup,Integer> {

    @Query("select cg from CustomerGroup cg where cg.active = true")
    List<CustomerGroup> findAll();

    @Query("select cg from CustomerGroup cg where cg.id = :id and cg.active = true ")
    CustomerGroup findOneById(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("update CustomerGroup cg set cg.active = false where cg.id = :id")
    void deleteById(@Param("id") Integer id);


}
