package com.company.medismart.channel.adaptor;

import com.company.medismart.channel.dto.PatientMedicine;
import com.company.medismart.channel.model.PatientMedicineModel;
import com.company.medismart.channel.util.PatientMedicineRecordUtil;
import com.company.medismart.core.adaptor.AbstractModelAdaptor;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class PatientMedicineModelAdaptor extends AbstractModelAdaptor<PatientMedicineModel, PatientMedicine> {

    public PatientMedicineModelAdaptor() {
        super(PatientMedicineModel.class, PatientMedicine.class);
    }

    @Override
    public PatientMedicine fromModel(PatientMedicineModel document) {
        PatientMedicine medicine = super.fromModel(document);
        medicine.setPatientMedicineRecord(PatientMedicineRecordUtil.convertMedicineRecordStringToList(document.getPatientMedicineRecord()));
        return medicine;
    }

    @Override
    public PatientMedicineModel fromDto(PatientMedicine patientMedicine) {
        PatientMedicineModel medicineModel = super.fromDto(patientMedicine);
        medicineModel.setPatientMedicineRecord(PatientMedicineRecordUtil.convertMedicineRecordsToString(patientMedicine.getPatientMedicineRecord()));
        return medicineModel;
    }

    @Override
    protected PropertyMap<PatientMedicineModel, PatientMedicine> fromModelMappings() {
        return new PropertyMap<PatientMedicineModel, PatientMedicine>() {
            @Override
            protected void configure() {

            }
        };
    }

    @Override
    protected PropertyMap<PatientMedicine, PatientMedicineModel> fromDtoMappings() {
        return new PropertyMap<PatientMedicine, PatientMedicineModel>() {
            @Override
            protected void configure() {

            }
        };
    }
}
