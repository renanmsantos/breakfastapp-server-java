package br.com.breakfastapp.server.domains.orders.pojos;

import lombok.Data;

@Data
public class PurchaseOrderPojo {

    private Integer customerId;

    private Integer partnerId;

    private Integer addressId;
}
