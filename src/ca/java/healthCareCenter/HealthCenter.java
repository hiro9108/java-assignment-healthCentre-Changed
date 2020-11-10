package ca.java.healthCareCenter;

import java.time.format.DateTimeFormatter;

import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HealthCenter {
	
	public static final String DIVIDER = "-------------------------------------------------------------------";
	
	public static User isUserId(ArrayList<User> users, int userId) {
		for (User user : users) {
			if (user instanceof Patient && user.getId() == userId) {
				return user;
			}
			if (user instanceof Doctor && user.getId() == userId) {
				return user;
			}
		}
		return null;
	}
	
	public static Appointment createAppointment(Patient targetPatient) {
		Scanner input = new Scanner(System.in);
		System.out.println("What date is your appointment?");
		System.out.print("year: ");
		int inputYear = input.nextInt();
		System.out.print("month: ");
		int inputMonth = input.nextInt();
		System.out.print("day: ");
		int inputDay = input.nextInt();
		System.out.print("hour: ");
		int inputHour = input.nextInt();
		System.out.print("time: ");
		int inputTime = input.nextInt();
		Appointment newAppointment = new Appointment(targetPatient, inputYear, inputMonth, inputDay, inputHour, inputTime);
		return newAppointment;
	}
	
	public static User askPatientId(ArrayList<User> users, int enteredVal) {
		User targetPatient;
		boolean isPatientNumExist = true;
		do {
			targetPatient = isUserId(users, enteredVal);
			if (targetPatient != null) {
				isPatientNumExist = false;
			} else {
				System.err.println("Patient Number dose not exist");
			}
		} while (isPatientNumExist);
		return targetPatient;
	}
	
	public static User askDoctorId(ArrayList<User> users, int enteredVal) {
		Scanner input = new Scanner(System.in);
		
		if (isUserId(users, enteredVal) instanceof Patient) {
			do {
				System.out.println("Enter your doctor id:");
				enteredVal = input.nextInt();
			} while (!(isUserId(users, enteredVal) instanceof Doctor));
		}
		
		User targetDoctor;
		boolean isDoctorNumExist = true;
		do {
			targetDoctor =  isUserId(users, enteredVal);
			if (targetDoctor != null) {
				isDoctorNumExist = false;
			} else {
				System.err.println("Doctor Number dose not exist");
			}
		} while (isDoctorNumExist);
		return targetDoctor;
	}

	
	public static void printAppointment(Doctor doctor, boolean isDoctor) {
		Collections.sort(doctor.getAppointment());
		for (Appointment appointment : doctor.getAppointment()) {
			if (isDoctor) {
				System.out.println("The data and time of appointment: " + appointment.getAppointmentDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)) +
									" " + appointment.getAppointmentDate().getHour() + ":" +appointment.getAppointmentDate().getMinute() +
									" with " + appointment.getPatient().getFirstName() + " " + appointment.getPatient().getLastName() + " of Patient");
			} else {
				System.out.println("Your Appointment is on " + appointment.getAppointmentDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)) +
									" " + appointment.getAppointmentDate().getHour() + ":" +appointment.getAppointmentDate().getMinute() +
									" with " + doctor.getFirstName() + " " + doctor.getLastName() + " of Doctor");
			}
		}
	}
	
	public static void printUsers(ArrayList<User> users) {
		Collections.sort(users, new UserSorter.CompareByLastName());
		for (User user : users) {
			if (user instanceof Patient) {
				System.out.println("Patient LastName is: " + user.getLastName());
			} else if (user instanceof Doctor) {
				System.out.println("Doctor  LastName is: " + user.getLastName());
			} else {
				System.err.println("Unexpected Error");
			}
		}
	}
	
	

	public static void main(String[] args) {
		
		ArrayList<User> users = new ArrayList<User>();
		
		Patient patient01 = new Patient("Bill", "Sadler", "040 765 1234", "bill@canada.com", "male", 2020, 11, 02);
		Patient patient02 = new Patient("Ammaar", "Allison", "090 765 1234", "ammaar@canada.com", "female", 2020, 01, 03);
		Patient patient03 = new Patient("Arvin", "Stacey", "111 765 1234", "arvin@canada.com", "male", 1999, 01, 05);
		Patient patient04 = new Patient("Elsie", "Mcclure", "234 765 1234", "elsie@canada.com", "female", 1980, 11, 13);
		Patient patient05 = new Patient("Areeb", "Bostock", "321 765 1234", "areeb@canada.com", "male", 2020, 01, 03);
		Patient patient06 = new Patient("Seren", "Griffith", "678 765 1234", "seren@canada.com", "male", 2000, 04, 23);
		Patient patient07 = new Patient("Loretta", "Wang", "434 765 1234", "loretta@canada.com", "female", 2015, 10, 03);
		Patient patient08 = new Patient("Catherine", "Barrow", "323 765 1234", "catherine@canada.com", "male", 2000, 05, 29);
		Patient patient09 = new Patient("Kim", "Everett", "040 787 1234", "kim@canada.com", "male", 1940, 8, 18);
		Patient patient10 = new Patient("Abdallah", "Melia", "890 765 1234", "abdallah@canada.com", "female", 1970, 07, 13);
		
		Doctor doctor01 = new Doctor("Lex", "Rivera", "890 643 4643", "lex@canada.com", "ALLERGY");
		Doctor doctor02 = new Doctor("Mary", "Riley", "367 764 7532", "mary@canada.com", "FAMILY MEDICINE");
		Doctor doctor03 = new Doctor("Joanne", "Kirk", "474 753 1256", "joanne@canada.com", "MEDICAL GENETICS");
		Doctor doctor04 = new Doctor("Eamonn", "Nairn", "437 864 2745", "eamonn@canada.com", "EMERGENCY MEDICINE");
		
		users.add(patient01);
		users.add(patient02);
		users.add(patient03);
		users.add(patient04);
		users.add(patient05);
		users.add(patient06);
		users.add(patient07);
		users.add(patient08);
		users.add(patient09);
		users.add(patient10);
		
		users.add(doctor01);
		users.add(doctor02);
		users.add(doctor03);
		users.add(doctor04);
		
		Appointment appointment01 = new Appointment(patient01, 2020, 12, 29, 13, 30);
		Appointment appointment02 = new Appointment(patient02, 2019, 11, 30, 14, 30);
		Appointment appointment03 = new Appointment(patient03, 2029, 12, 30, 14, 30);
		Appointment appointment04 = new Appointment(patient04, 2025, 10, 10, 14, 30);
		
		doctor01.addAppointment(appointment01);
		doctor01.addAppointment(appointment02);
		doctor01.addAppointment(appointment03);
		doctor01.addAppointment(appointment04);
		
		printUsers(users);
		
		boolean isDoctor = true;
		Scanner input = new Scanner(System.in);
		int enteredVal;
		do {
			System.out.println("\nEnter your id:");
			enteredVal = input.nextInt();
		} while (!(isUserId(users, enteredVal) instanceof User));
		
		if (isUserId(users, enteredVal) instanceof Patient) {
			Patient targetPatient = (Patient) askPatientId(users, enteredVal);
			Appointment newAppointment = createAppointment(targetPatient);
			Doctor targetDoctorForPatient = (Doctor) askDoctorId(users, enteredVal);
			targetDoctorForPatient.addAppointment(newAppointment);
			isDoctor = false;
			
			System.out.println(DIVIDER);
			printAppointment(targetDoctorForPatient, isDoctor);
		} else if (isUserId(users, enteredVal) instanceof Doctor) {
			Doctor targetDoctorForDoctor = (Doctor) askDoctorId(users, enteredVal);
			
			System.out.println(DIVIDER);
			printAppointment(targetDoctorForDoctor, isDoctor);
		} else {
			System.err.println("Unexpected System Error");
		}
	}
}
