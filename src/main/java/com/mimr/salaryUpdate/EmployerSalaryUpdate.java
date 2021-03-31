package com.mimr.salaryUpdate;

public class EmployerSalaryUpdate {
    private final String employerId;
    private final double salaryIncrement;

    public EmployerSalaryUpdate(String employerId, double salaryIncrement) {
        this.employerId = employerId;
        this.salaryIncrement = salaryIncrement;
    }

    public String getEmployerId() {
        return employerId;
    }

    public double getSalaryIncrement() {
        return salaryIncrement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployerSalaryUpdate that = (EmployerSalaryUpdate) o;

        if (Double.compare(that.salaryIncrement, salaryIncrement) != 0) return false;
        return employerId != null ? employerId.equals(that.employerId) : that.employerId == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = employerId != null ? employerId.hashCode() : 0;
        temp = Double.doubleToLongBits(salaryIncrement);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "EmployerSalaryUpdate{" +
                "employerId='" + employerId + '\'' +
                ", salaryIncrement=" + salaryIncrement +
                '}';
    }
}
