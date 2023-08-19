package com.deltatech.Deltatech_EMS.controller;

import com.deltatech.Deltatech_EMS.entity.Address;
import com.deltatech.Deltatech_EMS.entity.DeltaTech;
import com.deltatech.Deltatech_EMS.service.DeltaCustomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/custom")
@CrossOrigin("http://localhost:4200")
public class DeltaCustomController {
    @Autowired
    private DeltaCustomService deltaCustomService;
    @GetMapping("/firstName/{firstName}")
    public ResponseEntity<List<DeltaTech>>findByFirstName(@Valid @PathVariable("firstName") String firstName){
        return ResponseEntity.status(202).body(deltaCustomService.findByFirstName(firstName));
    }

    @GetMapping("/addressList/{eid}")
    public ResponseEntity<Optional<Address>> getAddress(@Valid @PathVariable("eid") Long eid){
    return ResponseEntity.ok(deltaCustomService.getAddress(eid));
    }

    @GetMapping("/lastName/{lastName}")
    public ResponseEntity<List<DeltaTech>>findByLastName(@Valid @PathVariable("lastName") String lastName){
        return ResponseEntity.status(202).body(deltaCustomService.findByLastName(lastName));
    }
    @GetMapping("/gender/{gender}")
    public ResponseEntity<List<DeltaTech>>findByGender(@Valid @PathVariable("gender") String gender){
        return ResponseEntity.status(202).body(deltaCustomService.findByGender(gender));
    }
    @GetMapping("/g&l/{gender}/{lastName}")
    public ResponseEntity<List<DeltaTech>>findByGenderAndLastName
            (@Valid @PathVariable("gender") String gender, @Valid @PathVariable("lastName") String lastName){
        return ResponseEntity.status(202).body(deltaCustomService.findByGenderAndLastName(gender,lastName));
    }
    @GetMapping("/characterFilter/{ch}")
    public ResponseEntity<List<DeltaTech>>findByFirstNameContaining(@Valid @PathVariable("ch") String ch){
        return ResponseEntity.status(203).body(deltaCustomService.findByFirstNameContaining(ch));
    }
}
