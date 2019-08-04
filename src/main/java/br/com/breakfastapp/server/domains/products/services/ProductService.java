package br.com.breakfastapp.server.domains.products.services;

import br.com.breakfastapp.server.domains.products.domains.Product;
import br.com.breakfastapp.server.domains.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<Product> createProduct(Product product) {
        Product created = productRepository.save(product);
        return new ResponseEntity(created, HttpStatus.CREATED);
    }

    public ResponseEntity<Product> saveProduct(Product product){
       if( !productRepository.existsById(product.getId()) ){
           return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
       }
        Product old = productRepository.findOneById(product.getId());
        old.setName(product.getName());
        old.setPrice(product.getPrice());
        old.setUrlImage(product.getUrlImage());
        old.setDaysProduce(product.getDaysProduce());
        old.setQuantity(product.getQuantity());
        old.setAvailable(product.getAvailable());
        old.setCategory(product.getCategory());

        Product saved = productRepository.save(old);
        return new ResponseEntity<>(saved,HttpStatus.OK);
    }

    public ResponseEntity deleteProductById(Integer id) {
        if( productRepository.existsById(id) ){
            productRepository.deleteById(id);
        }
        return new ResponseEntity("",HttpStatus.OK);
    }

    public ResponseEntity<List<Product>> findAllProducts(){
        List<Product> returnedList = productRepository.findAll();
        return new ResponseEntity<>(returnedList, HttpStatus.OK);
    }

    public ResponseEntity<Product> findOneProductById(Integer productId) {
        Product found = productRepository.findOneById(productId);
        return new ResponseEntity<>(found,HttpStatus.OK);
    }



}
