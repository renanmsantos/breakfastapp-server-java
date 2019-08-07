package br.com.breakfastapp.server.domains.orders.repositories;

import br.com.breakfastapp.server.domains.orders.domains.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder,Integer> {

    @Query("select p from PurchaseOrder p where p.customer.id = :customerId")
    PurchaseOrder findOneByCustomerId(@Param("customerId") Integer customerId);

    @Query("select p from PurchaseOrder p where p.id = :purchaseOrderId")
    PurchaseOrder findOneById(@Param("purchaseOrderId") Integer purchaseOrderId);


}
