package src.models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public class Patient extends Person {
    private String AdmittanceDate, Complain;
    private MedicalStatus MedicalStatus ;
    private MedicalHistory MedicalHistory ;  
    private HashMap<Doctor,TreatmentData> DoctorsData;
    private HashSet<Medication> Medications ; 

    public Patient(final String[] params){
        super(params);
    }
    public Patient(String name, UUID id, String address, String phone, String birthDate, String sex,String complain ,String admittanceDate){
        super(name,id,address,phone,birthDate,sex);
        this.Complain = complain;
        this.AdmittanceDate = admittanceDate;
        this.Medications = new HashSet<Medication>();
        this.DoctorsData = new HashMap<Doctor,TreatmentData>();
    }

    public String getAdmittanceDate() { return AdmittanceDate; }
    public void setAdmittanceDate(String admittanceDate) { AdmittanceDate = admittanceDate; }

    public MedicalStatus getMedicalStatus() { return MedicalStatus; }
    public void setMedicalStatus(MedicalStatus medicalStatus) { MedicalStatus = medicalStatus; }

    public MedicalHistory getMedicalHistory() { return MedicalHistory; }
    public void setMedicalHistory(MedicalHistory medicalHistory) { MedicalHistory = medicalHistory; }

    public HashSet<Medication> getMedications() { return Medications; }
    public void setMedications(HashSet<Medication> medications) { Medications = medications; }
    public void addMedication(Medication medication){
        Medications.add(medication);
    }

    public String getComplain(){return Complain;}
    public void setComplain(String complain){ Complain = complain; }
    
    public TreatmentData getDoctorData(Doctor d) {return DoctorsData.get(d);}
    public void addTreatmentData(Doctor doctor, TreatmentData treatmentData){
        DoctorsData.put(doctor, treatmentData);
    }

}
