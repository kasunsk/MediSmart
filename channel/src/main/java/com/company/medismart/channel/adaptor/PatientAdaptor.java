package com.company.medismart.channel.adaptor;

import com.company.medismart.channel.dto.Patient;
import com.company.medismart.channel.model.PatientModel;
import com.company.medismart.core.adaptor.AbstractModelAdaptor;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class PatientAdaptor extends AbstractModelAdaptor<PatientModel, Patient> {

    public PatientAdaptor() {
        super(PatientModel.class, Patient.class);
    }

    @Override
    protected PropertyMap<PatientModel, Patient> fromModelMappings() {
        return new PropertyMap<PatientModel, Patient>() {
            @Override
            protected void configure() {
            }
        };
    }

    @Override
    protected PropertyMap<Patient, PatientModel> fromDtoMappings() {
        return new PropertyMap<Patient, PatientModel>() {
            @Override
            protected void configure() {
            }
        };
    }
}
