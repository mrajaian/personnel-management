package com.mimr.salaryUpdate;

import com.mimr.EmployeeUtil;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSalaryUpdaterWithForLoop {
    private final List<Employee> employees = new ArrayList<>();

    public void computeAndUpdateSalaryIncrement(List<EmployerSalaryUpdate> employerSalaryUpdates) {
        for(EmployerSalaryUpdate employerSalaryUpdate: employerSalaryUpdates){
            for(Employee employee: EmployeeUtil.getEmployeesByEmployerId(employerSalaryUpdate.getEmployerId())){
                employees.add(new Employee(employee.getId(), employee.getName(),
                        employerSalaryUpdate.getSalaryIncrement() * employee.getSalary() + employee.getSalary(), employee.getEmployerId()));
            }
        }
    }
    }
