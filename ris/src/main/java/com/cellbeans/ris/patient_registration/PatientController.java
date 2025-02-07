package com.cellbeans.ris.patient_registration;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientController {
	 private final PatientService service;
	    public PatientController(PatientService service) { this.service = service; }
	    
	    @GetMapping
	    public List<Patient> getAllPatients() { return service.getAllPatients(); }
	    
	    @GetMapping("/{id}")
	    public Optional<Patient> getPatientById(@PathVariable Long id) { return service.getPatientById(id); }
	    
	    @PostMapping
	    public Patient createPatient(@RequestBody PatientDTO patientDTO) {
	        Patient patient = new Patient();
	        patient.setName(patientDTO.getName());
	        patient.setAge(patientDTO.getAge());
	        patient.setGender(patientDTO.getGender());
	        patient.setContactNumber(patientDTO.getContactNumber());
	        patient.setAddress(patientDTO.getAddress());
	        patient.setMedicalHistory(patientDTO.getMedicalHistory());
	        patient.setIsEmergency(patientDTO.getIsEmergency()); // Set emergency status
	        return service.savePatient(patient); 
	    }

	    @PutMapping("/{id}")
	    public Patient updatePatient(@PathVariable Long id, @RequestBody PatientDTO patientDTO) {
	        Patient patient = new Patient();
	        patient.setId(id);
	        patient.setName(patientDTO.getName());
	        patient.setAge(patientDTO.getAge());
	        patient.setGender(patientDTO.getGender());
	        patient.setContactNumber(patientDTO.getContactNumber());
	        patient.setAddress(patientDTO.getAddress());
	        patient.setMedicalHistory(patientDTO.getMedicalHistory());
	        patient.setIsEmergency(patientDTO.getIsEmergency()); // Update emergency status
	        return service.savePatient(patient);
	    }

	    @DeleteMapping("/{id}")
	    public void deletePatient(@PathVariable Long id) { service.deletePatient(id); }
}
