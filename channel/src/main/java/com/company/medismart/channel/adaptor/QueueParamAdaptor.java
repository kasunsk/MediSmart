package com.company.medismart.channel.adaptor;

import com.company.medismart.channel.dto.Queue;
import com.company.medismart.channel.param.QueueResponseParam;
import com.company.medismart.core.adaptor.AbstractParamAdaptor;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueParamAdaptor extends AbstractParamAdaptor<QueueResponseParam, Queue> {

    @Autowired
    private QueuePatientParamAdaptor queuePatientParamAdaptor;

    public QueueParamAdaptor() {
        super(QueueResponseParam.class, Queue.class);
    }

    @Override
    public Queue fromParam(QueueResponseParam document) {
        return super.fromParam(document);
    }

    @Override
    public QueueResponseParam fromDto(Queue queue) {
        QueueResponseParam queueResponseParam = super.fromDto(queue);
        queueResponseParam.setPatients(queuePatientParamAdaptor.fromDtoList(queue.getPatients()));
        return queueResponseParam;
    }

    @Override
    protected PropertyMap<QueueResponseParam, Queue> fromParamMappings() {
        return new PropertyMap<QueueResponseParam, Queue>() {
            @Override
            protected void configure() {

            }
        };
    }

    @Override
    protected PropertyMap<Queue, QueueResponseParam> fromDtoMappings() {
        return new PropertyMap<Queue, QueueResponseParam>() {
            @Override
            protected void configure() {

            }
        };
    }
}
