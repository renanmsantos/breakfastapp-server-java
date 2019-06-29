package br.com.breakfastapp.server.services;

import br.com.breakfastapp.server.domains.users.customer.Customer;
import br.com.breakfastapp.server.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<Customer> create(Customer customer) {
        Customer created = customerRepository.save(customer);
        return new ResponseEntity(created, HttpStatus.CREATED);
    }

    public ResponseEntity<Customer> save(Customer customer){
       if( !customerRepository.existsById(customer.getId()) ){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        Customer saved = customerRepository.save(customer);
        return new ResponseEntity<>(saved,HttpStatus.OK);
    }

    public ResponseEntity deleteById(Integer id) {
        if( customerRepository.existsById(id) ){
            customerRepository.deleteById(id);
        }
        return new ResponseEntity("",HttpStatus.OK);
    }

    public ResponseEntity<List<Customer>> findAll(){
        List<Customer> returnedList = customerRepository.findAll();
        return new ResponseEntity<>(returnedList, HttpStatus.OK);
    }

    public ResponseEntity<Customer> findOneById(Integer customerId) {
        Customer found = customerRepository.findOneById(customerId);
        return new ResponseEntity<>(found,HttpStatus.OK);
    }

}
