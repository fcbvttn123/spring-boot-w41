package ca.sheridancollege.vutran.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.vutran.beans.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
	public List<Student> findByAccount_IdIsNotNull();
}