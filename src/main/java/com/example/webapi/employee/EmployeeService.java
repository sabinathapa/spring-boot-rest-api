package com.example.webapi.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;


    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    public Employee findById(Long id) {
        return employeeDao.findById(id).get();
    }

    public void delete(Long id) {
        employeeDao.delete(findById(id));
    }

    public void addEmployee(Employee employee) {
        employeeDao.saveAndFlush(employee);
    }

    public void updateEmployee(Employee employee) {
        Employee emp = employeeDao.findById(employee.getId()).get();
        emp.setName(employee.getName());
        employeeDao.save(emp);
    }
}
