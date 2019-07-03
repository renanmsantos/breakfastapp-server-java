package br.com.breakfastapp.server.domains.users.address.services;

import br.com.breakfastapp.server.domains.users.address.domains.Address;
import br.com.breakfastapp.server.domains.users.address.repositories.AddressRepository;
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
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public ResponseEntity<Address> createAddress(Address address) {
        Address created = addressRepository.save(address);
        return new ResponseEntity(created, HttpStatus.CREATED);
    }

    public ResponseEntity<Address> saveAddress(Address address){
       if( !addressRepository.existsById(address.getId()) ){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        Address saved = addressRepository.save(address);
        return new ResponseEntity<>(saved,HttpStatus.OK);
    }

    public ResponseEntity deleteAddressById(Integer id) {
        if( addressRepository.existsById(id) ){
            addressRepository.deleteById(id);
        }
        return new ResponseEntity("",HttpStatus.OK);
    }

    public ResponseEntity<List<Address>> findAllAddresses(){
        List<Address> returnedList = addressRepository.findAll();
        return new ResponseEntity<>(returnedList, HttpStatus.OK);
    }

    public ResponseEntity<Address> findByCep(String cep){
        Address found = addressRepository.findOneByCep(cep);
        return new ResponseEntity<>(found,HttpStatus.OK);
    }

}
