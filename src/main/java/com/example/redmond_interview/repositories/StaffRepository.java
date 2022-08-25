package com.example.redmond_interview.repositories;

import com.example.redmond_interview.models.StaffModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<StaffModel, Long> {

    StaffModel findByName(String name);

}
