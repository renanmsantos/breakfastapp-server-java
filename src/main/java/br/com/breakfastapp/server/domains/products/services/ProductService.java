package br.com.breakfastapp.server.domains.products.services;

import br.com.breakfastapp.server.domains.products.domains.Category;
import br.com.breakfastapp.server.domains.products.domains.Product;
import br.com.breakfastapp.server.domains.products.pojos.ProductPojo;
import br.com.breakfastapp.server.domains.products.repositories.CategoryRepository;
import br.com.breakfastapp.server.domains.products.repositories.ProductRepository;
import br.com.breakfastapp.server.domains.users.partner.domains.Partner;
import br.com.breakfastapp.server.domains.users.partner.repositories.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PartnerRepository partnerRepository;

    public ResponseEntity<Product> createProduct(ProductPojo productPojo) {
        Product newProduct = new Product();
        newProduct.setName(productPojo.getName());
        newProduct.setAvailable(productPojo.getAvailable());
        newProduct.setQuantity(productPojo.getQuantity());
        newProduct.setDaysProduce(productPojo.getDaysProduce());
        newProduct.setUrlImage(productPojo.getUrlImage());
        newProduct.setPrice(productPojo.getPrice());

        Category foundCategory = categoryRepository.findOneById(productPojo.getCategoryId());
        newProduct.setCategory(foundCategory);

        Partner foundPartner = partnerRepository.findOneById(productPojo.getPartnerId());
        newProduct.setPartner(foundPartner);

        Product created = productRepository.save(newProduct);
        return new ResponseEntity(created, HttpStatus.CREATED);
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
