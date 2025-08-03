package com.blazerodrigues.devops.repo;

import com.blazerodrigues.devops.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
