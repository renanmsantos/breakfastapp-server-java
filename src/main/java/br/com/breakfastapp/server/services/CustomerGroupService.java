package br.com.breakfastapp.server.services;

import br.com.breakfastapp.server.domains.users.customer.Customer;
import br.com.breakfastapp.server.domains.users.customer.CustomerGroup;
import br.com.breakfastapp.server.repositories.CustomerGroupRepository;
import br.com.breakfastapp.server.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerGroupService {

    @Autowired
    private CustomerGroupRepository customerGroupRepository;

    public ResponseEntity<CustomerGroup> createCustomerGroup(CustomerGroup customerGroup) {
        CustomerGroup createdCustomerGroup = customerGroupRepository.save(customerGroup);
        return new ResponseEntity(createdCustomerGroup, HttpStatus.CREATED);
    }

    public ResponseEntity<CustomerGroup> saveCustomerGroup(CustomerGroup customerGroup){
       if( !customerGroupRepository.existsById(customerGroup.getCustomerGroupId()) ){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        CustomerGroup savedCustomerGroup = customerGroupRepository.save(customerGroup);
        return new ResponseEntity<>(savedCustomerGroup,HttpStatus.OK);
    }

    public ResponseEntity deleteCustomerGroup(Integer customerGroupId) {
        if( customerGroupRepository.existsById(customerGroupId) ){
            customerGroupRepository.deleteCustomerGroupById(customerGroupId);
        }
        return new ResponseEntity("",HttpStatus.OK);
    }

    public ResponseEntity<List<CustomerGroup>> findAllCustomerGroups(){
        List<CustomerGroup> customerGroups = customerGroupRepository.findAll();
        return new ResponseEntity<>(customerGroups, HttpStatus.OK);
    }

    public ResponseEntity<CustomerGroup> findCustomerGroupById(Integer customerGroupId) {
        CustomerGroup foundCustomerGroup = customerGroupRepository.findCustomerGroupById(customerGroupId);
        return new ResponseEntity<>(foundCustomerGroup,HttpStatus.OK);
    }

}
