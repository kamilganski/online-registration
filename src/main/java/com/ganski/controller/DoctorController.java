package com.ganski.controller;

import com.ganski.dao.DoctorDao;
import com.ganski.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DoctorController {

    @Autowired
    private DoctorDao doctorDao;

    @RequestMapping(value = "/doctors", method = RequestMethod.GET)
    public List<Doctor> getAllDoctors() {
        return doctorDao.findAll();
    }

    @RequestMapping(value = "/doctors/{id}", method = RequestMethod.GET)
    public Doctor getDoctorById(@PathVariable int id) {
        return doctorDao.findById(id).get();
    }

    @RequestMapping(value = "/doctors/{medicalNumber}", method = RequestMethod.GET)
    public Doctor getDoctorByMedicalNumber(@PathVariable String medicalNumber) {
        return doctorDao.findByMedicalNumber(medicalNumber);
    }

    @RequestMapping(value = "/doctor", method = RequestMethod.POST)
    public Doctor create(@RequestBody Doctor doctor) {
        return doctorDao.save(doctor);
    }

    @RequestMapping(value = "/doctor/{id}", method = RequestMethod.PUT)
    public Doctor update(@PathVariable int id, @RequestBody Doctor doctor) {
        Doctor doctorToUpdate = getDoctorById(id);

        if (!doctor.getMedicalTitle().isEmpty()) {
            doctorToUpdate.setMedicalTitle(doctor.getMedicalTitle());
        }

        return doctorDao.save(doctorToUpdate);
    }

    @RequestMapping(value = "/doctor/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable int id) {
        doctorDao.deleteById(id);
        return true;
    }
}
