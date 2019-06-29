package br.com.breakfastapp.server.services;

import br.com.breakfastapp.server.domains.users.partner.Partner;
import br.com.breakfastapp.server.repositories.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    public ResponseEntity<Partner> create(Partner partner) {
        Partner created = partnerRepository.save(partner);
        return new ResponseEntity(created, HttpStatus.CREATED);
    }

    public ResponseEntity<Partner> save(Partner partner){
       if( !partnerRepository.existsById(partner.getId()) ){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        Partner saved = partnerRepository.save(partner);
        return new ResponseEntity<>(saved,HttpStatus.OK);
    }

    public ResponseEntity deleteById(Integer id) {
        if( partnerRepository.existsById(id) ){
            partnerRepository.deleteById(id);
        }
        return new ResponseEntity("",HttpStatus.OK);
    }

    public ResponseEntity<List<Partner>> findAll(){
        List<Partner> returnedList = partnerRepository.findAll();
        return new ResponseEntity<>(returnedList, HttpStatus.OK);
    }

    public ResponseEntity<Partner> findOneById(Integer id) {
        Partner found = partnerRepository.findOneById(id);
        return new ResponseEntity<>(found,HttpStatus.OK);
    }

}
