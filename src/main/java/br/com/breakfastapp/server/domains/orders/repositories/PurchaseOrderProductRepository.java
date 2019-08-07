package br.com.breakfastapp.server.domains.orders.repositories;

import br.com.breakfastapp.server.domains.orders.domains.PurchaseOrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseOrderProductRepository extends JpaRepository<PurchaseOrderProduct,Integer> {

    @Query(value = "select po from PurchaseOrderProduct po where po.purchaseOrder.id = :purchaseOrderId")
    List<PurchaseOrderProduct> findAllByPurchaseOrderId(@Param("purchaseOrderId") Integer purchaseOrderId);
}
