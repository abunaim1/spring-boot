package com.hospitalManagement.hospitalManagement;


import com.hospitalManagement.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.hospitalManagement.hospitalManagement.entity.Patient;
import com.hospitalManagement.hospitalManagement.entity.type.BloodGroupType;
import com.hospitalManagement.hospitalManagement.repository.PatientRepository;
import com.hospitalManagement.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;


    @Test
    public void testPatientRepository(){
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);
    }

    @Test
    public void  testTransactionMethods(){
//        Patient patient = patientService.getPatientById(1L);
//        System.out.println(patient);

//        Patient patientByName = patientRepository.findByName("Kabir");
//        System.out.println(patientByName);

//        List<Patient> patientList = patientRepository.findByDOBOrEmail(LocalDate.of(1990, 5, 10), "neha.iyer@example.com");

//        List<Patient> patientList = patientRepository.findByNameOrderByIDDesc("ta");

//        List<Patient> patientList = patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);

//        List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(1993, 2, 20));
//


//        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for(Object[] objects: bloodGroupList){
//            System.out.println(objects[0] + " " + objects[1]);
//        }

//        List<Patient> patientList = patientRepository.findAllPatient();
//        for(Patient p: patientList){
//            System.out.println(p);
//        }

//        int rowsUpdate = patientRepository.updateNameWithId("Toru", 1L)
//        System.out.println(rowsUpdate);

//        List<BloodGroupCountResponseEntity> bloodGroupCount = patientRepository.countEachBloodGroupType();
//        for (BloodGroupCountResponseEntity bloodGroupCountResponse: bloodGroupCount){
//            System.out.println(bloodGroupCountResponse);
//        }

    }
}
