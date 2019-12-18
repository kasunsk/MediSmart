package com.company.medismart.channel.model;

public class PatientModel {


    private String nic;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private Boolean diabetes;
    private Boolean bloodPressure;
    private Boolean cholesterol;
    private Boolean allergy;
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
