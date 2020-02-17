package com.ganski.controller;

import com.ganski.dao.DoctorDao;
import com.ganski.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    private DoctorDao doctorDao;

    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return doctorDao.findAll();
    }

    @GetMapping("/doctors/{id}")
    public Doctor getDoctorById(@PathVariable int id) {
        return doctorDao.findById(id).get();
    }

    @GetMapping("/doctors/medical_number")
    public Doctor getDoctorByMedicalNumber(@PathVariable String medicalNumber) {
        return doctorDao.findByMedicalNumber(medicalNumber);
    }

    @PostMapping("/doctor")
    public Doctor create(@RequestBody Doctor doctor) {
        return doctorDao.save(doctor);
    }

    @PutMapping("/doctor/{id}")
    public Doctor update(@PathVariable int id, @RequestBody Doctor doctor) {
        Doctor doctorToUpdate = getDoctorById(id);

        if (!doctor.getMedicalTitle().isEmpty()) {
            doctorToUpdate.setMedicalTitle(doctor.getMedicalTitle());
        }

        return doctorDao.save(doctorToUpdate);
    }

    @DeleteMapping("/doctor/{id}")
    public boolean delete(@PathVariable int id) {
        doctorDao.deleteById(id);
        return true;
    }
}
