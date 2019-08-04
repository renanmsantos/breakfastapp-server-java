package br.com.breakfastapp.server.controllers;

import br.com.breakfastapp.server.domains.products.domains.Product;
import br.com.breakfastapp.server.domains.products.services.ProductService;
import br.com.breakfastapp.server.domains.users.customer.pojos.CustomerPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createCustomer(@RequestBody @Valid Product product ){
        return productService.createProduct(product);
    }

    @PutMapping
    public ResponseEntity<Product> saveCustomer(@RequestBody Product product ){
        return productService.saveProduct(product);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteProductById(@PathVariable(name = "id") Integer id){
        return productService.deleteProductById(id);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return productService.findAllProducts();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getOneProductById(@PathVariable(name = "id") Integer id ){
        return productService.findOneProductById(id);
    }

}
