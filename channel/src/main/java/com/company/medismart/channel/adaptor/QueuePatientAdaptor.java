package com.company.medismart.channel.adaptor;

import com.company.medismart.channel.dto.Patient;
import com.company.medismart.channel.dto.QueuePatient;
import com.company.medismart.channel.model.PatientModel;
import com.company.medismart.channel.model.QueuePatientModel;
import com.company.medismart.core.adaptor.AbstractModelAdaptor;
import org.modelmapper.PropertyMap;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.function.Function;

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

    public Page<QueuePatient> fromModelPage(Page<QueuePatientModel> modelPage) {
        Page<QueuePatient> dtoPage = modelPage.map(new Function<QueuePatientModel, QueuePatient>() {
            @Override
            public QueuePatient apply(QueuePatientModel entity) {
                return fromModel(entity);
            }
        });
        return dtoPage;
    }
}
