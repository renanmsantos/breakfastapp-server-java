package br.com.breakfastapp.server.controllers;

import br.com.breakfastapp.server.domains.orders.domains.PurchaseOrder;
import br.com.breakfastapp.server.domains.orders.domains.PurchaseOrderProduct;
import br.com.breakfastapp.server.domains.orders.pojos.PurchaseOrderPojo;
import br.com.breakfastapp.server.domains.orders.pojos.PurchaseOrderProductPojo;
import br.com.breakfastapp.server.domains.orders.services.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @PostMapping
    public ResponseEntity<PurchaseOrder> createPurchaseOrder(@RequestBody PurchaseOrderPojo purchaseOrder ){
        return purchaseOrderService.createPurchaseOrder(purchaseOrder);
    }

    @GetMapping
    public ResponseEntity<List<PurchaseOrder>> getAllPurchaseOrders(){
        return purchaseOrderService.findAllPurchaseOrders();
    }

}
