package br.com.breakfastapp.server.controllers;

import br.com.breakfastapp.server.domains.users.partner.Partner;
import br.com.breakfastapp.server.services.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/partners")
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    @PostMapping
    public ResponseEntity<Partner> create(@RequestBody @Valid Partner partner){
        return partnerService.create(partner);
    }

    @PutMapping
    public ResponseEntity<Partner> save(@RequestBody Partner partner){
        return partnerService.save(partner);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable(name = "id") Integer id){
        return partnerService.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<List<Partner>> getAll(){
        return partnerService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Partner> getOneById(@PathVariable(name = "id") Integer id ){
        return partnerService.findOneById(id);
    }

}
