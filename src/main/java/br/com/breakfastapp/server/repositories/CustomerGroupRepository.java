package br.com.breakfastapp.server.repositories;

import br.com.breakfastapp.server.domains.users.customer.CustomerGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerGroupRepository extends JpaRepository<CustomerGroup,Integer> { }
