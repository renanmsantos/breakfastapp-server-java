package br.com.breakfastapp.server.domains.users.customer.services;

import br.com.breakfastapp.server.domains.users.address.domains.Address;
import br.com.breakfastapp.server.domains.users.address.repositories.AddressRepository;
import br.com.breakfastapp.server.domains.users.customer.domains.Customer;
import br.com.breakfastapp.server.domains.users.customer.pojos.CustomerPojo;
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
    private AddressRepository addressRepository;

    public ResponseEntity<Customer> createCustomer(Customer customer) {
        Customer created = customerRepository.save(customer);
        return new ResponseEntity(created, HttpStatus.CREATED);
    }

    public ResponseEntity<Customer> saveCustomer(CustomerPojo customer){
       if( !customerRepository.existsById(customer.getId()) ){
           return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
       }
        Customer old = customerRepository.findOneById(customer.getId());
        old.setName(customer.getName());
        old.setLastName(customer.getLastName());
        old.setCellphone(customer.getCellphone());
        if(!customer.getPassword().isEmpty()){
            old.setPassword(customer.getPassword());
        }
        Customer saved = customerRepository.save(old);
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


    public ResponseEntity<Customer> deleteAddressByIds(Integer customerId, Integer addressId) {
        Customer found = customerRepository.findOneById(customerId);
        Address foundAddress = addressRepository.findOneById(addressId);
        found.getAddresses().remove(foundAddress);

        Customer saved = customerRepository.save(found);
        return new ResponseEntity(saved,HttpStatus.OK);
    }

    public ResponseEntity<Customer> createAddressWithCustomerId(Integer customerId, Address address) {
        if( !customerRepository.existsById(customerId) ){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        Customer found = customerRepository.findOneById(customerId);
        Address savedAddress = addressRepository.save(address);
        found.getAddresses().add(savedAddress);

        Customer saved = customerRepository.save(found);

        return new ResponseEntity<>(saved,HttpStatus.OK);
    }
}
