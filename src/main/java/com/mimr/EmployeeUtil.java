package com.mimr;

import com.mimr.salaryUpdate.Employee;

import java.util.List;

public class EmployeeUtil {

    public static List<Employee> getEmployeesByEmployerId(String employerId) {
        return List.of(new Employee("employee" + Math.random(), "name", 1000, employerId),
                new Employee("employee" + Math.random(), "name", 1000, employerId));
    }
}
