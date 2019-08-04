package br.com.breakfastapp.server.security.services;

import br.com.breakfastapp.server.domains.users.customer.domains.Customer;
import br.com.breakfastapp.server.domains.users.customer.repositories.CustomerRepository;
import br.com.breakfastapp.server.security.domains.CustomerPrincipal;
import br.com.breakfastapp.server.security.exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        Customer customer = customerRepository.findByEmail(email);
        if(customer == null){
            throw new CustomerNotFoundException(email);
        }
        return new CustomerPrincipal(customer);
    }
}
