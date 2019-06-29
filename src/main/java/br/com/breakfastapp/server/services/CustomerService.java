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

    public ResponseEntity<Customer> createCustomer(Customer customer) {
        Customer createdCustomer = customerRepository.save(customer);
        return new ResponseEntity(createdCustomer, HttpStatus.CREATED);
    }

    public ResponseEntity<Customer> saveCustomer(Customer customer){
       if( !customerRepository.existsById(customer.getId()) ){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        Customer savedCustomer = customerRepository.save(customer);
        return new ResponseEntity<>(savedCustomer,HttpStatus.OK);
    }

    public ResponseEntity deleteCustomer(Integer customerId) {
        if( customerRepository.existsById(customerId) ){
            customerRepository.deleteCustomerById(customerId);
        }
        return new ResponseEntity("",HttpStatus.OK);
    }

    public ResponseEntity<List<Customer>> findAllCustomers(){
        List<Customer> customers = customerRepository.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    public ResponseEntity<Customer> findCustomerById(Integer customerId) {
        Customer foundCustomer = customerRepository.findCustomerById(customerId);
        return new ResponseEntity<>(foundCustomer,HttpStatus.OK);
    }

}
