package com.mimr.salaryUpdate;


import com.google.common.annotations.VisibleForTesting;
import com.mimr.EmployeeUtil;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSalaryUpdater {

    private final List<Employee> employees = new ArrayList<>();

    public void computeAndUpdateSalaryIncrement(List<EmployerSalaryUpdate> employerSalaryUpdates) {
        employerSalaryUpdates
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
                .forEach(employees::add);
    }

    @VisibleForTesting
    public List<Employee> getUpdatedEmployees(){
        return employees;
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
