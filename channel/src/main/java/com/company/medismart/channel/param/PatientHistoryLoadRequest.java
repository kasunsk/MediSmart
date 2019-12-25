package com.company.medismart.channel.param;

import org.springframework.data.domain.Sort;

public class PatientHistoryLoadRequest extends PageableSupport {

    private String patientNic;
    private Sort sort;

    @Override
    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public String getPatientNic() {
        return patientNic;
    }

    public void setPatientNic(String patientNic) {
        this.patientNic = patientNic;
    }
}
