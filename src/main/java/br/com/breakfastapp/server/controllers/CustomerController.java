package br.com.breakfastapp.server.controllers;

import br.com.breakfastapp.server.domains.users.address.domains.Address;
import br.com.breakfastapp.server.domains.users.customer.domains.Customer;
import br.com.breakfastapp.server.domains.users.customer.pojos.CustomerPojo;
import br.com.breakfastapp.server.domains.users.customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody @Valid Customer customer ){
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerService.createCustomer(customer);
    }

    @PutMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerPojo customer ){
        if(!customer.getPassword().isEmpty()){
            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        }
        return customerService.saveCustomer(customer);
    }

    @DeleteMapping(value = "/{customerId}/address/{addressId}")
    public ResponseEntity<Customer> removeAddressFromByIds(
            @PathVariable(name = "addressId") Integer addressId,
            @PathVariable(name = "customerId") Integer customerId ){
        return customerService.deleteAddressByIds(customerId,addressId);
    }

    @PutMapping(value = "/{customerId}/address")
    public ResponseEntity<Customer> addAddressById(
            @PathVariable(name = "customerId") Integer customerId, @RequestBody Address address ){
        return customerService.addAddressById(customerId,address);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteCustomerById(@PathVariable(name = "id") Integer id){
        return customerService.deleteCustomerById(id);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return customerService.findAllCustomers();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getOneCustomerById(@PathVariable(name = "id") Integer id ){
        return customerService.findOneCustomerById(id);
    }

}
