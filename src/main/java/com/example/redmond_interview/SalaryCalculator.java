package com.example.redmond_interview;

import com.example.redmond_interview.models.StaffModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class SalaryCalculator {

    public HashMap<Integer, Integer> calculateStaffSalary(StaffModel staff) {
        HashMap<Integer, Integer> salaryOnCash = new HashMap<>();
        int salary = staff.getSalary().intValue();
        int[] bills = {100, 50, 20, 10, 5, 2, 1};
        int restSalary;
        for (int bill : bills) {
            int amountOfBills = salary / bill;

            restSalary = salary % bill;
            salaryOnCash.put(bill, amountOfBills);
            salary = restSalary;
        }
        return salaryOnCash;
    }
}
