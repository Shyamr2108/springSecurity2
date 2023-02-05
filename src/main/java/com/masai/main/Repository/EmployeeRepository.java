package com.masai.main.Repository;

import com.masai.main.Entiyt.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    public Employee findByUserName(String userName);
}
