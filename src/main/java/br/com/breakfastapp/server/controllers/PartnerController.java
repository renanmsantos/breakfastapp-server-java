package br.com.breakfastapp.server.controllers;

import br.com.breakfastapp.server.domains.users.partner.domains.Partner;
import br.com.breakfastapp.server.domains.users.partner.domains.Segment;
import br.com.breakfastapp.server.domains.users.partner.domains.SocialInformation;
import br.com.breakfastapp.server.domains.users.partner.services.PartnerService;
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

    /**
     * @apiNote:  Partner
     **/

    @PostMapping
    public ResponseEntity<Partner> createPartner(@RequestBody @Valid Partner partner){
        return partnerService.createPartner(partner);
    }

    @PutMapping
    public ResponseEntity<Partner> savePartner(@RequestBody Partner partner){
        return partnerService.savePartner(partner);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletePartnerById(@PathVariable(name = "id") Integer id){
        return partnerService.deletePartnerById(id);
    }

    @GetMapping
    public ResponseEntity<List<Partner>> getAllPartners(){
        return partnerService.findAllPartners();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Partner> getOnePartnerById(@PathVariable(name = "id") Integer id ){
        return partnerService.findOnePartnerById(id);
    }

    /**
     * @apiNote:  SocialInformation
     **/

    @PostMapping(value = "/socialinfo")
    public ResponseEntity<SocialInformation> createSocialInformation(@RequestBody @Valid SocialInformation socialInformation){
        return partnerService.createSocialInformation(socialInformation);
    }

    @PutMapping(value = "/socialinfo")
    public ResponseEntity<SocialInformation> saveSocialInformation(@RequestBody SocialInformation socialInformation){
        return partnerService.saveSocialInformation(socialInformation);
    }

    @DeleteMapping(value = "/socialinfo/{id}")
    public ResponseEntity deleteSocialInformationById(@PathVariable(name = "id") Integer id){
        return partnerService.deleteSocialInformationById(id);
    }

    @GetMapping(value = "/socialinfo")
    public ResponseEntity<List<SocialInformation>> getAllSocialInformation(){
        return partnerService.findAllSocialInformation();
    }

    @GetMapping(value = "/socialinfo/{id}")
    public ResponseEntity<SocialInformation> getOneSocialInformationById(@PathVariable(name = "id") Integer id ){
        return partnerService.findOneSocialInformationById(id);
    }


    /**
     * @apiNote:  Segment
     **/

    @PostMapping(value = "/segment")
    public ResponseEntity<Segment> createSegment(@RequestBody @Valid Segment segment){
        return partnerService.createSegment(segment);
    }

    @PutMapping(value = "/segment")
    public ResponseEntity<Segment> saveSegment(@RequestBody Segment segment){
        return partnerService.saveSegment(segment);
    }

    @DeleteMapping(value = "/segment/{id}")
    public ResponseEntity deleteSegmentById(@PathVariable(name = "id") Integer id){
        return partnerService.deleteSegmentById(id);
    }

    @GetMapping(value = "/segment")
    public ResponseEntity<List<Segment>> getAllSegments(){
        return partnerService.findAllSegments();
    }

    @GetMapping(value = "/segment/{id}")
    public ResponseEntity<Segment> getOneSegmentById(@PathVariable(name = "id") Integer id ){
        return partnerService.findOneSegmentById(id);
    }

}
