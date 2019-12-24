package com.company.medismart.channel.adaptor;

import com.company.medismart.channel.dto.Queue;
import com.company.medismart.channel.model.QueModel;
import com.company.medismart.channel.param.QueueResponse;
import com.company.medismart.core.adaptor.AbstractParamAdaptor;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class QueueParamAdaptor extends AbstractParamAdaptor<QueueResponse, Queue> {

    @Autowired
    private QueuePatientParamAdaptor queuePatientParamAdaptor;

    public QueueParamAdaptor() {
        super(QueueResponse.class, Queue.class);
    }

    @Override
    public Queue fromParam(QueueResponse document) {
        return super.fromParam(document);
    }

    @Override
    public QueueResponse fromDto(Queue queue) {
        QueueResponse queueResponse = super.fromDto(queue);
        queueResponse.setPatients(queuePatientParamAdaptor.fromDtoList(queue.getPatients()));
        return queueResponse;
    }

    @Override
    protected PropertyMap<QueueResponse, Queue> fromParamMappings() {
        return new PropertyMap<QueueResponse, Queue>() {
            @Override
            protected void configure() {

            }
        };
    }

    @Override
    protected PropertyMap<Queue, QueueResponse> fromDtoMappings() {
        return new PropertyMap<Queue, QueueResponse>() {
            @Override
            protected void configure() {

            }
        };
    }

    public Page<QueueResponse> fromDtoPage(Page<Queue> modelPage) {
        Page<QueueResponse> dtoPage = modelPage.map(new Function<Queue, QueueResponse>() {
            @Override
            public QueueResponse apply(Queue entity) {
                return fromDto(entity);
            }
        });
        return dtoPage;
    }
}
