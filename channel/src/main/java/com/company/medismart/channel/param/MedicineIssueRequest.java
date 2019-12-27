package com.company.medismart.channel.param;

import com.company.medismart.channel.dto.PatientHistory;

public class MedicineIssueRequest {

    private Long queueId;
    private PatientHistory record;

    public Long getQueueId() {
        return queueId;
    }

    public void setQueueId(Long queueId) {
        this.queueId = queueId;
    }

    public PatientHistory getRecord() {
        return record;
    }

    public void setRecord(PatientHistory record) {
        this.record = record;
    }
}
