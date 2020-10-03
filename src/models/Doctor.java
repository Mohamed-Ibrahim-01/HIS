package src.models;
import java.util.UUID;

import java.util.HashMap;
public class Doctor extends Person {
    // SSN : Social Security Number MSA: Major Scientific Area
    private String SSN, MSA , Degree ; 
    private HashMap<Patient,TreatmentData> PatientsData;

    public Doctor(){
    }
    public Doctor(final String[] params){
        super(params);
        SSN = params[6];
        MSA = params[7];
        Degree = params[8];
    }

    public Doctor(UUID id,String name,String address, String phone, String birthDate, String sex, String ssn,
            String msa, String degree) {
        super(name, id, address, phone, birthDate, sex);
        SSN = ssn;
        MSA = msa;
        Degree = degree;
        PatientsData = new HashMap<Patient, TreatmentData>();
    }

    public String getSSN() { return SSN; }
    public void setSSN(String sSN) { SSN = sSN; }

    public String getMSA() { return MSA; }
    public void setMSA(String mSA) { MSA = mSA; }

    public String getDegree() { return Degree; }
    public void setDegree(String degree) { Degree = degree; }

    public HashMap<Patient, TreatmentData> getPatients() { return PatientsData; }
    public void setPatients(HashMap<Patient, TreatmentData> patients) { PatientsData = patients; }

    public void addTreatmentData(Patient patient, TreatmentData treatmentData){
        PatientsData.put(patient, treatmentData);
    }

}
