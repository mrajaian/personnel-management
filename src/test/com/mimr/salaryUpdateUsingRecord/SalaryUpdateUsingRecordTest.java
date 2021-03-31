package com.mimr.salaryUpdateUsingRecord;

import com.mimr.salaryUpdate.EmployeeSalaryUpdater;
import com.mimr.salaryUpdate.EmployerSalaryUpdate;
import com.mimr.salaryUpdateUsingRecord.EmployeeSalaryUpdaterWithRecord;
import com.mimr.salaryUpdateUsingRecord.EmployerSalaryUpdateRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SalaryUpdateUsingRecordTest {

    @Test
    public void test(){

        EmployeeSalaryUpdaterWithRecord employeeSalaryUpdater = new EmployeeSalaryUpdaterWithRecord();
        List<EmployeeRecord> updatedEmployees = employeeSalaryUpdater.computeAndUpdateSalaryIncrement(
                List.of(new EmployerSalaryUpdateRecord("id1", 0.12),
                        new EmployerSalaryUpdateRecord("id2", 0.05)));
        Assertions.assertEquals(updatedEmployees.size(), 4);
        updatedEmployees
                .forEach(employee -> Assertions.assertTrue(employee.salary()!=1000));
    }
}
