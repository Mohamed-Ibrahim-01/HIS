package src.models;
import java.util.List;

public class Prescription {
    private List<Medication> Medications;
    private String Date;
    private Patient Patient;
    private Doctor Doctor ;
    private int Duration;

    public Prescription(){
    }

    public Prescription(List<Medication> medications, String date,int duration) {
        Medications = medications;
        Date = date;
        Duration = duration;
    }

    public List<Medication> getMedications() { return Medications; }
    public void setMedications(List<Medication> medications) { Medications = medications; }

    public String getDate() { return Date; }
    public void setDate(String date) { Date = date; } 

    public Patient getPatient() { return Patient; }
    public void setPatient(Patient patient) { Patient = patient; }

    public Doctor getDoctor() { return Doctor; }
    public void setDoctor(Doctor doctor) { Doctor = doctor; }

    public int getDuration() { return Duration; }
    public void setDuration(int duration) { Duration = duration; }

    public void showDetails(){

    }
    
}