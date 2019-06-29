package br.com.breakfastapp.server.domains.users.customer.repositories;

import br.com.breakfastapp.server.domains.users.customer.domains.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query("select c from Customer c where c.active = true ")
    List<Customer> findAll();

    @Query("select c from Customer c where c.id = :id and c.active = true ")
    Customer findOneById(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("update Customer c set c.active = false where c.id = :id")
    void deleteById(@Param("id") Integer id);

}
