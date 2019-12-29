package com.company.medismart.channel.controller;

import com.company.medismart.channel.dto.Patient;
import com.company.medismart.channel.dto.PatientMedicine;
import com.company.medismart.channel.dto.Queue;
import com.company.medismart.channel.param.MedicineIssueRequest;
import com.company.medismart.channel.param.MedicineLoadRequest;
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
    public Patient callNextPatient(@PathVariable("queueId") Long queueId) {
        return channellingService.callNextPatient(queueId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Page<Queue> loadAllQueue(@RequestBody PageableSupport pageableSupport) {
        return queueService.loadAllQue(pageableSupport);
    }

    @RequestMapping(value = "/completeChannelling", method = RequestMethod.POST)
    public Boolean issueMedicineAndCompleteChannellingForPatient(@RequestBody MedicineIssueRequest medicineIssueRequest) {
        channellingService.completeChannelling(medicineIssueRequest);
        return Boolean.TRUE;
    }

    @RequestMapping(value = "/view", method = RequestMethod.POST)
    public PatientMedicine viewPatientMedicine(@RequestBody MedicineLoadRequest loadRequest) {
        return channellingService.viewQueuePatientMedicine(loadRequest.getQueueId(), loadRequest.getPatientNic());
    }

    @RequestMapping(value = "/issue/medicine", method = RequestMethod.POST)
    public Boolean issueMedicine(@RequestBody MedicineLoadRequest loadRequest) {
        return channellingService.issueMedicine(loadRequest.getQueueId(), loadRequest.getPatientNic());
    }
}
