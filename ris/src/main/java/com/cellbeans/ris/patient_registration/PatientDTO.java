package com.cellbeans.ris.patient_registration;

public class PatientDTO {

	private String name;
	private Integer age;
	private String gender;
	private String contactNumber;
	private String address;
	private String medicalHistory;
	private Boolean isEmergency = false; 

	// Getters and Setters
	
	
	public String getName() {
		return name;
	}

	

	public Boolean getIsEmergency() {
		return isEmergency;
	}



	public void setIsEmergency(Boolean isEmergency) {
		this.isEmergency = isEmergency;
	}



	public void setAge(Integer age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

}
