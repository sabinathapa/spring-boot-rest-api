package com.example.webapi.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

//    public static final List<Employee> employees;

    @Autowired
    EmployeeService employeeService;


    // /greeting?name=Sabina
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(employeeService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {

        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }



    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> add(@RequestBody Employee employee) {
       employeeService.addEmployee(employee);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);

        // return greetings;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

//    private static List<Employee> getAllEmployee() {
//        return employees;
//    }
//

//    static {
//        employees = new ArrayList<>();
//
//        Employee employee1 = new Employee();
//        employee1.setId(1L);
//        employee1.setName("Sabina");
//
//        Employee employee2 = new Employee();
//        employee2.setId(2L);
//        employee2.setName("Urbi");
//
//        employees.add(employee1);
//        employees.add(employee2);
//    }

}



