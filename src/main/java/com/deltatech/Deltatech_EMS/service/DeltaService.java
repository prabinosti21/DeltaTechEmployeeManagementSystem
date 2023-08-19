package com.deltatech.Deltatech_EMS.service;

import com.deltatech.Deltatech_EMS.entity.DeltaTech;
import com.deltatech.Deltatech_EMS.repository.AddressRepository;
import com.deltatech.Deltatech_EMS.repository.DeltaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DeltaService {
    @Autowired
    private DeltaRepository deltaRepository;
    @Autowired
    private AddressRepository addressRepository;
    public void saveEmployee(List<DeltaTech> deltaTechList) {
        deltaRepository.saveAll(deltaTechList);
    }

    public List<DeltaTech> getEmployee() {
        return deltaRepository.findAll();
    }

    public DeltaTech getEmployeeById(Long eid) {
        Optional<DeltaTech>deltaTechOptional = deltaRepository.findById(eid);
        if(deltaTechOptional.isPresent()){
            return deltaTechOptional.get();
        }
        else{
            return null;
        }
    }

    public String deleteEmployee(Long eid) {
        Optional<DeltaTech>deltaTech = deltaRepository.findById(eid);
        if(deltaTech.isPresent()){
            deltaRepository.deleteById(eid);
            return "The employee having Id = " + eid + " is deleted successfully.";
        }
        else{
            return "Warning !!!. The employee having Id = " + eid + " does not exist in our database.";
        }
    }

    @Transactional
    public String updateEmployeeRecord(DeltaTech deltaTech,Long eid) {
        Optional<DeltaTech>deltaTech1 = deltaRepository.findById(eid);
        if(deltaTech1.isPresent()){
            DeltaTech deltaTech2 = deltaTech1.get();
            deltaTech.setEid(deltaTech2.getEid());
            addressRepository.deleteAddressIdByEmployeeId(eid);
            deltaRepository.save(deltaTech);
            return "The record of employee having Id = " + eid + " is updated successfully.";
        }
        else{
            return "Warning !!!. The record of employee having Id = " + eid + " doesn't exist in our database.";
        }
    }
}
