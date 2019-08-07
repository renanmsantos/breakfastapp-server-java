package br.com.breakfastapp.server.domains.orders.pojos;

import lombok.Data;

@Data
public class PurchaseOrderProductPojo {

    private Integer productId;

    private Integer quantity;
}
