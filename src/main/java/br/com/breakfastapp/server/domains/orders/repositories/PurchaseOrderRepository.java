package br.com.breakfastapp.server.domains.orders.repositories;

import br.com.breakfastapp.server.domains.orders.domains.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder,Integer> {

    @Query("select p from PurchaseOrder p where p.id = :purchaseOrderId")
    PurchaseOrder findOneById(@Param("purchaseOrderId") Integer purchaseOrderId);

    @Query("select p from PurchaseOrder p where p.customer.id = :customerId order by p.id desc")
    List<PurchaseOrder> findAllByCustomerId(Integer customerId);
}
