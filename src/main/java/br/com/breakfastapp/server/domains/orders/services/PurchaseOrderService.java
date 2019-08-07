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


    public ResponseEntity<PurchaseOrder> createPurchaseOrder(PurchaseOrderPojo purchaseOrder) {

        Customer customerFound = customerRepository.findOneById(purchaseOrder.getCustomerId());
        Partner partnerFound = partnerRepository.findOneById(purchaseOrder.getPartnerId());
        Address addressFound = addressRepository.findOneById(purchaseOrder.getAddressId());

        Delivery newDelivery = new Delivery();
        newDelivery.setAddress(addressFound);
        newDelivery.setDeliveryStatus(DeliveryStatus.WAITING);
        Delivery deliveryReturned = deliveryRepository.save(newDelivery);

        PurchaseOrder newPurchaseOrder = new PurchaseOrder();

        newPurchaseOrder.setCustomer(customerFound);
        newPurchaseOrder.setPartner(partnerFound);
        newPurchaseOrder.setDelivery(deliveryReturned);

        newPurchaseOrder.setPurchaseOrderStatus(PurchaseOrderStatus.OPEN);
        PurchaseOrder created = purchaseOrderRepository.save(newPurchaseOrder);
        return new ResponseEntity(created, HttpStatus.CREATED);
    }
    public ResponseEntity<PurchaseOrderProduct> createPurchaseOrderProduct(List<PurchaseOrderProductPojo> ListPurchaseOrderProductPojo, Integer purchaseOrderId) {

        PurchaseOrder purchaseOrderFound = purchaseOrderRepository.findOneById(purchaseOrderId);

        ListPurchaseOrderProductPojo.forEach(purchaseOrderProductPojo -> {
            Product productFound = productRepository.findOneById(purchaseOrderProductPojo.getProductId());
            PurchaseOrderProduct newPurchaseOrderProduct = new PurchaseOrderProduct();
            newPurchaseOrderProduct.setPurchaseOrder(purchaseOrderFound);
            newPurchaseOrderProduct.setProduct(productFound);
            newPurchaseOrderProduct.setQuantity(purchaseOrderProductPojo.getQuantity());
            purchaseOrderProductRepository.save(newPurchaseOrderProduct);
        });

        List<PurchaseOrderProduct> list = purchaseOrderProductRepository.findAllByPurchaseOrderId(purchaseOrderId);

        return new ResponseEntity(list, HttpStatus.CREATED);
    }


    public ResponseEntity<List<PurchaseOrder>> findAllPurchaseOrders(){
        List<PurchaseOrder> returnedList = purchaseOrderRepository.findAll();
        return new ResponseEntity<>(returnedList, HttpStatus.OK);
    }

    public ResponseEntity<List<PurchaseOrderProduct>> findAllPurchaseOrderProductByPurchaseOrderId(Integer purchaseOrderId) {
        List<PurchaseOrderProduct> found = purchaseOrderProductRepository.findAllByPurchaseOrderId(purchaseOrderId);
        return new ResponseEntity<>(found,HttpStatus.OK);
    }

    public ResponseEntity<PurchaseOrder> findOnePurchaseOrderByCustomerId(Integer customerId) {
        PurchaseOrder found = purchaseOrderRepository.findOneByCustomerId(customerId);
        return new ResponseEntity<>(found,HttpStatus.OK);
    }





}
