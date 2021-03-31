package com.mimr.salaryUpdate;


import com.mimr.EmployeeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeSalaryUpdater {

    public List<Employee> computeAndUpdateSalaryIncrement(List<EmployerSalaryUpdate> employerSalaryUpdates) {
        return employerSalaryUpdates
                .stream()
                .<InnerClassMapper>mapMulti(
                        (employerSalaryUpdate, consumer) ->
                                EmployeeUtil.getEmployeesByEmployerId(employerSalaryUpdate.getEmployerId())
                                        .forEach(employee ->
                                                consumer.accept(new InnerClassMapper(
                                                        employerSalaryUpdate.getEmployerId(),
                                                        employerSalaryUpdate.getSalaryIncrement(),
                                                        employee))))
                .map(t-> new Employee(t.getEmployee().getId(), t.getEmployee().getName(), t.getSalaryIncrement() * t.getEmployee().getSalary() + t.getEmployee().getSalary(), t.getEmployerId()))
                //More processing steps
                .collect(Collectors.toList());
    }

    static class InnerClassMapper {
        private final String employerId;
        private final double salaryIncrement;
        private final Employee employee;

        InnerClassMapper(String employerId, double salaryIncrement, Employee employee) {
            this.employerId = employerId;
            this.salaryIncrement = salaryIncrement;
            this.employee = employee;
        }

        public String getEmployerId() {
            return employerId;
        }

        public Employee getEmployee() {
            return employee;
        }

        public double getSalaryIncrement() {
            return salaryIncrement;
        }
    }

}
