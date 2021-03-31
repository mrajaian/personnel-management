package com.mimr.salaryUpdate;

import com.mimr.salaryUpdate.EmployeeSalaryUpdater;
import com.mimr.salaryUpdate.EmployerSalaryUpdate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SalaryUpdateTest {

    @Test
    public void test(){

        EmployeeSalaryUpdater employeeSalaryUpdater = new EmployeeSalaryUpdater();
        List<Employee> UpdatedEmployees = employeeSalaryUpdater.computeAndUpdateSalaryIncrement(
                List.of(new EmployerSalaryUpdate("id1", 0.12),
                        new EmployerSalaryUpdate("id2", 0.05)));
        Assertions.assertEquals(UpdatedEmployees.size(), 4);
        UpdatedEmployees
                .forEach(employee -> Assertions.assertTrue(employee.getSalary()!=1000));
    }
}
