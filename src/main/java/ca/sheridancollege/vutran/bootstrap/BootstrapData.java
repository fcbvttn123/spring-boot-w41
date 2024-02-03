package ca.sheridancollege.vutran.bootstrap;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.vutran.beans.Account;
import ca.sheridancollege.vutran.beans.AccountStatus;
import ca.sheridancollege.vutran.beans.Student;
import ca.sheridancollege.vutran.beans.Vehicle;
import ca.sheridancollege.vutran.repo.AccountRepo;
import ca.sheridancollege.vutran.repo.StudentRepo;
import ca.sheridancollege.vutran.repo.VehicleRepo;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {
	
	private StudentRepo sr;
	private AccountRepo ar;
	private VehicleRepo vr;

	@Override
	public void run(String... args) throws Exception {

		Student student = Student.builder()
				.name("Paul McCartney")
				.vehicleList(new ArrayList<Vehicle>())
				.build();
		
		Account account = Account.builder()
				.number(1111)
				.balance(new BigDecimal("1200000000.00"))
				.status(AccountStatus.APPROVED)
				.build();
		
		Vehicle vehicle1 = Vehicle.builder()
				.name("Lamborghini 400GT")
				.price(new BigDecimal("175000.00"))
				.build();
		
		Vehicle vehicle2 = Vehicle.builder()
				.name("Ferrari 250GT")
				.price(new BigDecimal("70000000.00"))
				.build();
		
		Vehicle vehicle3 = Vehicle.builder()
				.name("Mercedes-Benz 300 SLR")
				.price(new BigDecimal("142000000.00"))
				.build();
		
		account = ar.save(account);
		
		vehicle1 = vr.save(vehicle1);
		vehicle2 = vr.save(vehicle2);
		vehicle3 = vr.save(vehicle3);
		
		student.getVehicleList().add(vehicle1);
		student.getVehicleList().add(vehicle2);
		student.getVehicleList().add(vehicle3);
		
		student.setAccount(account);
		student = sr.save(student);
	}

}
