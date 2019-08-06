package br.com.breakfastapp.server.domains.orders.services;

import br.com.breakfastapp.server.domains.orders.PurchaseOrder;
import br.com.breakfastapp.server.domains.orders.repositories.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    public ResponseEntity<PurchaseOrder> createPurchaseOrder(PurchaseOrder purchaseOrder) {
        PurchaseOrder created = purchaseOrderRepository.save(purchaseOrder);
        return new ResponseEntity(created, HttpStatus.CREATED);
    }

    public ResponseEntity<List<PurchaseOrder>> findAllPurchaseOrders(){
        List<PurchaseOrder> returnedList = purchaseOrderRepository.findAll();
        return new ResponseEntity<>(returnedList, HttpStatus.OK);
    }

    public ResponseEntity<PurchaseOrder> findOnePurchaseOrderByCustomerId(Integer customerId) {
        PurchaseOrder found = purchaseOrderRepository.findOneByCustomerId(customerId);
        return new ResponseEntity<>(found,HttpStatus.OK);
    }



}
