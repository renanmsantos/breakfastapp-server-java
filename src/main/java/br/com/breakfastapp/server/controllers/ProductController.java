package br.com.breakfastapp.server.controllers;

import br.com.breakfastapp.server.domains.products.domains.Product;
import br.com.breakfastapp.server.domains.products.pojos.ProductPojo;
import br.com.breakfastapp.server.domains.products.services.ProductService;
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
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductPojo product ){
        return productService.createProduct(product);
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
