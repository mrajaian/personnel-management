package com.mimr.salaryUpdate;

public class EmployerSalaryUpdate {
    private final String id;
    private final double salaryIncrement;

    public EmployerSalaryUpdate(String id, double salaryIncrement) {
        this.id = id;
        this.salaryIncrement = salaryIncrement;
    }

    public String getId() {
        return id;
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
        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        temp = Double.doubleToLongBits(salaryIncrement);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "EmployerSalaryUpdate{" +
                "id='" + id + '\'' +
                ", salaryIncrement=" + salaryIncrement +
                '}';
    }
}
