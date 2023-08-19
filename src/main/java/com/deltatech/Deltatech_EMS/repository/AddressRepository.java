package com.deltatech.Deltatech_EMS.repository;

import com.deltatech.Deltatech_EMS.entity.Address;
import com.deltatech.Deltatech_EMS.entity.DeltaTech;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    @Modifying
    @Query(value = "delete from address where e_id=:id",nativeQuery = true)
    public void deleteAddressIdByEmployeeId(Long id);

}
