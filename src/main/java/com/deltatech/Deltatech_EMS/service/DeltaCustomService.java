package com.deltatech.Deltatech_EMS.service;

import com.deltatech.Deltatech_EMS.entity.Address;
import com.deltatech.Deltatech_EMS.entity.DeltaTech;
import com.deltatech.Deltatech_EMS.repository.AddressRepository;
import com.deltatech.Deltatech_EMS.repository.DeltaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeltaCustomService {
    @Autowired
    private DeltaRepository deltaRepository;
    @Autowired
    private AddressRepository addressRepository;

    public List<DeltaTech> findByFirstName(String firstName) {
        return deltaRepository.findByFirstName(firstName);
    }

    public List<DeltaTech> findByLastName(String lastName) {
        return deltaRepository.findByLastName(lastName);
    }

    public List<DeltaTech> findByGender(String gender) {
        return deltaRepository.findByGender(gender);
    }

    public List<DeltaTech> findByGenderAndLastName(String gender, String lastName) {
        return deltaRepository.findByGenderAndLastName(gender,lastName);
    }

    public List<DeltaTech> findByFirstNameContaining(String ch) {
        return deltaRepository.findByFirstNameContaining(ch);
    }

    public Optional<Address> getAddress(Long eid) {
        return addressRepository.findById(eid);
    }
}
