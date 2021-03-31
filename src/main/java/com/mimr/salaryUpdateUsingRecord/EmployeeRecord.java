package com.mimr.salaryUpdateUsingRecord;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

public record EmployeeRecord(String id, String name, double salary, String employerId) {
    public EmployeeRecord{
        id = StringUtils.isEmpty(id) ? UUID.randomUUID().toString() : id;
    }
}
record EmployerSalaryUpdateRecord(String employerId, double increment){}
