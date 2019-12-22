package com.company.medismart.channel.adaptor;

import com.company.medismart.channel.dto.QueuePatient;
import com.company.medismart.channel.model.QueuePatientModel;
import com.company.medismart.core.adaptor.AbstractModelAdaptor;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class QueuePatientAdaptor extends AbstractModelAdaptor<QueuePatientModel, QueuePatient> {

    public QueuePatientAdaptor() {
        super(QueuePatientModel.class, QueuePatient.class);
    }

    @Override
    protected PropertyMap<QueuePatientModel, QueuePatient> fromModelMappings() {
        return new PropertyMap<QueuePatientModel, QueuePatient>() {
            @Override
            protected void configure() {

            }
        };
    }

    @Override
    protected PropertyMap<QueuePatient, QueuePatientModel> fromDtoMappings() {
        return new PropertyMap<QueuePatient, QueuePatientModel>() {
            @Override
            protected void configure() {

            }
        };
    }
}
