package src.models;
public class MedicalHistory{
    private Patient Patient ; 
    private PersonMH PatientMH;
    private FamilyMH PatientFamilyMH;
    public MedicalHistory(){

    }

    public MedicalHistory(Patient patient, PersonMH patientMH, FamilyMH patientFamilyMH) {
        Patient = patient;
        PatientMH = patientMH;
        PatientFamilyMH = patientFamilyMH;
    }

    public Patient getPatient() { return Patient; }
    public void setPatient(Patient patient) { Patient = patient; }

    public PersonMH getPatientMH() { return PatientMH; }
    public void setPatientMH(PersonMH patientMH) { PatientMH = patientMH; }

    public FamilyMH getPatientFamilyMH() { return PatientFamilyMH; }
    public void setPatientFamilyMH(FamilyMH patientFamilyMH) { PatientFamilyMH = patientFamilyMH; }
    
}
