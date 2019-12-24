package com.company.medismart.channel.controller;

import com.company.medismart.channel.dto.Patient;
import com.company.medismart.channel.param.PageableSupport;
import com.company.medismart.channel.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addNewPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Page<Patient> loadAllPatients(@RequestBody PageableSupport pageable) {
        return patientService.loadAll(pageable);
    }

    @RequestMapping(value = "/{nic}", method = RequestMethod.GET)
    public Patient getPatientByNIC(@PathVariable("nic") String nic){
        return patientService.loadPatientByNic(nic);
    }
}
