package com.masai.main.Controller;

import com.masai.main.Entiyt.Employee;
import com.masai.main.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/masai")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/user")
    public ResponseEntity<String> commonResource()
    {
        String msg = "Welcome user..! It's a non-secured resource";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
    @GetMapping("/secure/user")
    public ResponseEntity<String> securedResource() {
        String msg = "It's a secured resource";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<String> admin() {
        return new ResponseEntity<>("Welcome to Masai App for Admin", HttpStatus.ACCEPTED);
    }

    @PostMapping("/register")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


}
