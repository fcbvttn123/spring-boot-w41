package ca.sheridancollege.vutran.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.vutran.beans.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Long> {

}
