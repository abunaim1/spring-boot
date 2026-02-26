package com.hospitalManagement.hospitalManagement.repository;

import com.hospitalManagement.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.hospitalManagement.hospitalManagement.entity.Patient;
import com.hospitalManagement.hospitalManagement.entity.type.BloodGroupType;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByName(String name);
    List<Patient> findByDOBOrEmail(LocalDate DOB, String email);

    List<Patient> findByDOBBetween(LocalDate startDate, LocalDate endDate);

    List<Patient> findByNameOrderByIDDesc(String query);


    @Query("SELECT p from Patient p where p.blood_group = ?1")
    List<Patient> findByBloodGroup(@Param("blood_group") BloodGroupType bloodGroup);

    @Query("select p from Patient p where p.DOB > :DOB")
    List<Patient> findByBornAfterDate(@Param("DOB") LocalDate DOB);

    @Query("select new com.hospitalManagement.hospitalManagement.dto.BloodGroupCountResponseEntity(p.blood_group, " +
            "Count(p)) from Patient p group by p.blood_group")
    List <BloodGroupCountResponseEntity> countEachBloodGroupType();

    @Query(value = "select * from patient", nativeQuery = true)
    List<Patient> findAllPatient();


    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = :name where p.ID = :ID")
    int updateNameWithId(@Param("name") String name, @Param("ID") Long ID);

}
