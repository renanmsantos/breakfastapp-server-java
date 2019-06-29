package br.com.breakfastapp.server.controllers;

import br.com.breakfastapp.server.domains.users.customer.Customer;
import br.com.breakfastapp.server.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody @Valid Customer customer ){
        return customerService.create(customer);
    }

    @PutMapping
    public ResponseEntity<Customer> save(@RequestBody Customer customer ){
        return customerService.save(customer);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteById(@PathVariable(name = "id") Integer id){
        return customerService.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAll(){
        return customerService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getOneById(@PathVariable(name = "id") Integer id ){
        return customerService.findOneById(id);
    }

}
