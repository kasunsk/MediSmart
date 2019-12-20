package com.company.medismart.channel.model;

import com.company.medismart.core.model.AbstractTrackableEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PATIENT")
public class PatientModel {

    @Id
    @Column(name = "NIC", nullable = false)
    private String nic;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "DATE_OF_BIRTH", nullable = false)
    private String dateOfBirth;

    @Column(name = "DIABETES", nullable = false)
    private Boolean diabetes;

    @Column(name = "BLOOD_PRESSURE", nullable = false)
    private Boolean bloodPressure;

    @Column(name = "CHOLESTEROL", nullable = false)
    private Boolean cholesterol;

    @Column(name = "ALLERGY", nullable = false)
    private Boolean allergy;

    @Column(name = "NOTES", nullable = false)
    private String specialNote;

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(Boolean diabetes) {
        this.diabetes = diabetes;
    }

    public Boolean getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(Boolean bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public Boolean getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(Boolean cholesterol) {
        this.cholesterol = cholesterol;
    }

    public Boolean getAllergy() {
        return allergy;
    }

    public void setAllergy(Boolean allergy) {
        this.allergy = allergy;
    }

    public String getSpecialNote() {
        return specialNote;
    }

    public void setSpecialNote(String specialNote) {
        this.specialNote = specialNote;
    }
}
