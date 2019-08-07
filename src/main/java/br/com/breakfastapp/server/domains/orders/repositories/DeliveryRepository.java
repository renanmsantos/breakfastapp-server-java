package br.com.breakfastapp.server.domains.orders.repositories;

import br.com.breakfastapp.server.domains.orders.domains.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery,Integer> {

}
