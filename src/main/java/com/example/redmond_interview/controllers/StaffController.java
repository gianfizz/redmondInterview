package com.example.redmond_interview.controllers;

import com.example.redmond_interview.models.StaffModel;
import com.example.redmond_interview.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/staffMembers")
    public List<StaffModel> getStaff() {
        return staffService.getStaff();
    }

    @GetMapping("/staffMember/{name}")
    public StaffModel getStaffMember(@PathVariable String name) {
        return staffService.getSingleStaff(name);
    }

    @GetMapping("/calculateSalary/{name}")
    public String calculateStaffSalary(@PathVariable String name) {
        HashMap<Integer, Integer> amountOfBills = staffService.getAmountOfBills(name);

        return "You have " + amountOfBills.get(100) + " bills of 100$, " + amountOfBills.get(50) + " bills of 50$, " + amountOfBills.get(20) + " bills of 20$, "
                + amountOfBills.get(10) + " bills of 10$, " + amountOfBills.get(5) + " bills of 5$, " + amountOfBills.get(2) + " bills of 2$, "
                + amountOfBills.get(1) + " bills of 1$";
    }

    @PostMapping("/staff")
    public StaffModel createStaffMember(@RequestBody StaffModel staff) {
        staffService.createStaffMember(staff);
        return staff;
    }

    @PutMapping("/editStaffMember/{file}")
    public StaffModel editStaffMember(@PathVariable Long file,
                                      @RequestParam("name") String newName,
                                      @RequestParam("salary") Double newSalary) {
        StaffModel staff = staffService.getSingleStaff(file);
        staff.setName(newName);
        staff.setSalary(newSalary);
        return staff;
    }

    @DeleteMapping("/deleteStaff/{file}")
    public void deleteStaff(@PathVariable Long file) {
        staffService.deleteClient(file);
    }

}
