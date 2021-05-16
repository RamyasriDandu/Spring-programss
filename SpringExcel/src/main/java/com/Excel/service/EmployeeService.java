package com.Excel.service;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Excel.Dao.EmployeeDao;
import com.Excel.model.Employee;

@Service
public class EmployeeService {

 

    @Autowired
    private EmployeeDao repo;
    
    public List<Employee> saveAll(List<Employee> employees) {
        return repo.saveAll(employees);
    }
}