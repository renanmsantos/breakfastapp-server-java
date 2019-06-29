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

    @Query("select c from CustomerGroup c where c.active = true ")
    List<CustomerGroup> findAll();

    @Query("select c from CustomerGroup c where c.id = :customerGroupId and c.active = true ")
    CustomerGroup findCustomerGroupById(@Param("customerGroupId") Integer customerGroupId);

    @Transactional
    @Modifying
    @Query("update CustomerGroup c set c.active = false where c.id = :customerGroupId")
    void deleteCustomerGroupById(@Param("customerGroupId") Integer customerGroupId);


}
