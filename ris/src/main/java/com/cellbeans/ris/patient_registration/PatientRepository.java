package com.cellbeans.ris.patient_registration;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	 List<Patient> findAllByOrderByIsEmergencyDesc();

}
