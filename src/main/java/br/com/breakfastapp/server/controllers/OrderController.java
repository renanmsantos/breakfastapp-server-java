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

    @GetMapping(value = "/customers/{customerId}")
    public ResponseEntity<PurchaseOrder> getOnePurchaseOrderByCustomerId(@PathVariable(name = "customerId") Integer customerId ){
        return purchaseOrderService.findOnePurchaseOrderByCustomerId(customerId);
    }

    @PostMapping(value = "/{purchaseOrderId}/products")
    public ResponseEntity<PurchaseOrderProduct> createPurchaseOrderProduct(@PathVariable(name = "purchaseOrderId") Integer purchaseOrderId ,
                                                                           @RequestBody List<PurchaseOrderProductPojo> listPurchaseOrderProductPojo ){
        return purchaseOrderService.createPurchaseOrderProduct(listPurchaseOrderProductPojo, purchaseOrderId);
    }

    @GetMapping(value = "/{purchaseOrderId}/products")
    public ResponseEntity<List<PurchaseOrderProduct>> getAllPurchaseOrderProductByPruchaseOrderId(@PathVariable(name = "purchaseOrderId") Integer purchaseOrderId ){
        return purchaseOrderService.findAllPurchaseOrderProductByPurchaseOrderId(purchaseOrderId);
    }

}
