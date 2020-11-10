package ca.java.healthCareCenter;

import java.util.ArrayList;

public class Doctor extends User {
	
	private String specialty;
	private ArrayList<Appointment> appointment;
	

	public Doctor(String firstName, String lastName, String phoneNumber, String email, String specialty) {
		super(firstName, lastName, phoneNumber, email);
		setSpecialty(specialty);
		this.appointment = new ArrayList<Appointment>();
	}


	/**
	 * @return the specialty
	 */
	public String getSpecialty() {
		return specialty;
	}

	/**
	 * @param specialty the specialty to set
	 */
	public void setSpecialty(String specialty) {
		if (specialty.isEmpty() || specialty.equalsIgnoreCase(null)) {
			this.specialty = "Unknown";
		} else {
			this.specialty = specialty;
		}
	}
	
	/**
	 * @return the appointment
	 */
	public ArrayList<Appointment> getAppointment() {
		return appointment;
	}
	
	/**
	 * add appointment
	 */
	public void addAppointment(Appointment ap) {
		this.appointment.add(ap);
	}
	
	@Override
	public String toString() {
		return "\nDoctor Id: " + super.getId() +
				super.toString() +
				"\nSpecialty: " + specialty;
	}
	
}
