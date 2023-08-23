package com.deltatech.Deltatech_EMS.controller;

import com.deltatech.Deltatech_EMS.entity.DeltaTech;
import com.deltatech.Deltatech_EMS.service.DeltaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin("http://localhost:4200")
public class DeltaController {
    @Autowired
    private DeltaService deltaService;
    @PostMapping
    public ResponseEntity<String>saveEmployee(@Valid @RequestBody List<DeltaTech>deltaTechList){
        deltaService.saveEmployee(deltaTechList);
        System.out.println("Changed made");
        return ResponseEntity.status(201).body("Employee record saved successfully");
    }
    @GetMapping()
    public ResponseEntity<List<DeltaTech>>getEmployee(){
        return ResponseEntity.status(201).body(deltaService.getEmployee());
    }
    @GetMapping("/ID/{eid}")
    public ResponseEntity<DeltaTech>getEmployeeById
            (@Valid @PathVariable("eid") Long eid){
        System.out.println("Getting employee details by employee Id");
        return ResponseEntity.status(202).body(deltaService.getEmployeeById(eid));
    }
    @DeleteMapping("/{eid}")
    public ResponseEntity<String>deleteEmployee(@Valid @PathVariable("eid") Long eid){
        System.out.println("Deleting employee details by getting employee Id");
        return ResponseEntity.status(203).body(deltaService.deleteEmployee(eid));
    }
    @PutMapping("/{eid}")
    public ResponseEntity<String> updateEmployeeRecord
            (@Valid @RequestBody DeltaTech deltaTech,@Valid @PathVariable("eid") Long eid){
        return ResponseEntity.status(203).body(deltaService.updateEmployeeRecord(deltaTech,eid));
    }
}
