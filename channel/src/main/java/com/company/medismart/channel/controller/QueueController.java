package com.company.medismart.channel.controller;

import com.company.medismart.channel.dto.Patient;
import com.company.medismart.channel.dto.Queue;
import com.company.medismart.channel.dto.QueuePatient;
import com.company.medismart.channel.param.PatientAddToQueParam;
import com.company.medismart.channel.param.QueCreateParam;
import com.company.medismart.channel.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/queue")
public class QueueController {

    @Autowired
    private QueueService queueService;

    @RequestMapping(method = RequestMethod.PUT)
    private Queue createQue(@RequestBody QueCreateParam queCreateParam) {
        return queueService.createQue(queCreateParam.getDoctorUserId());
    }

    @RequestMapping(value = "/addPatient", method = RequestMethod.POST)
    private Integer addPatientToQue(@RequestBody PatientAddToQueParam patientAddToQueParam) {
        return queueService.addPatientToQueue(patientAddToQueParam.getQueId(), patientAddToQueParam.getPatientId());
    }

    @RequestMapping(value = "/{queId}", method = RequestMethod.GET)
    public List<QueuePatient> getPatientByNIC(@PathVariable("queId") Long queId){
        return queueService.loadAllQuePatients(queId);
    }

}
