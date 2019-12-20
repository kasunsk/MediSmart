package com.company.medismart.channel.adaptor;

import com.company.medismart.channel.dto.Patient;
import com.company.medismart.channel.model.PatientModel;
import com.company.medismart.core.adaptor.AbstractModelAdaptor;
import com.company.medismart.core.utils.DateUtils;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class PatientAdaptor extends AbstractModelAdaptor<PatientModel, Patient> {

    public PatientAdaptor() {
        super(PatientModel.class, Patient.class);
    }

    @Override
    public Patient fromModel(PatientModel document) {
        Patient patient = super.fromModel(document);
        patient.setCreatedDate(DateUtils.toSimpleDate(document.getCreatedDate()));
        patient.setLastModifiedDate(DateUtils.toSimpleDate(document.getLastModifiedDate()));
        return patient;
    }

    @Override
    public PatientModel fromDto(Patient patient) {
        return super.fromDto(patient);
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
