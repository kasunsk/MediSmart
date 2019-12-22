package com.company.medismart.channel.adaptor;

import com.company.medismart.channel.dto.Queue;
import com.company.medismart.channel.model.QueModel;
import com.company.medismart.core.adaptor.AbstractModelAdaptor;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueAdaptor extends AbstractModelAdaptor<QueModel, Queue> {

    @Autowired
    private QueuePatientAdaptor queuePatientAdaptor;

    public QueueAdaptor() {
        super(QueModel.class, Queue.class);
    }

    @Override
    public Queue fromModel(QueModel document) {
        Queue queue = super.fromModel(document);
        queue.setPatients(queuePatientAdaptor.fromModelList(document.getPatients()));
        return queue;
    }

    @Override
    public QueModel fromDto(Queue queue) {
        QueModel queModel = super.fromDto(queue);
        queModel.setPatients(queuePatientAdaptor.fromDtoList(queue.getPatients()));
        return queModel;
    }

    @Override
    protected PropertyMap<QueModel, Queue> fromModelMappings() {
        return new PropertyMap<QueModel, Queue>() {
            @Override
            protected void configure() {

            }
        };
    }

    @Override
    protected PropertyMap<Queue, QueModel> fromDtoMappings() {
        return new PropertyMap<Queue, QueModel>() {
            @Override
            protected void configure() {

            }
        };
    }
}
