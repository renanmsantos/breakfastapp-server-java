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

    public ResponseEntity<CustomerGroup> create(CustomerGroup customerGroup) {
        CustomerGroup created = customerGroupRepository.save(customerGroup);
        return new ResponseEntity(created, HttpStatus.CREATED);
    }

    public ResponseEntity<CustomerGroup> save(CustomerGroup customerGroup){
       if( !customerGroupRepository.existsById(customerGroup.getId()) ){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        CustomerGroup saved = customerGroupRepository.save(customerGroup);
        return new ResponseEntity<>(saved,HttpStatus.OK);
    }

    public ResponseEntity deleteById(Integer id) {
        if( customerGroupRepository.existsById(id) ){
            customerGroupRepository.deleteById(id);
        }
        return new ResponseEntity("",HttpStatus.OK);
    }

    public ResponseEntity<List<CustomerGroup>> findAll(){
        List<CustomerGroup> returnedList = customerGroupRepository.findAll();
        return new ResponseEntity<>(returnedList, HttpStatus.OK);
    }

    public ResponseEntity<CustomerGroup> findOneById(Integer id) {
        CustomerGroup found = customerGroupRepository.findOneById(id);
        return new ResponseEntity<>(found,HttpStatus.OK);
    }

}
