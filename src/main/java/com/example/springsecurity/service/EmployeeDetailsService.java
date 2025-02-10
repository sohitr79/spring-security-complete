package com.example.springsecurity.service;


import com.example.springsecurity.entity.Employee;
import com.example.springsecurity.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDetailsService implements UserDetailsService {

//    @Autowired
//    EmployeeRepository employeeRepository;

    private final EmployeeRepository employeeRepository;

    @Autowired  // Constructor injection ensures correct order and avoid circular dependency
    public EmployeeDetailsService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByName(username)
                .orElseThrow(()->new UsernameNotFoundException("UserName not found: "+username));

        UserDetails userDetails = User.withUsername(employee.getName())
                .password(employee.getPassword())
                .roles("Admin","User") // for now we are adding as constant once we do role based auth will fix this
                .build();
        return userDetails;
    }
}
