package ca.sheridancollege.vutran.beans;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Builder
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String name;
	
	@OneToOne
	@JoinTable(
		name="STUDENT_ACCOUNT", 
		joinColumns = @JoinColumn(name="STUDENT_ID"),
		inverseJoinColumns=@JoinColumn(name="ACCOUNT_ID")
	)
	private Account account;
	
	@OneToMany
	private List<Vehicle> vehicleList;
}
