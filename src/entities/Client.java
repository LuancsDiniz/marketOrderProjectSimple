package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {

	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private String name;
	private String email;
	private String birthDate;
	
	public Client() {
	}

	public Client(String name, String email, String birthDate) {
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
	}
	
	@Override
	public String toString() {
		
		return name + " (" + LocalDate.parse(birthDate, dtf).format(dtf) +") - " + email ;
	}
	
}
