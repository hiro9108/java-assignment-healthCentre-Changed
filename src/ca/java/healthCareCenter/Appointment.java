package ca.java.healthCareCenter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Appointment implements Comparable<Appointment>{
	
	private Patient patient;
	private LocalDateTime appointmentDate;
	
	public  Appointment(Patient patient, int year, int month, int day, int hour, int minute) {
		setPatient(patient);
		setAppointmentDate(year, month, day, hour, minute);
	}

	/**
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * @param patient the patient to set
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * @return the appointmentDate
	 */
	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}

	/**
	 * @param appointmentDate the appointmentDate to set
	 */
	public void setAppointmentDate(int year, int month, int day, int hour, int minute) {
		this.appointmentDate = LocalDateTime.of(year, month, day, hour, minute);
	}
	
	@Override
	public String toString() {
		return "\nPatient Name: " + patient.getFirstName() + " " + patient.getLastName() +
				"\nAppointment Date: " + appointmentDate;
	}

	@Override
	public int compareTo(Appointment o) {
		return this.appointmentDate.compareTo(o.appointmentDate);
	}
}
