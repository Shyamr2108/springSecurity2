package com.masai.main.Service;

import com.masai.main.Config.EmployeeUser;
import com.masai.main.Entiyt.Employee;
import com.masai.main.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements UserDetailsService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee=employeeRepository.findByUserName(username);
        if(employee==null){
            throw new UsernameNotFoundException("user not there in DB");
        }
        return new EmployeeUser(employee);
    }
}
