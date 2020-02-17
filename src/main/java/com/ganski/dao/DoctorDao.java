package com.ganski.dao;

import com.ganski.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorDao extends JpaRepository<Doctor, Integer> {

    Doctor findByMedicalNumber(String medicalNumber);
}
