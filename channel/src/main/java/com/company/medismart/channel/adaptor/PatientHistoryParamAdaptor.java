package com.company.medismart.channel.adaptor;

import com.company.medismart.channel.dto.PatientHistory;
import com.company.medismart.channel.param.PatientHistoryParam;
import com.company.medismart.core.adaptor.AbstractParamAdaptor;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class PatientHistoryParamAdaptor extends AbstractParamAdaptor<PatientHistoryParam, PatientHistory> {
    public PatientHistoryParamAdaptor() {
        super(PatientHistoryParam.class, PatientHistory.class);
    }

    @Override
    protected PropertyMap<PatientHistoryParam, PatientHistory> fromParamMappings() {
        return new PropertyMap<PatientHistoryParam, PatientHistory>() {
            @Override
            protected void configure() {

            }
        };
    }

    @Override
    protected PropertyMap<PatientHistory, PatientHistoryParam> fromDtoMappings() {
        return new PropertyMap<PatientHistory, PatientHistoryParam>() {
            @Override
            protected void configure() {

            }
        };
    }
}
