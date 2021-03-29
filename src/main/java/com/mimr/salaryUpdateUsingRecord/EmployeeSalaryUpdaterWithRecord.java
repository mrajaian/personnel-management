package com.mimr.salaryUpdateUsingRecord;


import com.google.common.annotations.VisibleForTesting;
import com.mimr.EmployeeUtil;
import com.mimr.salaryUpdate.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSalaryUpdaterWithRecord {

    private final List<EmployeeRecord> employees = new ArrayList<>();


    public void computeAndUpdateSalaryIncrement(List<EmployerSalaryUpdateRecord> employerSalaryUpdates) {
        record LocalMapper(String employerId, double increment, Employee employee){}

        employerSalaryUpdates
                .stream()
                .<LocalMapper>mapMulti(
                        (employerSalaryUpdate, consumer) ->
                                EmployeeUtil.getEmployeesByEmployerId(employerSalaryUpdate.id())
                                        .forEach(employee ->
                                                consumer.accept(new LocalMapper(
                                                        employerSalaryUpdate.id(),
                                                        employerSalaryUpdate.increment(),
                                                        employee))))
                .map(t-> new EmployeeRecord(t.employee().getId(), t.employee().getName(), t.increment() * t.employee().getSalary() + t.employee().getSalary(), t.employerId()))
                .forEach(employees::add);
    }

    @VisibleForTesting
    public List<EmployeeRecord> getUpdatedEmployees(){
        return employees;
    }

}
