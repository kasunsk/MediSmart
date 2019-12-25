package com.company.medismart.channel.adaptor;

import com.company.medismart.channel.dto.PatientHistory;
import com.company.medismart.channel.model.PatientHistoryModel;
import com.company.medismart.core.adaptor.AbstractModelAdaptor;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;


@Component
public class PatientHistoryModelAdaptor extends AbstractModelAdaptor<PatientHistoryModel, PatientHistory> {
    public PatientHistoryModelAdaptor() {
        super(PatientHistoryModel.class, PatientHistory.class);
    }

    @Override
    protected PropertyMap<PatientHistoryModel, PatientHistory> fromModelMappings() {
        return new PropertyMap<PatientHistoryModel, PatientHistory>() {
            @Override
            protected void configure() {

            }
        };
    }

    @Override
    protected PropertyMap<PatientHistory, PatientHistoryModel> fromDtoMappings() {
        return new PropertyMap<PatientHistory, PatientHistoryModel>() {
            @Override
            protected void configure() {

            }
        };
    }
}
