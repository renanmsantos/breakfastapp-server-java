package br.com.breakfastapp.server.repositories;

import br.com.breakfastapp.server.domains.users.customer.Customer;
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

    @Query("select c from Customer c where c.id = :customerId and c.active = true ")
    Customer findCustomerById(@Param("customerId") Integer customerId);

    @Transactional
    @Modifying
    @Query("update Customer c set c.active = false where c.id = :customerId")
    void deleteCustomerById(@Param("customerId") Integer customerId);

}
