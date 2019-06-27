package br.com.breakfastapp.server.controllers;

import br.com.breakfastapp.server.domains.users.customer.Customer;
import br.com.breakfastapp.server.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody @Valid Customer customer ){
        return customerService.createCustomer(customer);
    }

    @PutMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody @Valid Customer customer ){
        return customerService.saveCustomer(customer);
    }

    @DeleteMapping(value = "/{customerId}")
    public ResponseEntity deleteCustomer(
            @PathVariable(name = "customerId") Integer customerId){
        return customerService.deleteCustomer(customerId);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return customerService.findAllCustomers();
    }

    @GetMapping(value = "/{customerId}")
    public ResponseEntity<Optional<Customer>> getCustomerById(
            @PathVariable(name = "customerId") Integer customerId ){
        return customerService.findCustomerById(customerId);
    }

}
