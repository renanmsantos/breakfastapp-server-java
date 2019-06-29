package br.com.breakfastapp.server.domains.users.partner.services;

import br.com.breakfastapp.server.domains.users.partner.domains.Partner;
import br.com.breakfastapp.server.domains.users.partner.domains.Segment;
import br.com.breakfastapp.server.domains.users.partner.domains.SocialInformation;
import br.com.breakfastapp.server.domains.users.partner.repositories.PartnerRepository;
import br.com.breakfastapp.server.domains.users.partner.repositories.SegmentRepository;
import br.com.breakfastapp.server.domains.users.partner.repositories.SocialInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    private SegmentRepository segmentRepository;

    @Autowired
    private SocialInformationRepository socialInformationRepository;


    /**
     * @apiNote  Partner
     **/

    public ResponseEntity<Partner> createPartner(Partner partner) {
        Partner created = partnerRepository.save(partner);
        return new ResponseEntity(created, HttpStatus.CREATED);
    }

    public ResponseEntity<Partner> savePartner(Partner partner){
       if( !partnerRepository.existsById(partner.getId()) ){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        Partner saved = partnerRepository.save(partner);
        return new ResponseEntity<>(saved,HttpStatus.OK);
    }

    public ResponseEntity deletePartnerById(Integer id) {
        if( partnerRepository.existsById(id) ){
            partnerRepository.deleteById(id);
        }
        return new ResponseEntity("",HttpStatus.OK);
    }

    public ResponseEntity<List<Partner>> findAllPartners(){
        List<Partner> returnedList = partnerRepository.findAll();
        return new ResponseEntity<>(returnedList, HttpStatus.OK);
    }

    public ResponseEntity<Partner> findOnePartnerById(Integer id) {
        Partner found = partnerRepository.findOneById(id);
        return new ResponseEntity<>(found,HttpStatus.OK);
    }

    /**
     * @apiNote  Segment
     **/

    public ResponseEntity<Segment> createSegment(Segment segment) {
        Segment created = segmentRepository.save(segment);
        return new ResponseEntity(created, HttpStatus.CREATED);
    }

    public ResponseEntity<Segment> saveSegment(Segment segment){
        if( !segmentRepository.existsById(segment.getId()) ){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        Segment saved = segmentRepository.save(segment);
        return new ResponseEntity<>(saved,HttpStatus.OK);
    }

    public ResponseEntity deleteSegmentById(Integer id) {
        if( segmentRepository.existsById(id) ){
            segmentRepository.deleteById(id);
        }
        return new ResponseEntity("",HttpStatus.OK);
    }

    public ResponseEntity<List<Segment>> findAllSegments(){
        List<Segment> returnedList = segmentRepository.findAll();
        return new ResponseEntity<>(returnedList, HttpStatus.OK);
    }

    public ResponseEntity<Segment> findOneSegmentById(Integer id) {
        Segment found = segmentRepository.findOneById(id);
        return new ResponseEntity<>(found,HttpStatus.OK);
    }

    /**
     * @apiNote  SocialInformation
     **/

    public ResponseEntity<SocialInformation> createSocialInformation(SocialInformation socialInformation) {
        SocialInformation created = socialInformationRepository.save(socialInformation);
        return new ResponseEntity(created, HttpStatus.CREATED);
    }

    public ResponseEntity<SocialInformation> saveSocialInformation(SocialInformation socialInformation){
        if( !socialInformationRepository.existsById(socialInformation.getId()) ){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        SocialInformation saved = socialInformationRepository.save(socialInformation);
        return new ResponseEntity<>(saved,HttpStatus.OK);
    }

    public ResponseEntity deleteSocialInformationById(Integer id) {
        if( socialInformationRepository.existsById(id) ){
            socialInformationRepository.deleteById(id);
        }
        return new ResponseEntity("",HttpStatus.OK);
    }

    public ResponseEntity<List<SocialInformation>> findAllSocialInformation(){
        List<SocialInformation> returnedList = socialInformationRepository.findAll();
        return new ResponseEntity<>(returnedList, HttpStatus.OK);
    }

    public ResponseEntity<SocialInformation> findOneSocialInformationById(Integer id) {
        SocialInformation found = socialInformationRepository.findOneById(id);
        return new ResponseEntity<>(found,HttpStatus.OK);
    }


}
