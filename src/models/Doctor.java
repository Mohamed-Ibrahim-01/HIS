package src.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
public class Doctor extends Person {
    // SSN : Social Security Number MSA: Major Scientific Area
    private String SSN, MSA , Degree ; 
    private HashMap<Patient,TreatmentData> PatientsData;
    private String[] attributesNames = {"Id","Name","Address","Phone","BirthDate","Sex","SSN","MSA","Degree"};
    private String[] attributes;
    public Doctor(){
    }
    /**
     * @param params should contain 9 vars
     */
    public Doctor(String... params){
        super(params);
        SSN = params[6];
        MSA = params[7];
        Degree = params[8];
        PatientsData = new HashMap<Patient,TreatmentData>();
        attributes = params;
    }

    @Override
    public String toString(){
        return  super.toString() +  "::" + SSN + "::" + MSA + "::" + Degree;
    }

    public String getSSN() { return SSN; }
    public void setSSN(String sSN) { SSN = sSN; 
    }

    public String getMSA() { return MSA; }
    public void setMSA(String mSA) { MSA = mSA; }

    public String getDegree() { return Degree; }
    public void setDegree(String degree) { Degree = degree; }

    public Set<Patient> getPatients() {
        return PatientsData.keySet(); 
    }
    public void setPatients(HashMap<Patient, TreatmentData> patients) { PatientsData = patients; }

    public void addTreatmentData(Patient patient, TreatmentData treatmentData){
        PatientsData.put(patient, treatmentData);
    }

    public HashMap<Patient, TreatmentData> getPatientsData() {
        return PatientsData;
    }
    public TreatmentData getTreatmentData(Patient patient){
        return PatientsData.get(patient);
    }
    public boolean hasPatient(Patient patient){
        return PatientsData.containsKey(patient);
    }

    public void setPatientsData(HashMap<Patient, TreatmentData> patientsData) {
        PatientsData = patientsData;
    }

    public String[] getAttributesNames() {
        return attributesNames;
    }

    public void setAttributesNames(String[] attributesNames) {
        this.attributesNames = attributesNames;
    }

    public String[] getAttributes() {
        return attributes;
    }

    public void setAttributes(String[] attributes) {
        this.attributes = attributes;
    }

    public List<Patient> getPatientList(){
       return new ArrayList<Patient>(PatientsData.keySet());
    }
}
