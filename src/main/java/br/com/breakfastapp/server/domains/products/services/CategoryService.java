package br.com.breakfastapp.server.domains.products.services;

import br.com.breakfastapp.server.domains.products.domains.Category;
import br.com.breakfastapp.server.domains.products.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseEntity<Category> createCategory(Category category) {
        Category created = categoryRepository.save(category);
        return new ResponseEntity(created, HttpStatus.CREATED);
    }

    public ResponseEntity<Category> saveProduct(Category category){
       if( !categoryRepository.existsById(category.getId()) ){
           return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
       }
        Category old = categoryRepository.findOneById(category.getId());
        old.setName(category.getName());
        old.setDescription(category.getDescription());
        old.setActive(category.getActive());

        Category saved = categoryRepository.save(old);
        return new ResponseEntity<>(saved,HttpStatus.OK);
    }

    public ResponseEntity deleteCategoryById(Integer id) {
        if( categoryRepository.existsById(id) ){
            categoryRepository.deleteById(id);
        }
        return new ResponseEntity("",HttpStatus.OK);
    }

    public ResponseEntity<List<Category>> findAllCategories(){
        List<Category> returnedList = categoryRepository.findAll();
        return new ResponseEntity<>(returnedList, HttpStatus.OK);
    }

    public ResponseEntity<Category> findOneCategoryById(Integer categoryId) {
        Category found = categoryRepository.findOneById(categoryId);
        return new ResponseEntity<>(found,HttpStatus.OK);
    }



}
