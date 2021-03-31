package com.mimr.salaryUpdateUsingRecord;


import com.google.common.annotations.VisibleForTesting;
import com.mimr.salaryUpdate.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.mimr.EmployeeUtil.getEmployeesByEmployerId;

public class EmployeeSalaryUpdaterWithRecord {


    public List<EmployeeRecord> computeAndUpdateSalaryIncrement(List<EmployerSalaryUpdateRecord> employerSalaryUpdates) {

        record LocalMapper(String employerId, double increment, Employee employee){}

        return employerSalaryUpdates
                .stream()
                .<LocalMapper>mapMulti(
                        (employerSalaryUpdate, consumer) ->
                                getEmployeesByEmployerId(employerSalaryUpdate.employerId())
                                        .forEach(employee ->
                                                consumer.accept(new LocalMapper(
                                                        employerSalaryUpdate.employerId(),
                                                        employerSalaryUpdate.increment(),
                                                        employee))))
                .map(t-> new EmployeeRecord(t.employee().getId(), t.employee().getName(),
                        t.increment() * t.employee().getSalary() + t.employee().getSalary(), t.employerId()))
                //More processing steps
                .collect(Collectors.toList());
    }

}
