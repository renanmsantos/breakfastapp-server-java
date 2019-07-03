package br.com.breakfastapp.server.controllers;

import br.com.breakfastapp.server.domains.users.customer.domains.Customer;
import br.com.breakfastapp.server.domains.users.customer.domains.CustomerGroup;
import br.com.breakfastapp.server.domains.users.customer.services.CustomerService;
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

    /**
     * @apiNote  ROOT - Customer
     **/

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody @Valid Customer customer ){
        return customerService.createCustomer(customer);
    }

    @PutMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer ){
        return customerService.saveCustomer(customer);
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

    /**
     * @apiNote  CustomerGroup
     **/

    @PostMapping(value = "/group")
    public ResponseEntity<CustomerGroup> createCustomerGroup(@RequestBody @Valid CustomerGroup customerGroup ){
        return customerService.createCustomerGroup(customerGroup);
    }

    @PutMapping(value = "/group")
    public ResponseEntity<CustomerGroup> saveCustomerGroup(@RequestBody CustomerGroup customerGroup ){
        return customerService.saveCustomerGroup(customerGroup);
    }

    @DeleteMapping(value = "/group/{id}")
    public ResponseEntity deleteCustomerGroupById(@PathVariable(name = "id") Integer id){
        return customerService.deleteCustomerGroupById(id);
    }

    @GetMapping(value = "/group")
    public ResponseEntity<List<CustomerGroup>> getAllCustomerGroups(){
        return customerService.findAllCustomerGroups();
    }

    @GetMapping(value = "/group/{id}")
    public ResponseEntity<CustomerGroup> getOneCustomerGroupById(@PathVariable(name = "id") Integer id ){
        return customerService.findOneCustomerGroupById(id);
    }

}
