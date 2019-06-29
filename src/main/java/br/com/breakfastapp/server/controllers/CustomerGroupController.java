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
    public ResponseEntity<CustomerGroup> create(@RequestBody @Valid CustomerGroup customerGroup ){
        return customerGroupService.create(customerGroup);
    }

    @PutMapping
    public ResponseEntity<CustomerGroup> save(@RequestBody CustomerGroup customerGroup ){
        return customerGroupService.save(customerGroup);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteById(@PathVariable(name = "id") Integer id){
        return customerGroupService.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<List<CustomerGroup>> getAll(){
        return customerGroupService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerGroup> getOneById(@PathVariable(name = "id") Integer id ){
        return customerGroupService.findOneById(id);
    }

}
