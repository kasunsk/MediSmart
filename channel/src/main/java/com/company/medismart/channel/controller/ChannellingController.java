package com.company.medismart.channel.controller;

import com.company.medismart.channel.adaptor.PatientAdaptor;
import com.company.medismart.channel.dto.MedicineIssueStatus;
import com.company.medismart.channel.dto.Patient;
import com.company.medismart.channel.param.MedicineIssueRequest;
import com.company.medismart.channel.param.PageableSupport;
import com.company.medismart.channel.service.ChannellingService;
import com.company.medismart.channel.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/channel")
public class ChannellingController {

    @Autowired
    private QueueService queueService;

    @Autowired
    private ChannellingService channellingService;

    @RequestMapping(value = "/next/{queueId}", method = RequestMethod.GET)
    public Patient callNextPatient(@PathVariable("queueId")  Long queueId) {
        return  channellingService.callNextPatient(queueId);
    }

    @RequestMapping(value = "/completeChannelling", method = RequestMethod.POST)
    public Boolean issueMedicineAndCompleteChannellingForPatient(@RequestBody MedicineIssueRequest medicineIssueRequest) {
        channellingService.issueMedicine(medicineIssueRequest);
        return Boolean.TRUE;
    }
}
