package com.cellbeans.ris.patient_registration;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PatientService {
	
	 private final PatientRepository repository;
	    public PatientService(PatientRepository repository) { this.repository = repository; }

	    public List<Patient> getAllPatients() {
	        return repository.findAllByOrderByIsEmergencyDesc();
	    }

	    public Optional<Patient> getPatientById(Long id) { return repository.findById(id); }

	    public Patient savePatient(Patient patient) { return repository.save(patient); }

	    public void deletePatient(Long id) { repository.deleteById(id); }
	    
}
