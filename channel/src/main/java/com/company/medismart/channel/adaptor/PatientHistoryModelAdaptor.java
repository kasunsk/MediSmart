package com.company.medismart.channel.adaptor;

import com.company.medismart.channel.dto.PatientHistory;
import com.company.medismart.channel.model.PatientHistoryModel;
import com.company.medismart.core.adaptor.AbstractModelAdaptor;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PatientHistoryModelAdaptor extends AbstractModelAdaptor<PatientHistoryModel, PatientHistory> {
    public PatientHistoryModelAdaptor() {
        super(PatientHistoryModel.class, PatientHistory.class);
    }

    @Autowired
    private PatientMedicineModelAdaptor medicineModelAdaptor;

    @Override
    public PatientHistory fromModel(PatientHistoryModel document) {
        PatientHistory patientHistory = super.fromModel(document);
        if (document != null && document.getProvidedMedicine() != null) {
            patientHistory.setProvidedMedicine(medicineModelAdaptor.fromModel(document.getProvidedMedicine()));
        }
        return patientHistory;
    }

    @Override
    public PatientHistoryModel fromDto(PatientHistory patientHistory) {
        PatientHistoryModel historyModel = super.fromDto(patientHistory);
        historyModel.setProvidedMedicine(medicineModelAdaptor.fromDto(patientHistory.getProvidedMedicine()));
        return historyModel;
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
