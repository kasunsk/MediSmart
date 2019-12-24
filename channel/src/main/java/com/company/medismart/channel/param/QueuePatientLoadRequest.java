package com.company.medismart.channel.param;

public class QueuePatientLoadRequest extends PageableSupport {
    private Long queueId;

    public Long getQueueId() {
        return queueId;
    }

    public void setQueueId(Long queueId) {
        this.queueId = queueId;
    }
}
