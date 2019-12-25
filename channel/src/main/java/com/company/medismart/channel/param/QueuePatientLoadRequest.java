package com.company.medismart.channel.param;

import org.springframework.data.domain.Sort;

public class QueuePatientLoadRequest extends PageableSupport {
    private Long queueId;
    private Sort sort;

    public Long getQueueId() {
        return queueId;
    }

    public void setQueueId(Long queueId) {
        this.queueId = queueId;
    }

    @Override
    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }
}
