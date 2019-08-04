package br.com.breakfastapp.server.controllers;

import br.com.breakfastapp.server.domains.users.address.domains.Address;
import br.com.breakfastapp.server.domains.users.address.services.AddressService;
import br.com.breakfastapp.server.domains.users.customer.domains.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address ){
        return addressService.createAddress(address);
    }

    @PutMapping
    public ResponseEntity<Address> saveAddress(@RequestBody Address address ){
        return addressService.saveAddress(address);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteCustomerById(@PathVariable(name = "id") Integer id){
        return addressService.deleteAddressById(id);
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses(){
        return addressService.findAllAddresses();
    }

    @GetMapping(value = "/{cep}")
    public ResponseEntity<Address> getOneAddressById(@PathVariable(name = "cep") String cep){
        return addressService.findByCep(cep);
    }


}
