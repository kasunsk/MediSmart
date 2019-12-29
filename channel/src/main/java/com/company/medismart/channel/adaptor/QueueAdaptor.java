package com.company.medismart.channel.adaptor;

import com.company.medismart.channel.dto.Queue;
import com.company.medismart.channel.model.QueueModel;
import com.company.medismart.core.adaptor.AbstractModelAdaptor;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class QueueAdaptor extends AbstractModelAdaptor<QueueModel, Queue> {

    @Autowired
    private QueuePatientAdaptor queuePatientAdaptor;

    public QueueAdaptor() {
        super(QueueModel.class, Queue.class);
    }

    @Override
    public Queue fromModel(QueueModel document) {
        Queue queue = super.fromModel(document);
        queue.setPatients(queuePatientAdaptor.fromModelList(document.getPatients()));
        return queue;
    }

    @Override
    public QueueModel fromDto(Queue queue) {
        QueueModel queueModel = super.fromDto(queue);
        queueModel.setPatients(queuePatientAdaptor.fromDtoList(queue.getPatients()));
        return queueModel;
    }

    @Override
    protected PropertyMap<QueueModel, Queue> fromModelMappings() {
        return new PropertyMap<QueueModel, Queue>() {
            @Override
            protected void configure() {

            }
        };
    }

    @Override
    protected PropertyMap<Queue, QueueModel> fromDtoMappings() {
        return new PropertyMap<Queue, QueueModel>() {
            @Override
            protected void configure() {

            }
        };
    }

    public Page<Queue> fromModelPage(Page<QueueModel> modelPage) {
        Page<Queue> dtoPage = modelPage.map(new Function<QueueModel, Queue>() {
            @Override
            public Queue apply(QueueModel entity) {
                return fromModel(entity);
            }
        });
        return dtoPage;
    }
}
