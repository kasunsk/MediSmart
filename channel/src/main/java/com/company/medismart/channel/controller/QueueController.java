package com.company.medismart.channel.controller;

import com.company.medismart.channel.adaptor.QueueParamAdaptor;
import com.company.medismart.channel.adaptor.QueuePatientParamAdaptor;
import com.company.medismart.channel.dto.Queue;
import com.company.medismart.channel.dto.QueuePatient;
import com.company.medismart.channel.param.*;
import com.company.medismart.channel.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/queue")
public class QueueController {

    @Autowired
    private QueueService queueService;

    @Autowired
    private QueuePatientParamAdaptor queuePatientParamAdaptor;

    @Autowired
    private QueueParamAdaptor queueParamAdaptor;

    @RequestMapping(method = RequestMethod.PUT)
    private Queue createQue(@RequestBody QueCreateParam queCreateParam) {
        return queueService.createQue(queCreateParam.getDoctorUserId());
    }

    @RequestMapping(value = "/addPatient", method = RequestMethod.POST)
    private Integer addPatientToQue(@RequestBody PatientAddToQueParam patientAddToQueParam) {
        return queueService.addPatientToQueue(patientAddToQueParam.getQueId(), patientAddToQueParam.getPatientId());
    }

    @RequestMapping(value = "/patients/{queId}", method = RequestMethod.GET)
    public List<QueuePatient> getPatientsByQueueId(@PathVariable("queId") Long queId){
        return queueService.loadAllQuePatients(queId);
    }

    @RequestMapping(value = "/{queId}", method = RequestMethod.GET)
    public QueueResponse getQueueByQueueId(@PathVariable("queId") Long queId){
        Queue queue = queueService.loadQueById(queId);
        return queueParamAdaptor.fromDto(queue);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Page<QueueResponse> loadAllQueues(@RequestBody PageableSupport pageableSupport){
        Page<Queue> queuePage = queueService.loadAllQue(pageableSupport);
        return queueParamAdaptor.fromDtoPage(queuePage);
    }

    @RequestMapping(value = "/patients" ,method = RequestMethod.POST)
    public Page<QueuePatientResponseParam> loadAllQueuePatients(@RequestBody QueuePatientLoadRequest loadRequest){
        Page<QueuePatient> queuePage = queueService.loadAllQueuePatients(loadRequest);
        return queuePatientParamAdaptor.fromDtoPage(queuePage);
    }

}
