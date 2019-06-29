package br.com.breakfastapp.server.controllers;

import br.com.breakfastapp.server.domains.users.customer.CustomerGroup;
import br.com.breakfastapp.server.services.CustomerGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customer/groups")
public class CustomerGroupController {

    @Autowired
    private CustomerGroupService customerGroupService;

    @PostMapping
    public ResponseEntity<CustomerGroup> createCustomerGroup(@RequestBody @Valid CustomerGroup customerGroup ){
        return customerGroupService.createCustomerGroup(customerGroup);
    }

    @PutMapping
    public ResponseEntity<CustomerGroup> saveCustomerGroup(@RequestBody CustomerGroup customerGroup ){
        return customerGroupService.saveCustomerGroup(customerGroup);
    }

    @DeleteMapping(value = "/{customerGroupId}")
    public ResponseEntity deleteCustomerGroup(@PathVariable(name = "customerGroupId") Integer customerGroupId){
        return customerGroupService.deleteCustomerGroup(customerGroupId);
    }

    @GetMapping
    public ResponseEntity<List<CustomerGroup>> getAllCustomerGroups(){
        return customerGroupService.findAllCustomerGroups();
    }

    @GetMapping(value = "/{customerGroupId}")
    public ResponseEntity<CustomerGroup> getCustomerById(@PathVariable(name = "customerGroupId") Integer customerGroupId ){
        return customerGroupService.findCustomerGroupById(customerGroupId);
    }

}
