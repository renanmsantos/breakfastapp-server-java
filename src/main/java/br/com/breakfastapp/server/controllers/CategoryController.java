package br.com.breakfastapp.server.controllers;

import br.com.breakfastapp.server.domains.products.domains.Category;
import br.com.breakfastapp.server.domains.products.domains.Product;
import br.com.breakfastapp.server.domains.products.services.CategoryService;
import br.com.breakfastapp.server.domains.products.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> createCustomer(@RequestBody @Valid Category category ){
        return categoryService.createCategory(category);
    }

    @PutMapping
    public ResponseEntity<Category> saveCustomer(@RequestBody Category category ){
        return categoryService.saveProduct(category);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteCategoryById(@PathVariable(name = "id") Integer id){
        return categoryService.deleteCategoryById(id);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        return categoryService.findAllCategories();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> getOneCategoryById(@PathVariable(name = "id") Integer id ){
        return categoryService.findOneCategoryById(id);
    }

}
