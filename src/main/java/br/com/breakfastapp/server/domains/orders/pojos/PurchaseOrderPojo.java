package br.com.breakfastapp.server.domains.orders.pojos;

import lombok.Data;

import java.util.List;

@Data
public class PurchaseOrderPojo {

    private Integer customerId;

    private Integer partnerId;

    private Integer addressId;

    private List<ProductPojo> products;

    private Float totalPrice;
}
