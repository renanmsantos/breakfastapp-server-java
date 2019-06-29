package br.com.breakfastapp.server.repositories;

import br.com.breakfastapp.server.domains.users.customer.CustomerGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CustomerGroupRepository extends JpaRepository<CustomerGroup,Integer> {

    @Query("select cg from CustomerGroup cg where cg.active = true ")
    List<CustomerGroup> findAll();

    @Query("select cg from CustomerGroup cg where cg.id = :customerGroupId and cg.active = true ")
    CustomerGroup findCustomerGroupById(@Param("customerGroupId") Integer customerGroupId);

    @Transactional
    @Modifying
    @Query("update CustomerGroup cg set cg.active = false where cg.id = :customerGroupId")
    void deleteCustomerGroupById(@Param("customerGroupId") Integer customerGroupId);


}
