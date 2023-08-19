package com.deltatech.Deltatech_EMS.repository;

import com.deltatech.Deltatech_EMS.entity.DeltaTech;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeltaRepository extends JpaRepository<DeltaTech, Long> {
    List<DeltaTech>findByFirstName(String firstName);
    List<DeltaTech>findByLastName(String lastName);
    List<DeltaTech>findByGender(String gender);
    List<DeltaTech>findByGenderAndLastName(String gender, String lastName);
    List<DeltaTech>findByFirstNameContaining(String ch);
}
