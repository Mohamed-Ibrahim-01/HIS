package src.models;

import java.util.HashMap;
import java.util.HashSet;

public class Patient extends Person {
    private String AdmittanceDate, Complain,ICUname,BedNumber;
    private int conditionDegree ;  
    private MedicalStatus MedicalStatus;
    private MedicalHistory MedicalHistory;
    private HashMap<Doctor, TreatmentData> DoctorsData;
    private HashSet<Medication> Medications;
    private String[] AttributesValues;
    
    public Patient (String... params){
        super(params);
        Complain = params[6];
        AdmittanceDate = params[7];
        ICUname = params[8];
        BedNumber = params[9];
        conditionDegree =  Integer.parseInt(params[10]);
        Medications = new HashSet<Medication>();
        DoctorsData = new HashMap<Doctor, TreatmentData>();
        AttributesValues = params;
    }
    public String[][]  getPatientData(){
        String[][] patientData = new String[12][2];
        String[] attributes = new String[12], patientAttributes = {"Complain","AdmittanceDate","ICUname","BedNumber","ConditionDegree","MedicalStatus"};
        System.arraycopy(super.getAttributes(), 0, attributes, 0, 5);
        System.arraycopy(patientAttributes, 0, attributes, 6, 11);
        for(int i = 0 ; i < attributes.length ; i++){
            patientData[i][0] = patientAttributes[i];
            patientData[i][1] = AttributesValues[i];
        }
        patientData[12][1] = MedicalStatus.toString();
        return patientData;
    }
    public String getAdmittanceDate() {
        return AdmittanceDate;
    }

    public void setAdmittanceDate(String admittanceDate) {
        AdmittanceDate = admittanceDate;
    }

    public MedicalStatus getMedicalStatus() {
        return MedicalStatus;
    }

    public void setMedicalStatus(MedicalStatus medicalStatus) {
        MedicalStatus = medicalStatus;
    }

    public MedicalHistory getMedicalHistory() {
        return MedicalHistory;
    }

    public void setMedicalHistory(MedicalHistory medicalHistory) {
        MedicalHistory = medicalHistory;
    }

    public HashSet<Medication> getMedications() {
        return Medications;
    }

    public void setMedications(HashSet<Medication> medications) {
        Medications = medications;
    }

    public void addMedication(Medication medication) {
        Medications.add(medication);
    }

    public String getComplain() {
        return Complain;
    }

    public void setComplain(String complain) {
        Complain = complain;
    }

    public TreatmentData getDoctorData(Doctor d) {
        return DoctorsData.get(d);
    }

    public void addTreatmentData(Doctor doctor, TreatmentData treatmentData) {
        DoctorsData.put(doctor, treatmentData);
    }

    @Override
    public String toString() {
        return super.toString() + AdmittanceDate + Complain + " \" " + MedicalStatus.getBloodPressure() + " \""
                + MedicalHistory.getPatientMH().getChronicDiseases();
    }

    public String getICUname() {
        return ICUname;
    }

    public void setICUname(String iCUname) {
        ICUname = iCUname;
    }

    public String getBedNumber() {
        return BedNumber;
    }

    public void setBedNumber(String bedNumber) {
        BedNumber = bedNumber;
    }

    public HashMap<Doctor, TreatmentData> getDoctorsData() {
        return DoctorsData;
    }

    public void setDoctorsData(HashMap<Doctor, TreatmentData> doctorsData) {
        DoctorsData = doctorsData;
    }

    public int getConditionDegree() {
        return conditionDegree;
    }

    public void setConditionDegree(int conditionDegree) {
        this.conditionDegree = conditionDegree;
    }
 

}
