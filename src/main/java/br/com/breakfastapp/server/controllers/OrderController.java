package br.com.breakfastapp.server.controllers;

import br.com.breakfastapp.server.domains.orders.PurchaseOrder;
import br.com.breakfastapp.server.domains.orders.services.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @PostMapping
    public ResponseEntity<PurchaseOrder> createPurchaseOrder(@RequestBody @Valid PurchaseOrder purchaseOrder ){
        return purchaseOrderService.createPurchaseOrder(purchaseOrder);
    }

    @GetMapping
    public ResponseEntity<List<PurchaseOrder>> getAllPurchaseOrders(){
        return purchaseOrderService.findAllPurchaseOrders();
    }

    @GetMapping(value = "/customers/{customerId}")
    public ResponseEntity<PurchaseOrder> getOneProductById(@PathVariable(name = "customerId") Integer customerId ){
        return purchaseOrderService.findOnePurchaseOrderByCustomerId(customerId);
    }

}
