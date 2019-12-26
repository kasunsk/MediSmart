package com.company.medismart.channel.util;

import com.company.medismart.channel.dto.PatientMedicineRecord;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class PatientMedicineRecordUtil {

    public static String convertMedicineRecordsToString(List<PatientMedicineRecord> medicineRecord) {
        StringBuilder records = new StringBuilder("&");
        medicineRecord.forEach(record -> records.append(record.toString()));
        return records.toString();
    }

    public static List<PatientMedicineRecord> convertMedicineRecordStringToList(String patentMedicineRecordString){
        List<PatientMedicineRecord> medicineRecords = new ArrayList<>();
        Gson gson = new Gson();
        String [] records = patentMedicineRecordString.split("&");
        for (int i = 1; i < records.length; i++) {
            PatientMedicineRecord record = gson.fromJson(records[i] ,PatientMedicineRecord.class);
            medicineRecords.add(record);
        }
        return medicineRecords;
    }
}
