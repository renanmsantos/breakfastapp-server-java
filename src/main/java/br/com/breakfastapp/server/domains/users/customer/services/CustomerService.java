package br.com.breakfastapp.server.domains.users.customer.services;

import br.com.breakfastapp.server.domains.users.customer.domains.Customer;
import br.com.breakfastapp.server.domains.users.customer.domains.CustomerGroup;
import br.com.breakfastapp.server.domains.users.customer.repositories.CustomerGroupRepository;
import br.com.breakfastapp.server.domains.users.customer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerGroupRepository customerGroupRepository;

    /**
     * @apiNote  Customer
     **/

    public ResponseEntity<Customer> createCustomer(Customer customer) {
        Customer created = customerRepository.save(customer);
        return new ResponseEntity(created, HttpStatus.CREATED);
    }

    public ResponseEntity<Customer> saveCustomer(Customer customer){
       if( !customerRepository.existsById(customer.getId()) ){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        Customer saved = customerRepository.save(customer);
        return new ResponseEntity<>(saved,HttpStatus.OK);
    }

    public ResponseEntity deleteCustomerById(Integer id) {
        if( customerRepository.existsById(id) ){
            customerRepository.deleteById(id);
        }
        return new ResponseEntity("",HttpStatus.OK);
    }

    public ResponseEntity<List<Customer>> findAllCustomers(){
        List<Customer> returnedList = customerRepository.findAll();
        return new ResponseEntity<>(returnedList, HttpStatus.OK);
    }

    public ResponseEntity<Customer> findOneCustomerById(Integer customerId) {
        Customer found = customerRepository.findOneById(customerId);
        return new ResponseEntity<>(found,HttpStatus.OK);
    }

    /**
     * @apiNote  CustomerGroup
     **/

    public ResponseEntity<CustomerGroup> createCustomerGroup(CustomerGroup customerGroup) {
        CustomerGroup created = customerGroupRepository.save(customerGroup);
        return new ResponseEntity(created, HttpStatus.CREATED);
    }

    public ResponseEntity<CustomerGroup> saveCustomerGroup(CustomerGroup customerGroup){
        if( !customerGroupRepository.existsById(customerGroup.getId()) ){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        CustomerGroup saved = customerGroupRepository.save(customerGroup);
        return new ResponseEntity<>(saved,HttpStatus.OK);
    }

    public ResponseEntity deleteCustomerGroupById(Integer id) {
        if( customerGroupRepository.existsById(id) ){
            customerGroupRepository.deleteById(id);
        }
        return new ResponseEntity("",HttpStatus.OK);
    }

    public ResponseEntity<List<CustomerGroup>> findAllCustomerGroups(){
        List<CustomerGroup> returnedList = customerGroupRepository.findAll();
        return new ResponseEntity<>(returnedList, HttpStatus.OK);
    }

    public ResponseEntity<CustomerGroup> findOneCustomerGroupById(Integer id) {
        CustomerGroup found = customerGroupRepository.findOneById(id);
        return new ResponseEntity<>(found,HttpStatus.OK);
    }

}
