package br.com.breakfastapp.server.domains.orders.pojos;

import br.com.breakfastapp.server.domains.orders.domains.PurchaseOrder;
import br.com.breakfastapp.server.domains.products.domains.Product;
import br.com.breakfastapp.server.domains.users.address.domains.Address;
import lombok.Data;

import java.util.List;

@Data
public class PurchaseOrderReturnedPojo {

    private PurchaseOrder purchaseOrder;

    private List<Product> products;

}
