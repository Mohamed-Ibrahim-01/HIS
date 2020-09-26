package models;

public class Prescription {
    private Medication[] Medications;
    private String date;
    private Patient Patient;
    private Doctor Doctor ;
    private int duration;

    public Prescription(){
    }

    public Prescription(Medication[] medications, String date, Patient patient, Doctor doctor, int duration) {
        Medications = medications;
        this.date = date;
        Patient = patient;
        Doctor = doctor;
        this.duration = duration;
    }

    public Medication[] getMedications() {
        return Medications;
    }

    public void setMedications(Medication[] medications) {
        Medications = medications;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Patient getPatient() {
        return Patient;
    }

    public void setPatient(Patient patient) {
        Patient = patient;
    }

    public Doctor getDoctor() {
        return Doctor;
    }

    public void setDoctor(Doctor doctor) {
        Doctor = doctor;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    public void showDetails(){
        


    }
    
}