package com.company.medismart.channel.controller;

import com.company.medismart.channel.adaptor.PatientHistoryParamAdaptor;
import com.company.medismart.channel.dto.Patient;
import com.company.medismart.channel.dto.PatientHistory;
import com.company.medismart.channel.param.PageableSupport;
import com.company.medismart.channel.param.PatientHistoryLoadRequest;
import com.company.medismart.channel.param.PatientHistoryParam;
import com.company.medismart.channel.service.PatientHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient/history")
public class PatientHistoryController {

    @Autowired
    private PatientHistoryService patientHistoryService;

    @Autowired
    private PatientHistoryParamAdaptor patientHistoryParamAdaptor;

    @RequestMapping(method = RequestMethod.POST)
    public Page<PatientHistoryParam> loadAllPatientHistory(@RequestBody PatientHistoryLoadRequest request) {
        Page<PatientHistory> patientHistories =  patientHistoryService.loadPatientHistories(request);
        return patientHistoryParamAdaptor.fromDtoPage(patientHistories);
    }
}
