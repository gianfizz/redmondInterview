package com.example.redmond_interview.services;

import com.example.redmond_interview.SalaryCalculator;
import com.example.redmond_interview.models.StaffModel;
import com.example.redmond_interview.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private SalaryCalculator salaryCalculator;

    public List<StaffModel> getStaff() {
        List<StaffModel> staff = staffRepository.findAll();
        return staff;
    }

    public StaffModel getSingleStaff(String name) {
        StaffModel staff = staffRepository.findByName(name);
        return staff;
    }

    public StaffModel getSingleStaff(Long file) {
        StaffModel staff = staffRepository.findById(file).orElse(null);
        return staff;
    }

    public void createStaffMember(StaffModel staff) {
        staffRepository.save(staff);
    }

    public HashMap<Integer, Integer> getAmountOfBills(String name) {
        StaffModel staff = staffRepository.findByName(name);
        HashMap<Integer, Integer> amountOfBillsForSalary = salaryCalculator.calculateStaffSalary(staff);
        return amountOfBillsForSalary;
    }

    public void deleteClient(Long file) {
        staffRepository.deleteById(file);
    }

}
