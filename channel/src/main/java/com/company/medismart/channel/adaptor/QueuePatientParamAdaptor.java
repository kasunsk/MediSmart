package com.company.medismart.channel.adaptor;

import com.company.medismart.channel.dto.Queue;
import com.company.medismart.channel.dto.QueuePatient;
import com.company.medismart.channel.model.QueuePatientModel;
import com.company.medismart.channel.param.QueuePatientResponseParam;
import com.company.medismart.core.adaptor.AbstractParamAdaptor;
import org.modelmapper.PropertyMap;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class QueuePatientParamAdaptor extends AbstractParamAdaptor<QueuePatientResponseParam, QueuePatient> {

    public QueuePatientParamAdaptor() {
        super(QueuePatientResponseParam.class, QueuePatient.class);
    }

    @Override
    public QueuePatient fromParam(QueuePatientResponseParam document) {
        QueuePatient queuePatient = super.fromParam(document);
        Queue queue = new Queue();
        queue.setQueueId(document.getQueueId());
        queuePatient.setQueueId(queue);
        return queuePatient;
    }

    @Override
    public QueuePatientResponseParam fromDto(QueuePatient queuePatient) {
        QueuePatientResponseParam responseParam =  super.fromDto(queuePatient);
        responseParam.setQueueId(queuePatient.getQueueId().getQueueId());
        return responseParam;
    }

    @Override
    protected PropertyMap<QueuePatientResponseParam, QueuePatient> fromParamMappings() {
        return new PropertyMap<QueuePatientResponseParam, QueuePatient>() {
            @Override
            protected void configure() {

            }
        };
    }

    @Override
    protected PropertyMap<QueuePatient, QueuePatientResponseParam> fromDtoMappings() {
        return new PropertyMap<QueuePatient, QueuePatientResponseParam>() {
            @Override
            protected void configure() {

            }
        };
    }

    public Page<QueuePatientResponseParam> fromDtoPage(Page<QueuePatient> modelPage) {
        Page<QueuePatientResponseParam> dtoPage = modelPage.map(new Function<QueuePatient, QueuePatientResponseParam>() {
            @Override
            public QueuePatientResponseParam apply(QueuePatient entity) {
                return fromDto(entity);
            }
        });
        return dtoPage;
    }
}
