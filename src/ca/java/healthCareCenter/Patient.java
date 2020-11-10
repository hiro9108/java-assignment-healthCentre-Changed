package ca.java.healthCareCenter;

import java.time.LocalDate;

public class Patient extends User {
	
	private String gender;
	private LocalDate dateOfBirth;
	
	public Patient(String firstName, String lastName, String phoneNumber, String email, String gender, int year, int month, int day) {
		super(firstName, lastName, phoneNumber, email);
		setGender(gender);
		setDateOfBirth(year, month, day);
	}


	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		if (gender.isEmpty() || gender.equalsIgnoreCase(null)) {
			this.gender = "Unknown";
		} else {
			this.gender = gender;
		}
	}

	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(int year, int month, int day) {
		this.dateOfBirth = LocalDate.of(year, month, day);
	}
	
	@Override
	public String toString() {
		return "\nPatient Id: " + super.getId() +
				super.toString() +
				"\nGender: " + gender +
				"\nDate of Birth: " + dateOfBirth;
	}
	
}
