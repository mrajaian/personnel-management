package com.mimr.salaryUpdate;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

public class Employee {
    private final String id;
    private final String name;
    private final double salary;
    private final String employerId;

    public Employee(String id, String name, double salary, String employerId) {
        this.id = StringUtils.isEmpty(id) ? UUID.randomUUID().toString() : id;
        this.name = name;
        this.salary = salary;
        this.employerId = employerId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmployerId() {
        return employerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (Double.compare(employee.salary, salary) != 0) return false;
        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        return employerId != null ? employerId.equals(employee.employerId) : employee.employerId == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (employerId != null ? employerId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employerId='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", employerId='" + employerId + '\'' +
                '}';
    }
}
