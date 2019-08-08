package br.com.breakfastapp.server.domains.orders.services;

import br.com.breakfastapp.server.domains.orders.domains.Delivery;
import br.com.breakfastapp.server.domains.orders.domains.PurchaseOrder;
import br.com.breakfastapp.server.domains.orders.domains.PurchaseOrderProduct;
import br.com.breakfastapp.server.domains.orders.enuns.DeliveryStatus;
import br.com.breakfastapp.server.domains.orders.enuns.PurchaseOrderStatus;
import br.com.breakfastapp.server.domains.orders.pojos.PurchaseOrderPojo;
import br.com.breakfastapp.server.domains.orders.pojos.PurchaseOrderProductPojo;
import br.com.breakfastapp.server.domains.orders.repositories.DeliveryRepository;
import br.com.breakfastapp.server.domains.orders.repositories.PurchaseOrderProductRepository;
import br.com.breakfastapp.server.domains.orders.repositories.PurchaseOrderRepository;
import br.com.breakfastapp.server.domains.products.domains.Product;
import br.com.breakfastapp.server.domains.products.repositories.ProductRepository;
import br.com.breakfastapp.server.domains.users.address.domains.Address;
import br.com.breakfastapp.server.domains.users.address.repositories.AddressRepository;
import br.com.breakfastapp.server.domains.users.customer.domains.Customer;
import br.com.breakfastapp.server.domains.users.customer.repositories.CustomerRepository;
import br.com.breakfastapp.server.domains.users.partner.domains.Partner;
import br.com.breakfastapp.server.domains.users.partner.repositories.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private PurchaseOrderProductRepository purchaseOrderProductRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private DeliveryRepository deliveryRepository;


    public ResponseEntity<PurchaseOrder> createPurchaseOrder(PurchaseOrderPojo purchaseOrderPojo) {

        Customer customerFound = customerRepository.findOneById(purchaseOrderPojo.getCustomerId());
        Partner partnerFound = partnerRepository.findOneById(purchaseOrderPojo.getPartnerId());
        Address addressFound = addressRepository.findOneById(purchaseOrderPojo.getAddressId());

        Delivery newDelivery = new Delivery();
        newDelivery.setAddress(addressFound);
        newDelivery.setDeliveryStatus(DeliveryStatus.WAITING);
        Delivery deliveryReturned = deliveryRepository.save(newDelivery);

        PurchaseOrder newPurchaseOrder = new PurchaseOrder();

        newPurchaseOrder.setCustomer(customerFound);
        newPurchaseOrder.setPartner(partnerFound);
        newPurchaseOrder.setDelivery(deliveryReturned);
        newPurchaseOrder.setPurchaseOrderStatus(PurchaseOrderStatus.OPEN);
        newPurchaseOrder.setTotalPrice(purchaseOrderPojo.getTotalPrice());
        PurchaseOrder created = purchaseOrderRepository.save(newPurchaseOrder);

        product: purchaseOrderPojo.getProducts().forEach( productPojo -> {
            PurchaseOrderProduct newPurchaseOrderProduct = new PurchaseOrderProduct();
            newPurchaseOrderProduct.setPurchaseOrder(created);
            newPurchaseOrderProduct.setQuantity(productPojo.getQuantity());
            Product productToInsert = productRepository.findOneById(productPojo.getProductId());
            newPurchaseOrderProduct.setProduct(productToInsert);
            purchaseOrderProductRepository.save(newPurchaseOrderProduct);
        });

        return new ResponseEntity(created, HttpStatus.CREATED);
    }

    public ResponseEntity<List<PurchaseOrder>> findAllPurchaseOrders(){
        List<PurchaseOrder> returnedList = purchaseOrderRepository.findAll();
        return new ResponseEntity<>(returnedList, HttpStatus.OK);
    }

    public ResponseEntity<List<PurchaseOrder>> findAllPurchaseOrdersByCustomerId(Integer customerId) {
        List<PurchaseOrder> returnedList = purchaseOrderRepository.findAllByCustomerId(customerId);
        return new ResponseEntity<>(returnedList, HttpStatus.OK);
    }
}
