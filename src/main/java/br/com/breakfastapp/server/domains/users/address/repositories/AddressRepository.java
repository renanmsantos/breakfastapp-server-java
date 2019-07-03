package br.com.breakfastapp.server.domains.users.address.repositories;

import br.com.breakfastapp.server.domains.users.address.domains.Address;
import br.com.breakfastapp.server.domains.users.customer.domains.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

    @Query("select a from Address a where c.active = true ")
    List<Address> findAll();

    @Transactional
    @Modifying
    @Query("update Address a set a.active = false where c.id = :id")
    void deleteById(@Param("id") Integer id);

    Address findOneByCep(String cep);

}

